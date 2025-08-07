import java.util.Scanner;

public class sumMax {
	public static void main(String[] args) {
		evenSumMax();
	}
	
	public static void evenSumMax() {
		Scanner ScannerSystem = new Scanner(System.in);
		
		int intMax = 0;
		int intSum = 0;
		
		System.out.print("how many integers? ");
		int intLoop = ScannerSystem.nextInt();
		
		for (int i = 0; i < intLoop; i++) {
			System.out.print("next integer? ");
			
			int intInputValue = ScannerSystem.nextInt();
			
			if (intInputValue % 2 != 0) {
				continue;
			}
			
			intSum += intInputValue;
			if (intMax <= intInputValue) {
				intMax = intInputValue;
			}
		}
		System.out.println("even sum = " + intSum);
		System.out.println("even max = " + intMax);
	}
}
