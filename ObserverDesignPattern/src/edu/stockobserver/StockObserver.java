package edu.stockobserver;

public class StockObserver implements Observer {

	private double ibmPrice;
	private double applePrice;
	private double googlePrice;
	
	//static used as a counter
	private static int observerIDTracker = 0;
	
	//used to track the observers
	private int ObserverID;
	
	//will hold reference to the StockGrabber object
	private Subject stockGrabber;
	
	public StockObserver(Subject stockGrabber){
		
		//store the reference to the StockGrabber object so 
		// I can make calls to its method
		
		this.stockGrabber = stockGrabber;
		
		//Assign an observer ID and increment the static counter
		this.observerIDTracker = ++observerIDTracker;
		
		//message notifies user of the new observer
		System.out.println("New Observer "+ this.ObserverID);
		
		//Add the observer to the subjects ArrayList
		stockGrabber.register(this);
	}
	
	//called to update all observers
	@Override
	public void update(double ibmPrice, double applePrice, double googlePrice) {
		
		this.ibmPrice = ibmPrice;
		this.applePrice = applePrice;
		this.googlePrice = googlePrice;
		
		printThePrices();

	}

	private void printThePrices() {
		
		System.out.println(observerIDTracker + "\nIBM : " + ibmPrice +"\nAPPLE : "
				+ applePrice + "\nGOOGLE : "+ googlePrice + "\n");
		
	}

}
