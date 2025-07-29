/* 
the recipe you have brews 5 gallons of beverage and needs 15 oz of hops, 12.5 lbs of malt, and 1 packet of yeast.
Hops are sold in pouches of 2 oz each for $3.99 but you can buy the exact amount of malt you need at$ 
1.50 per lb using a precise scale.

5 gallons = 15oz hops, 12.5ibs of malt, 1 packet of yeast

hops = 2oz for 3.99 
exactamount(malt 1.50/ib
Yeast packets are $2.59

15hops/5 

 
*/

//import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

//import java.util.PrimitiveIterator.OfDouble;

import java.util.PrimitiveIterator.OfDouble;

/**
 * A utility to calculate the quantities of ingredients to purchase to make 
 * a given quantity of beer.
 * 
 * @author Erick Ruiz
 */


public class HoppyBeverage {
	
	/**
	 * The number of gallons of beer in one recipe batch.
	 */
	
	double myGallons = 7; 
	public static final double GALS_BEER_PER_BATCH = 5.0;
	/**
	 * Fractional number of batches of beer constituted by one gallon of beer
	 */
	
	public static final double BATCHES_BEER_PER_GALLON = 1.0 / GALS_BEER_PER_BATCH;
	/**
	 * 
	 */
	
	public static final double OZ_HOPS__PER_BATCH = 15.0;
	public static final double OZ_HOPS__PER_POUCH = 2.0;
	public static final double POUCHES_HOPS_PER_OZ = 1.0 / OZ_HOPS__PER_POUCH;
	public static final double POUNDS_OF_MALT_PER_BATCH = 12.5;
	public static final double PACKETS_PER_BATCH = 1.0/5.0;
	
	public static final double PRICE_POUCH_HOPS_USD = 3.99; 
	public static final double PRICE_POUND_MALT_USD = 1.50; 
	public static final double PRICE_PACKET_YEAST_USD = 2.59; 
	
	
	/**
	 * Calculate the whole number of pouches of hopes needed to make
	 * the specified gallons of beer
	 * 
	 * @param gallonsOfBeer the number of beer desired
	 * @return The whole number of pouches of hops needed to make the specified gallons of beer.
	 */

	
	
	public static int pouchesOfHops(double gallonsOfBeer) {
		//System.out.println("Fractional Hops needed: " + ((gallonsOfBeer * BATCHES_BEER_PER_GALLON) * OZ_HOPS__PER_BATCH) * POUCHES_HOPS_PER_OZ);
		
		double fractionalPouchesNeeded = (((gallonsOfBeer * BATCHES_BEER_PER_GALLON) 
				* OZ_HOPS__PER_BATCH) * POUCHES_HOPS_PER_OZ);
			
		//Return integer rounded up
		return (int) Math.ceil(fractionalPouchesNeeded);
		
		
	}
		
	public static double poundsOfMalt(double gallonsOfBeer) {
		//System.out.println("Pounds of malt needed: " + (gallonsOfBeer * BATCHES_BEER_PER_GALLON * POUNDS_OF_MALT_PER_BATCH));
		return  gallonsOfBeer * BATCHES_BEER_PER_GALLON * POUNDS_OF_MALT_PER_BATCH;
		
	}	
		
	public static int packetsOfYeast(double gallonsOfBeer) {
		System.out.println(gallonsOfBeer * (1.0/5.0));
		
		//return gallonsOfBeer * (1.0/5.0) ;
		
		double FractionalPacketsNeeded = (gallonsOfBeer * PACKETS_PER_BATCH);
		//System.out.println(Math.ceil(FractionalPacketsNeeded));
		return (int) Math.ceil(FractionalPacketsNeeded);
		 
	}
	
	//7 batches * (1 packet/5 batches )
		
	/**
	 * 
	 * @param totalCost
	 * @return 
	 */
	public static double totalCost(double gallonsOfBeer){
		
		int numPouchesOfHopsNeeded = pouchesOfHops(gallonsOfBeer);
		double numPoundsMaltNeeded = poundsOfMalt(gallonsOfBeer);
		double numPacketsOfYeastNeeded = packetsOfYeast(gallonsOfBeer);
		
		//System.out.println("Price of PouchesHops: " + (numPouchesOfHopsNeeded * PRICE_POUCH_HOPS_USD));
		//System.out.println("Price of PoundsPerMalt: " + (numPoundsMaltNeeded * PRICE_POUND_MALT_USD));
		//System.out.println("Price of packetsperyeast: " + (numPacketsOfYeastNeeded * PRICE_PACKET_YEAST_USD));
		
		double totalCost = (numPouchesOfHopsNeeded * PRICE_POUCH_HOPS_USD) 
					+ (numPoundsMaltNeeded * PRICE_POUND_MALT_USD) 
					+ (numPacketsOfYeastNeeded * PRICE_PACKET_YEAST_USD);
		
		
		
		return totalCost;
	}
	
	public static void main(String[] args) {
		double gallonsBeerDesired = 7.0;
		System.out.println("------Pouches of hops needed = " + pouchesOfHops(gallonsBeerDesired));
		System.out.println("------Total Cost = " + totalCost(gallonsBeerDesired)); //Approximately 75.32
		
		//System.out.println("------Total Cost = " + totalCost(0.0)); //Should be zero 
		//System.out.println("------Total Cost of 5 Gallons: " + totalCost(5.0)); //Should be 
		
	}

}


