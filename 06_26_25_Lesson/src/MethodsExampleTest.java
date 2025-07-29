/*
 * public static void main(String[] args) {
		System.out.println(MethodsExample.getNumber());
	}
 */

public class MethodsExampleTest {

	
	public static final double METERS_PER_KM = 1000.0;
	public static final double MI_PER_METER = 1.0 / 1609.344;
	
	
	
	public static void main(String[] args) {
		System.out.println("Call Number is " + MethodsExample.getNumber());
		
		System.out.println(squareFirstAndAdd(2,3));
		System.out.println(squareFirstAndAdd(3,2));
		
		
		//CAll GETMILESFORKM
		System.out.println(getMilesForKm(0)+ " Miles");
		System.out.println(getMilesForKm(1.609344)+ " Miles");
		System.out.println(getMilesForKm(1)+ " Miles");
		
		//Call getRequiredSpeedMphForKmAndHours
		System.out.println(getRequiredSpeedMphForKmAndHours(90,5));

	}

	
	public static int squareFirstAndAdd(int first, int second) {
		return first * first + second;
	}
	
	//1609.344 meters = 1 mile 
	public static double getMilesForKm(double km) {
		return km * METERS_PER_KM * MI_PER_METER;
	}
	
	public static double getAverageSpeedMph(double miles, double hours) {
		return miles / hours;
	}
		
	public static double getRequiredSpeedMphForKmAndHours(double km, double hours) {
		double mi = getMilesForKm(km);
		double requiredSpeedMph = getAverageSpeedMph(getMilesForKm(km), hours);
		return requiredSpeedMph;
	}
	
	public static double getHoursBeforeRefuelNeeded(double gallons, 
													double milesPerGallon, 
													double milesPerHour) {
	double hoursPerMile = 1.0 / milesPerHour;
	return gallons * milesPerGallon * hoursPerMile; 
	}
	
	
	
		
	
}














