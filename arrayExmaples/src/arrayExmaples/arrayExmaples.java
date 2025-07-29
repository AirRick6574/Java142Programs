package arrayExmaples;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

import javax.security.sasl.RealmCallback;

public class arrayExmaples {
	static int[] intArray = {1, 2 , 3}; //style calls for bracket near type declaration
	//ONCE LENGTH IS MADE AND SET, ITS LENGTH CANNOT BE CHANGED, NO NEW VARIABLES CAN BE ADDED
	
	static String[] stringArray = {"String1", "string2", "String3"};
	
	public static void main(String[] agrs) {
		System.out.println(intArray[0]);
		
		System.out.println("StringArray 1" + stringArray[1]);
		
		System.out.println("StringArray 2" + stringArray[2]);
		
		intArray[2] = 69;
		System.out.println("intarray 2" + intArray[2]);
		
		int arrayLength = intArray.length;
		System.out.println("arraylength " + arrayLength);
		
		System.out.println();
		
		for(int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]+ " ");
		}
		
		//printIntArray(intArray);
		
		System.out.println("Print OUT");
		System.out.println(getSum(intArray));
		
		//Print out nothing 
		int[] emptyArray = {};
		System.out.println(getSum(emptyArray));
		
		int[] oneElement = {-7};
		System.out.println(getSum(oneElement));
		
		int[] largeArray = {-7, -1, 0, 5, 15, 234232, 19, 9};
		int[] smallNums = {-1000000000};
		System.out.println(getLargest(largeArray));
		
		System.out.println(Arrays.toString(intArray)); //Also prints it properly
		
		//System.out.println(la);
		int[] intArray2 = {1,2,3};
		doubleElements(intArray2);
		System.out.println("Fortnite!" + Arrays.toString(intArray2));
		
		int integer = 256;
		doubleInteger(integer);
		
		double realNumber = 17.777;
		String message = "I love nduja";
		String[] assertations = {"Grass is Green", "Snow is white"};
		
		monkeyWith(integer, realNumber, message, smallNums, assertations);
		
		System.out.println(integer);//256
		System.out.println(realNumber);//17.777
		System.out.println(message); //I love nduja
		System.out.println(smallNums[0]); //-9
		System.out.println(assertations[1]);
		int[] largeArray2 = {-7, -1, 0, 5, 15, 234232, 19, 9, 10, 9};
		int[] largeArray3 = {-7, -1, 0, 5, 15, 234232, 19, 9, 10};
		System.out.println(containsDUplicated(largeArray2));
		System.out.println(containsDUplicated(largeArray3));
		
	}
	
	public static void printIntArray(int[] intArray) {
		System.out.print("[");
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}
		System.out.println("]");
	}
	
	public static int getSum(int[] addends) {
		int runningCount = 0;
		for (int i = 0; i < addends.length; i++) {
			runningCount += addends[i];
		}
		return runningCount;
	}
	
	/** 
	 * Find the largest value in a integer array.
	 * @param ints A non-empty array
	 * @return largest integer in the array.
	 */
	public static int getLargest(int[] ints) {
		int largestSoFar = ints[0];
		
		for (int i = 0; i < ints.length; i++) {
			if (ints[i] > largestSoFar) {
				largestSoFar = ints[i];
			}
		}
		return largestSoFar;
	}
	
	public static int[] doubleIntegersAndPrint(int[] integers) { //broken
		for (int i = 0; i < integers.length; i++) {
			integers[i] += integers[i] * 2;
			System.out.println(integers[i]);
		}
		int[] emptyArray = {};
		//integers = null; //represents nothing
		integers = emptyArray;
		return integers;
	}
	
	public static void doubleElements(int[] integers) {
		for (int i = 0; i < integers.length; i++) {
			integers[i] += integers[i] * 2;
			
		}
		int[] emptyArray = {};
		//integers = null; //represents nothing
		integers = emptyArray;
	
		
	}
	
	public static void doubleInteger(int integer) {
		integer = integer * 2;
	}
	
	public static void monkeyWith(int integer, double realNumber, String message, int[] integers, 
							   	  String[] messages) {
		integer = integer + 5;
		realNumber = realNumber * 2;
		message = "I hate nduja";
		integers[0] = -9;
		int[] newIntegers = {-4, 12, 99};
		integers = newIntegers;
		messages[1] = "The sky is blue.";
		String[] newMessages = {"Hi", "how are you"};
		messages = newMessages;
	}
	
	public static boolean containsDUplicated(int[] integers) {
		for (int i = 0; i < integers.length; i++) {
			//int checkNumber = integers[i];
			for (int j = i + 1; j < integers.length; j++) {
				if(integers[i] == integers[j]) {
					return true;	
				}	
			}
		}
		return false;
	}
	
}





