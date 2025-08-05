//Exmaple of the Structure of the chain if statement 
//Used for formatting


public class ChainIfStructure {
	
	public static int NEEDEDHOPPOUCHES = 0; 
	
	public static void compareDollars(double alyssaDollars, double bobDollars) {
		if (alyssaDollars > bobDollars) {
			System.out.println("Alyssa has " + (alyssaDollars - bobDollars)
					+ " more dollars than Bob.");
			}
		if (alyssaDollars == bobDollars) {
			System.out.println("Both children have the same amount.");
			}
		if (bobDollars > alyssaDollars) {
			System.out.println("Bob has " + (bobDollars - alyssaDollars)
					+ " more dollars than Alyssa.");
			}
		}
	
	public static void main(String[] args) {
		if (NEEDEDHOPPOUCHES == 0) {
			System.out.println("No Hops");
		} else {
			if (NEEDEDHOPPOUCHES == 1) {
				System.out.println("One Pouch of Hops");
			} else {
				System.out.println(NEEDEDHOPPOUCHES + "pouches of hops");
			}
		}
	}
	
	

}


