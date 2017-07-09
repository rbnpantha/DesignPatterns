package edu.stockobserver;

import java.text.DecimalFormat;

public class GetTheStock implements Runnable{

	private String stock;
	private double  price;
	
	//Will hold reference to the StockGrabber object
	private Subject stockGrabber;
	
	public GetTheStock(Subject stockGrabber, String newStock, double newPrice) {
		//Store the reference to the stockGrabber object so
		//I can make calls to its methods
		this.stockGrabber = stockGrabber;
		this.stock = newStock;
		this.price = newPrice;
	}
	
	
	@Override
	public void run() {
		
		for(int i = 1; i < 10; i++){
			
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
			// Generates a random number between -0.03 and 0.03
			
			double randNum = (Math.random() * (0.06)) - 0.3;
			
			//Format decimals to 2 places
			
			DecimalFormat df = new DecimalFormat("#.##");
			
			//Change the price and then convert it back into a double
			price = Double.valueOf(df.format(price + randNum));
			
			if(stock == "IBM") ((StockGrabber) stockGrabber).setIBMPrice(price);
			if(stock == "APPL") ((StockGrabber) stockGrabber).setApplePrice(price);
			if(stock == "GOOG") ((StockGrabber) stockGrabber).setGooglePrice(price);
			
			System.out.println(stock + " : " + df.format((price + randNum)) + " " + df.format(randNum));
			
			System.out.println();
		}
		
	}

}
