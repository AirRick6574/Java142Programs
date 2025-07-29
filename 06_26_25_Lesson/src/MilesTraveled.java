
public class MilesTraveled {

	public static final int FEET_PER_MILE = 5280; //Creates Public Global Variable, Final makes it unable to be changed
												  //Final Public Global Variables must be all Caps
	
	public static void main(String[] args) {
		double milesTraveledThisTrip = 5;
		//double gasDollarsSpentThisTrip = 0; //Okay can have risk of rounding, better to split into two integers
		
		int gasDollarsSpentThisTrip = 0;
		int gasCentsSpentThisTrip = 0; 
		
		int feetTraveledThisTrip = (int)(milesTraveledThisTrip * FEET_PER_MILE);
		System.out.println(feetTraveledThisTrip);
		
		//QUICK NOTE JAVA CAN TAKE MULTIPLE VARIABLES FOR PRINT STATEMENTS
		System.out.println("Miles Traveled This Trip Converted into Miles: " + feetTraveledThisTrip);
	}
}
