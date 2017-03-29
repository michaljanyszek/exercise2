package wdsr.exercise2.startthread;

public class MyRunnable implements Runnable {
	private NumericHelper helper;
	private FibonacciCallback callback;
	private int n;
	
	@Override
	public void run() {
		long value = helper.findFibonacciValue(n);
		callback.fibonacciComputed(value);
	}
	
	public MyRunnable(int n, FibonacciCallback callback, NumericHelper helper) {
		this.n = n;
		this.callback = callback;
		this.helper = helper;
	}
}
