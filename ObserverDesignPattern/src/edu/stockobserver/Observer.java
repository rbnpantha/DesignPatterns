package edu.stockobserver;

//The observer's update method is called when the subject changes
public interface Observer {

	public void update(double ibmPrice, double applePrice, double googlePrice);
}
