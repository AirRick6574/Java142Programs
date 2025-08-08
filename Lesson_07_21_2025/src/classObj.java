import java.util.Scanner;

//Static means we dont have to use a instance of a class to use the method

public class classObj {
	
	public static int NumberOfPeople; //this belongs to the whole class and not just a instance
	
	private String name;
	
	private String firstName;
	
	private String middleName;
	
	//Private methods dont need javadocs but need comments
	private String lastName;
	
	private int[] dateOfBIrth = new int[3]; 
	
	private Scanner scannerSystem;
	
	private double creditsEarned;
	
	public boolean currentlyEnrolled;
	
	//Constructor, runs when instance is created
	public classObj() {
		NumberOfPeople++; 
	}
	
	//multiple constructors can exist at the same time
	public classObj(String firstName, String lastName) {
		this(); //this will call the other constructor. () are used for parameters
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	
	//if default constructor does not exist and it tries a custom constructor, every new class will have errors. 
	
	
	public void setNames(String firstName, String middleNames, String lastName) {
		this.firstName = firstName; //This refers to the current object in a keyword or constructor 
		this.middleName = middleNames;
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String fullNameFirstNameFirst() {
		return firstName + " " +  middleName + " " + lastName;
	}
	
	//message OverRide will notify the compiler that this was just overwritten
	@Override
	//issue with this is that original equals method takes a object parameter, not a classobj paramter
	public boolean equals(Object object) { 
		if (object instanceof classObj) {
			classObj personObj = (classObj) object;
			return (personObj.firstName == this.firstName 
					&& personObj.middleName == this.middleName 
					&& personObj.lastName == this.lastName);
		}
		return false;
		
		
	}
	
}
