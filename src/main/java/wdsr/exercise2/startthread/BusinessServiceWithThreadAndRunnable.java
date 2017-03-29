package wdsr.exercise2.startthread;

public class BusinessServiceWithThreadAndRunnable {
	private NumericHelper helper;
	
	public BusinessServiceWithThreadAndRunnable(NumericHelper helper) {
		this.helper = helper;
	}

	/**
	 * Calculates Fibonacci number asynchronously and invokes the callback when result is available.
	 * This method returns immediately. 
	 * @param n Which Fibonacci number should be computed.
	 * @param callback Callback to be invoked when Fibonacci number is found.
	 */
	public void computeFibonacci(int n, FibonacciCallback callback) {
		// TODO Task: execute the logic below in a new Thread, use Runnable interface.
		new Thread(new MyRunnable(n, callback, helper)).start();
	}
}
