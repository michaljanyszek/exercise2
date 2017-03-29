package wdsr.exercise2.procon;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/**
 * Task: implement Buffer interface using one of *Queue classes from java.util.concurrent package.
 */
public class BufferQueueImpl implements Buffer {
    private BlockingQueue<Order> blockingQueue= new ArrayBlockingQueue<Order>(50000);
    
	public void submitOrder(Order order) throws InterruptedException {
		blockingQueue.put(order);
	}
	
	public Order consumeNextOrder() throws InterruptedException {
		return blockingQueue.take();
	}
}
