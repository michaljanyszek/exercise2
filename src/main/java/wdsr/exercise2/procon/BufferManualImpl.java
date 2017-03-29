package wdsr.exercise2.procon;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Task: implement Buffer interface without using any *Queue classes from java.util.concurrent package.
 * Any combination of "synchronized", *Lock, *Semaphore, *Condition, *Barrier, *Latch is allowed.
 */
public class BufferManualImpl implements Buffer {
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private ArrayList<Order> orderList = new ArrayList<>(500000);
    
	public void submitOrder(Order order) throws InterruptedException {
        lock.lock();
        try {
            while (orderList.size() == 500000) {
                notFull.await();
            }
            orderList.add(order);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
	}
	
	public Order consumeNextOrder() throws InterruptedException {
        Order order = null;
        lock.lock();
        try {
            while (orderList.isEmpty()) {
                notEmpty.await();
            }
            order = orderList.remove(0);
            notFull.signal();
            return order;
        } finally {
            lock.unlock();
        }
	}
}
