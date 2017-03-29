package wdsr.exercise2.counter;

/**
 * Created by Marek on 05.03.2016.
 * 
 * Task: use 'synchronized' keyword in this file to make SimpleCountingFacadeTest pass.
 */
public class SimpleCountingFacade implements CountingFacade {
	private final BusinessService businessService;
	
	private int invocationCounter;
	
	public SimpleCountingFacade(BusinessService businessService) {
		this.businessService = businessService;
	}
	
	public void countAndInvoke() {
        synchronized(this){
        invocationCounter++;
        }
        
		businessService.executeAction();
	}
	
	public int getCount() {
		return invocationCounter;
	}
}
