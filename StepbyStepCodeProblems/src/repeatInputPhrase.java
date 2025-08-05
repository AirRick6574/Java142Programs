import java.util.Iterator;
import java.util.Scanner;

public class repeatInputPhrase {
	public static void main(String[] args) {
		Scanner ScannerSystem = new Scanner(System.in);
		System.out.print("What is your phrase? ");
		
		String inputString = ScannerSystem.nextLine();
		
		
		System.out.print("How many times should I repeat it? ");
		int inputInt = ScannerSystem.nextInt();
		
		for (int i = 0; i < inputInt; i++) {
			System.out.println(inputString);
			
		}
			
	}
}
