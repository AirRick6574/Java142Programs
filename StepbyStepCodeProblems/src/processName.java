import java.security.PublicKey;
import java.util.Scanner;

public class processName {
	public static void processName(Scanner S) {
		System.out.print("Please enter your full name: ");
		String firstName = S.next(); 
		String lastName = S.next(); 
		
		System.out.println("Your name in reverse order is " + lastName + ", " + firstName);
	}
	
	public static void MultiplyInputNum() {
		Scanner ScannerSystem = new Scanner(System.in);
		System.out.print("Type an integer: ");
		int inputNum = ScannerSystem.nextInt(); 

		int inputNumX2 = inputNum * 2;

		System.out.println(inputNum + " times 2 = " + inputNumX2);




	}
	
	public static void main(String[] args) {
		Scanner ScannerSystem = new Scanner(System.in);
		processName(ScannerSystem);
		
		MultiplyInputNum();
	}
}
