//Floating Point Example 
public class Lesson06_25_25 {
	public static void main(String[] args) {
		System.out.println(1.0 / 5.0); //Float Calculation Are Approximations!!
		System.out.println(1.0 / 3.0); //Accurate to within 10^16 and then will round 
		System.out.println("1.0 / 5.0"); //String Notation, Explicit 
		
		int NumberOfFingersUp = 5; //Initialized variable as an int and given a variable
		double shoesSize = 5.5; //Initialized variable as an double and given a variable
		String PersonName = "Bob"; //Initialized variable as an String and given a variable
		
		NumberOfFingersUp = 4;
		
		System.out.print("Number of Fingers up: ");
		System.out.println(NumberOfFingersUp);
		
		System.out.println(shoesSize);
		System.out.println(PersonName);	
		
		System.out.println(7 + NumberOfFingersUp * printName(NumberOfFingersUp));
		
		System.out.println(printName(NumberOfFingersUp));	

	}
	
	//Press cmd + / to auto comment a line
	
	
	public static int printName(int name) {
		int numberOfFingersUp = 7; //Different from Previous main Method because 
		System.out.println("Lines Has Ran");//it has not been made global and instead only resides in printName
		return numberOfFingersUp;
	}
}



