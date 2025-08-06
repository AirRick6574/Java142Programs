import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class printAverage {
	public static void main(String[] args) {
		Scanner ScannerSystem = new Scanner(System.in);
		printAverage(ScannerSystem);
	}
	
	//Note for self "This method has a constructor name" is due to same name as method and class
	//Java Thinks "Wait, this method has the same name as the class... are you trying to write a constructor?"
	//Lesson try to name classes different from methods unless constructor
	public static void printAverage(Scanner ScannerSystem) { 
		List<Double> listNum = new ArrayList<>();
		double totalAverage = 0.0;
		
		//While loop Running until next input is zero
		while (true){ 
			System.out.print("Type a number: ");
			Double inputNum = ScannerSystem.nextDouble();
			if (inputNum < 0.0) {
				break;
			} else {
				listNum.add(inputNum);
			}
		}
			
		//For loop to calculate average
		for (int i = 0; i < listNum.size(); i++) { //size() is java.util.list's version of .length
			totalAverage += listNum.get(i); //get() is java.util.list's version of listnum[i] 
		}
		
		totalAverage = totalAverage / listNum.size();
		if (listNum.size() == 0){
			return;
		}
		if (listNum.get(0) >= 0.0) {
			System.out.println("Average was " + totalAverage);
		}
			
	}
}
