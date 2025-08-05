package test;

public class ComputePayDupe {
    public static final double HOURLYSALARY = 8.75; 
    public static final double TAXRATE = 0.20;

    public static void main(String[] args) {
        int hoursWorked = (4 + 5 + 8 + 4);
        double taxesOwed = (double) ((hoursWorked) * HOURLYSALARY * TAXRATE);
        double totalPay = ((hoursWorked) * HOURLYSALARY);

        // Calculate pay at work based on hours worked each day
        System.out.println("My total hours worked:");
        System.out.println(hoursWorked);

        System.out.println("My hourly salary:");
        System.out.println(HOURLYSALARY);

        System.out.println("My total pay:");
        System.out.println(totalPay);

        System.out.println("My taxes owed:"); // 20% tax
        System.out.println(taxesOwed);
    }
}
