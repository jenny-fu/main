package arrays;

import java.util.Arrays;

public class ArraysMain {
	
	private int[] testArray;
	private int[] intRay;

	public ArraysMain() {
		intRay = new int[100];
		//populate(intRay);
		//checkOccurences(intRay, 3, 18);
		populate1ToN(intRay);
		shuffle(intRay);
		//Arrays is a Utility class included in Java for formatting output
		System.out.println(Arrays.toString(intRay));
	}
	
	public void shuffle(int[] array) {
		for(int i = 0; i < array.length; i++) {
			swap(array, (int) (Math.random() * array.length), (int) (Math.random() * array.length))
		}
	}

	public void swap(int[] array, int first, int second) {
		int num = array[first];
		array[first] = array[second];
		array[second] = num;
	}

	public void populate1ToN(int[] array) {
		for(int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
	}

	public void checkOccurences(int[] array, int start, int end) {
		int[] counter = new int[end - start + 1];
		for(int value: array) {
			counter[value - start]++;
		}
		
		for(int i = 0; i < counter.length; i++) {
			System.out.println("A " + (start + i) + " was rolled " + counter[i] + " times.");
		}
	}
	
	public void populate(int[] array) {
		for(int i = 0; i < array.length; i++) {
			intRay[i] = diceRoll(3);
		}
	}

	public static void main(String[] args) {
		ArraysMain arrayPractice = new ArraysMain();

	}
	
	public int diceRoll(int numberOfDice) {
		//returns the result from rolling "numberOfDice" dice.
		int roll = 0;
		for(int i = 0; i < numberOfDice; i++) {
			roll += (1 + (int) (Math.random() * 6));
		}
		return roll;
	}
	
	public void notes() {
		/**
		 * 1) Collection of primitives or objects
		 * 		This is the ONLY collection of primitives
		 *
		 * 2) Size cannot be modified
		 *
		 * 3) Elements of an array are REFERENCES to objects
		 * 		In other words, changing an element of an array changes the REFERENCE, not the object
		 * 			(more on this later) 
		 * ____________________________________________________________________________________________________________
		 * There are two type of constructors, the first we've seen already:
		**/
		
		int[] firstType = {3, 14, -9, 10};
	//this constructor can only be used at the declaration. Error:
//firstType = {12, 13, 14, 15};
		
		/**THE SECOND TYPE:**/
		testArray = new int[50];
	/*	For primitive arrays, when they are instantiated, they are automatically populated with 0s.
		This is not the case with Object arrays, which are populated with null.
	*/
		
//Two ways for iterating through arrays:
		
		//standard 'for' loop
		for(int i = 0; i < testArray.length; i++) {
			System.out.println("The # " + i + " item is: " + testArray[i]);
		}
		
		//'for each' loop (useful only when you don't need to keep track of an index)
		for(int value: testArray) {
			//"for each int in testArray..."
			System.out.println(value);
		}
	}
}
