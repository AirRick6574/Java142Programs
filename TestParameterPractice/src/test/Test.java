package test;

public class Test {

	public static void main(String[] args) {
		// 1.
		System.out.print("1. ");
		int a = 1;
		method1(a);
		
		// 2.
		System.out.print("2. ");
		String b = "hi";
		method2(b);
		
		// 3.
		System.out.print("3. ");
		double c = 3.0;
		method3(c);
		
		/* These variable assignments apply to exercises 4–12 */
		 int d = 4;
		 int e = 5;
		
		 // 4.
		 System.out.print("4. ");
		 method4(d, e);
		
		 // 5.
		 System.out.print("5. ");
		 method5(d, e);
		
		 // 6.
		 System.out.print("6. ");
		 method6(d, e);
		
		 // 7.
		 System.out.print("7. ");
		 method4(e, d);
		
		 // 8.
		 System.out.print("8. ");
		 method6(e, d);
		
		 // 9.
		 System.out.print("9. ");
		 method7(d, e);
		 
		// 10.
		  System.out.print("10. ");
		  method7(e, d);
		 
		  // 11.
		  System.out.print("11. ");
		  method8(d, e);
		 
		  // 12.
		  System.out.print("12. ");
		  method8(e, d);
		 
		 /* These assignments apply to exercises 13–17 */
		 String aardvark = "aardvark";
		 String baboon = "baboon";
		 
		// 13.
		  System.out.print("13. ");
		  method9(aardvark, baboon);
		 
		  // 14.
		  System.out.print("14. ");
		  method10(aardvark, baboon);
		 
		  // 15.
		  System.out.print("15. ");
		  method11(aardvark, baboon);
		 
		  // 16.
		  System.out.print("16. ");
		  method12(aardvark, baboon);
		 
		  // 17.
		  System.out.print("17. ");
		  method12(baboon, aardvark);
		 
		 /* This value change applies to all exercises below */
		  aardvark = baboon;
		  baboon = "aardvark";
		 
		  // 18.
		  System.out.print("18. ");
		  method9(aardvark, baboon);
		 
		  // 19.
		  System.out.print("19. ");
		  method9(baboon, aardvark);
		 
		  // 20.
		  System.out.print("20. ");
		  method10(aardvark, baboon);
		
		  // 21.
		  System.out.print("21. ");
		 method10(baboon, aardvark);
		 
		  // 22.
		  System.out.print("22. ");
		  method11(aardvark, baboon);
		 
		  // 23.
		  System.out.print("23. ");
		  method11(baboon, aardvark);
		 
		  // 24.
		 System.out.print("24. ");
		 method12(aardvark, baboon);
		 
		  // 25.
		  System.out.print("25. ");
		  method12(baboon, aardvark);
		 
	}
	
		public static void method1(int a) {
		System.out.println(a);
		}
	
		public static void method2(String myString) {
		 System.out.println(myString);
		 }
	
		public static void method3(double c) {
		System.out.println(c + 1);
		}
	
	
		
		 public static void method4(int d, int e) {
		 System.out.println(d + " is better than " + e);
		 }
		
		 public static void method5(int first, int second) {
		 System.out.println(first + " is better than " + second);
		 }
		
		 public static void method6(int e, int d) {
		 System.out.println(d + " is better than " + e);
		 }
		
		 public static void method7(int d, int e) {
		 System.out.println(e + " is better than " + d);
		 }
		
		 public static void method8(int e, int d) {
		 System.out.println(e + " is better than " + d);
		 }
		
		 public static void method9(String aardvark, String baboon) {
		 System.out.println("The " + aardvark + " is smarter than the " + baboon + ".");
		 }
		
		public static void method10(String baboon, String aardvark) {
		 System.out.println("The " + aardvark + " is smarter than the " + baboon + ".");
		 }
		
		 public static void method11(String baboon, String aardvark) {
		 System.out.println("The " + baboon + " is smarter than the " + aardvark + ".");
		 }
		
		 public static void method12(String aardvark, String baboon) {
		 System.out.println("The " + baboon + " is smarter than the " + aardvark + ".");
		 }
}


