import java.util.Scanner;

public class minMax {
	public static void main(String[] args) {
		int numMax = -999999;
		int numMin = 999999;
		
		Scanner ScannerSystem = new Scanner(System.in);
		
		while (true) {
			
			System.out.print("Type a number (or -1 to stop): ");
			int inputInt = ScannerSystem.nextInt();
			
			if (inputInt == -1) {
				break;
			}
			if (inputInt > numMax){
				numMax = inputInt;
			}
			if (inputInt < numMin) {
				numMin = inputInt;
			}
			
		}
		
		if (numMin != 999999){
			System.out.println("Maximum was " + numMax);
			System.out.println("Minimum was " + numMin);
		}
	}
}
