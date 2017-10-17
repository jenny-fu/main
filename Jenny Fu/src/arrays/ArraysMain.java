package arrays;

import java.util.Arrays;

public class ArraysMain {
	
	private int[] testArray;
	private int[] intRay;

	public ArraysMain() {
		int[] randomRolls = new int[100];
		
		populate(randomRolls);
		//checkOccurences(intRay, 3, 18);
		//populate1ToN(intRay);
		//shuffle(intRay);
		//reverseOrder(intRay);
		//frontToBack(intRay);
		
		//Arrays is a Utility class included in Java for formatting output
		//System.out.println(Arrays.toString(intRay));
		
		int[] result = longestConsecSeqAndPos(randomRolls);
		System.out.println("The longest sequence of dice rolls is " + result[0]
				+ " it happened on the " + (result[1] + 1) + "th roll. Starting with a roll of " + randomRolls[result[1]] + ".");
	}
	
	
	public int[] longestConsecSeqAndPos(int[] array) {
		
	}


	//returns the length of the longest sequence of consecutive integers
	public int longestConsecutiveSequence(int[] array) {
		int temp = 0;
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			if(isConsecutive(array, i))
				count++;
			else{
				if(temp < count) {
					temp = count;
				}
				count = 1;
			}
		}
		if(temp < count) {
			temp = count;
		}
		return temp;
	}
	
	public boolean isConsecutive(int[] array, int idx) {
		if(idx == 0)
			return true;
		if(array[idx] == array[idx - 1] + 1)
			return true;
		return false;
	}
	
	//moves the front to the back repeatedly, exactly n times
	public void cycleThrough(int[] array, int n) {
		int count = 0;
		while(count < n) {
			frontToBack(array);
			count++;
		}
	}
	
	//remove the element at index zero, push every other element up by one.
	//Put the element that was at zero at the end of the array.
	public void frontToBack(int[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			swap(array, i, i + 1);
		}
	}
	
	public int countLessThan(int[] array, int n) {
		int count = 0;
		for(int value: array) {
			if(value < n) {
				count++;
			}
		}
		return count;
	}
	
	public int[] reverseOrder(int[] array) {
		int[] outArray = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			outArray[i] = array[array.length - 1 - i];
		}
		return outArray;
	}
	
	public void shuffle(int[] array) {
		for(int i = 0; i < array.length; i++) {
			swap(array, (int) (Math.random() * array.length), (int) (Math.random() * array.length));
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
