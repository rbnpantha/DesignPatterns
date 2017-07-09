package edu.stockobserver;

import java.net.NetworkInterface;
import java.util.ArrayList;

//implements the Subject interface to update all Observers
public class StockGrabber implements Subject {

	private ArrayList<Observer> observers;
	private double ibmPrice;
	private double applePrice;
	private double googlePrice;

	public StockGrabber() {

		// creates an ArrayList to hold all the observers
		observers = new ArrayList<Observer>();
	}

	@Override
	public void register(Observer newObserver) {

		// adds a new observer to the ArrayList
		observers.add(newObserver);
	}

	@Override
	public void unregister(Observer deleteObserver) {

		// get the index of the observer to delete
		int index = observers.indexOf(deleteObserver);

		// removes observer from the ArrayList
		observers.remove(index);

		// print out the message (have to increment index to match)
		System.out.println("Observer " + (index + 1) + " deleted!");

	}

	@Override
	public void notifyObserver() {

		// Cycle through all the observers and notifies them of price changes

		for (Observer observer : observers) {

			observer.update(ibmPrice, applePrice, googlePrice);
		}
	}

	public void setIBMPrice(double newIBMPrice) {
		this.ibmPrice = newIBMPrice;
		notifyObserver();
	}

	public void setApplePrice(double newApplePrice) {
		this.applePrice = newApplePrice;
		notifyObserver();
	}

	public void setGooglePrice(double newGooglePrice) {
		this.googlePrice = newGooglePrice;
		notifyObserver();
	}
}