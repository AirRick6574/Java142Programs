import java.security.PublicKey;
import java.util.Scanner; //Import Scanner Class used for getting user input

public class Java_USER_INPUT {
	public static void main(String[] arg) {
		String inputedUserNameString = inputCall();
	    System.out.println("Username is: " + inputedUserNameString);  // Output user input
	    
	    checkIfMatchedName(inputedUserNameString);
	}
	
	public static String inputCall() {
		public myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter username");
	    return myObj.nextLine();  // Read user input
	   
	}
	
	public static void checkIfMatchedName(String testName) {
		System.out.println(testName == "Fortnite");
		if (testName == "Fortnite") {
			System.out.println("TESTTT");	
		}
	   
	}
}
