//Rewrite using lists to prevent constant redeclarations of variables

public class Step_Step_Test_Salary {
	public static double computeTax(int salary){
	    //Bracket 1
	    if (salary >= 0 && salary <= 7150){
	    	System.out.println("Ran 1");
	        int flatAmount = 0;
	        double plusPercent = 0.10;
	        int excessOver = 0;

	        return (double) (((salary - excessOver) * plusPercent) + flatAmount);
	    }

	    //bracket 2
	    else if (salary >= 7150 && salary <= 29050){
	        int flatAmount = 715;
	        double plusPercent = 0.15;
	        int excessOver = 7150;

	        return (double) (((salary - excessOver) * plusPercent) + flatAmount);
	    }

	    //bracket 3
	    else if (salary >= 29050 && salary <= 70350){
	        int flatAmount = 4000;
	        double plusPercent = 0.25;
	        int excessOver = 29050;

	        return (double) (((salary - excessOver) * plusPercent) + flatAmount);
	    }

	    //bracket 4
	    else {
	        int flatAmount = 14325;
	        double plusPercent = 0.28;
	        int excessOver = 70350;

	        return (double) (((salary - excessOver) * plusPercent) + flatAmount);
	    }
	}
	
	public static void main(String[] args) {
		//Salary Test
		System.out.println("Salary: 6000. Tax is: " + computeTax(6000));
		System.out.println("Salary: 50,000. Tax is: " + computeTax(50000));
		System.out.println("Salary: 275000. Tax is: " + computeTax(27500));
		System.out.println("Salary: 120000. Tax is: " + computeTax(120000));
	}
	
	
}
