
public class LessonClass {

	public static void main(String[] args) {
		int x = 7;
		int y = x * x;
		
		System.out.println(y);
		x = -2;
		System.out.println(y);
		y = x * x; 
		System.out.println(y);
		
		int bobsAgeYears = 77; //Example of a good variable name according to professor. 
		
		double feetPerMiles = 5280;
		int distanceTraveledFeet = (int)(230* feetPerMiles);//Since distanceTraveledFeet must return as a integer while feetPerMiles 
		System.out.println(distanceTraveledFeet);			//is a floating number. We can multiply the returning variable 
															//as a integer to convert it to comply with variable.
			
	}
	
}
