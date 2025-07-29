
public class OperatorExmaples {
	public static void main(String[] args) {
		int quotient = 17/5; //output will be 3 with remainder of 2 but since its integer, only 3 will output
		System.out.println(quotient);
		
		double dblQuotient = 17/5; //output will be 3.0 with remainder of 2 but since its /, only 3 will show should since 
		System.out.println(dblQuotient); // / will take the output and not remainder 
		
		double Test = 5-17/5+9; //Orders of operation, output will be 11.0
		System.out.println(Test); 
		
		int remainder = 17 % 5; // Will only take remainder
		System.out.println(remainder); //Will only print remainder after division has been done
		
		
		//Considered Jumping Ahead
		
		boolean isEven = false; //defines new variable as boolean false
		if (remainder % 2 == 0) {//If remainder variable divided by 2 has an output of 0, if statement will apply
			isEven = true; //changes variable as boolean true
			}
		
		boolean isEven2 = remainder % 2 == 0; //Simpler way to do previous expression
		
		System.out.println(isEven);
		System.out.println(isEven2);
		
		remainder++; //Basically open variable, add one and return to variable equivalent to remainder = remainder + 1
		remainder++; //Basically open variable, remove one and return to variable equivalent to remainder = remainder - 1
		
		int a = 5;
		System.out.println(a);
		int b = ++a; // b will be 6, and a will also be 6
		System.out.println(b);
		
		System.out.println(5 < -5); //will print false 
		System.out.println(5 != 6); //will check if 5 is not equal to 6 and will print true
		
		int difference = 7 - 5;
		int opposite = -difference;
		
		System.out.println(difference);
		System.out.println(opposite);
		
		
		
		
	}
}

