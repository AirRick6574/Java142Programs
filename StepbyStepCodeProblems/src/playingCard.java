import java.util.Scanner;

public class playingCard {
	public static void main(String[] args) {
		
		//Intial Variable Strings 
		//One is used for array styling (Wont be used) 
		/*
		String[] ranksOutput = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Joker", "Queen", "King", "Ace"};
		String[] ranksInputs = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		String[] suitsOutput = {"Clubs", "Hearts", "Diamonds", "Spades"};
		String[] suitsInput = {"C", "H", "D", "S"};
		*/
		
		Scanner ScannerSystem = new Scanner(System.in);
		
		String rankOutput = null;
		String suitOutput = null;
		
		//Input System
		System.out.print("Enter a card: ");
		String rankInput = ScannerSystem.next();
		String suitInput = ScannerSystem.next();
		
		//System.out.println(rankInput.toUpperCase());
		//System.out.println(suitInput);
		
		switch (rankInput.toUpperCase()) {
		case "2":  rankOutput = "Two"; break; //break is needed to break program if condition is true
		case "3":  rankOutput = "Three"; break; //as we do not to want to continue checking cases
		case "4":  rankOutput = "Four"; break;
		case "5":  rankOutput = "Five"; break;
		case "6":  rankOutput = "Six"; break;
		case "7":  rankOutput = "Seven"; break;
		case "8":  rankOutput = "Eight"; break;
		case "9":  rankOutput = "Nine"; break;
		case "10":  rankOutput = "Ten"; break;
		case "J":  rankOutput = "Jack"; break;
		case "Q":  rankOutput = "Queen"; break;
		case "K":  rankOutput = "King"; break;
		case "A":  rankOutput = "Ace"; break;
		default: rankOutput = "<Invalid input>"; break; //in case input is not allowed, will print this 
		}
		
		switch (suitInput.toUpperCase()) {
		case "C":  suitOutput = "Clubs";  break;
		case "H":  suitOutput = "Hearts";  break;
		case "D":  suitOutput = "Diamonds";  break;
		case "S":  suitOutput = "Spades";  break;
		default: suitOutput = "<Invalid input>";  break; //in case input is not allowed, will print this 
		}
		
		System.out.println(rankOutput + " of " + suitOutput);
	}
}
