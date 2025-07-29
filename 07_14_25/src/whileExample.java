

public class whileExample {
	
	private static final int SMALLEST_PRIME = 2;

	public static void main(String[] arg) {
		int i = 0;
		while (i<10) {
			System.out.println(i);
			i++;
		}
		System.out.println("End");
		
		int a = 0;
		int b = 2;
		
		if (a == b); { //(Semicolon will separate block and will just run if (a==b);
			System.out.println("a");
		}
		
		while (a < b) {
			System.out.println("A == b"); //will run forever 
			a++; //will iterate and prevent from infinite loop
		}
		
		System.out.println("\nTest Multiples");
		System.out.println("Factor 2, multiple 15");
		multiples(2, 15);
		
		System.out.println("\nTest Multiples2");
		System.out.println("Factor 2, multiple 15");
		multiples2(2, 15);
		
		int power = (int) Math.pow(3, 5);
		System.out.println("\n" + power);
		
		System.out.println("\nPower = " + power(3, 5));
		
		System.out.println("\nPower = " + power(3, 0));
		
		System.out.println(); 
		System.out.println(isPrime(2)); //should display True
		System.out.println(isPrime(3)); //should display True
		System.out.println(isPrime(4)); //should display false
		System.out.println(isPrime(21)); //should display false
		System.out.println(isPrime(22)); //should display false
		System.out.println(isPrime(23)); //should display true
		System.out.println(isPrime(-3)); //should display false
		System.out.println(isPrime(1)); //should display false
		System.out.println(isPrime(-1421512)); //should display false
		
		System.out.println(); 
		
		System.out.println(isPrime2test(2)); //should display True
		System.out.println(isPrime2test(3)); //should display True
		System.out.println(isPrime2test(4)); //should display false
		System.out.println(isPrime2test(21)); //should display false
		System.out.println(isPrime2test(22)); //should display false
		System.out.println(isPrime2test(23)); //should display true
		System.out.println(isPrime2test(-3)); //should display false
		System.out.println(isPrime2test(1)); //should display false
		System.out.println(isPrime2test(-1421512)); //should display false
	}
	
	public static void multiples(int factor, int numMultiples) {
		int i = 1;
		while ( i <= numMultiples) {
			int multiple = factor * i;
			System.out.println(multiple);
			i++;
		}
	}
	
	public static void multiples2(int factor, int numMultiples) {
		int i = 1;
		while (i <= numMultiples) {
			System.out.println(factor * numMultiples);
			numMultiples--;
		}
	}
	
	public static void multiples3(int factor, int numMultiples) {
		int i = 1;
		int multiple = factor; 
		while (i <= numMultiples) {
			System.out.println(multiple);
			multiple = multiple + factor;
			i++;
		}
	}
	
	public static void multiplesWithoutMultiplication(final int factor, final int numMultiples) {
		
	}
	
	public static int power(int base, int exponent) {
		
		int count = 0;
		int powerSoFar = 1;
		while (count < exponent) {
			powerSoFar = powerSoFar * base;
			count++;
		}
		
		return powerSoFar;
	}
	
	public static boolean isPrime(int n) {
		if (n < SMALLEST_PRIME) {
			return false;
		}
		
		int candidateDivisor = SMALLEST_PRIME;
		while(candidateDivisor < n) {
			if (n % candidateDivisor == 0) {
				return false;
			}
			candidateDivisor++;
		}
		return true;
	}
	
	public static boolean isPrime2test(int n) {
		if (n < SMALLEST_PRIME) {
			return false;
		}
		
		int candidateDivisor = SMALLEST_PRIME;
	
		if (n % candidateDivisor == 0) {
			return false;
		}
		candidateDivisor++;
		
		return true;
	}
}
