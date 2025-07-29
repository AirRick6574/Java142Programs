//Ds = As * Bs_PER_A * Cs_PER_B * Ds_PER_C;
public class VelocityConverter_07_01 {
		
	public static final double FEET_PER_MILE = 5280.0;
	public static final double INCHES_PER_FOOT = 12;
	public static final double CM_PER_INCH = 2.54;
	public static final double CM_PER_METER = 100.0;
	public static final double METERS_PER_CM = 1.0 / CM_PER_METER;
	
	
	public static final double MINS_PER_HR = 60.0;
	public static final double HOURS_PER_MINS = 1.0/MINS_PER_HR;
	public static final double SECONDS_PER_MIN = 60.0;
	public static final double MINS_PER_SEC = 1.0 / SECONDS_PER_MIN;
	
	public static double convertMphToMetersPerSec(double mph) {
		double metersPerSec =  mph * FEET_PER_MILE * INCHES_PER_FOOT * CM_PER_INCH  * METERS_PER_CM 
				* HOURS_PER_MINS * MINS_PER_SEC;
		
		return metersPerSec;
	}
	
	public static void main(String[] args) {
		System.out.println(convertMphToMetersPerSec(0.0));
		System.out.println(convertMphToMetersPerSec(17.0));
		System.out.println(convertMphToMetersPerSec(17.0));
		if (convertMphToMetersPerSec(15) > 20) {
			System.out.println("testFailed");
		}else {
			System.out.println("TESTPASSED");
		}
	}
}



