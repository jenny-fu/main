package arrays;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		//ObjectArrays oA = new ObjectArrays();
		Person s = new Person("Jenny", "Fu", Borough.NY_BOROUGHS[0]);
		int x = 10;
		int[] a = {5,6,7};
		test2(s,x,a);
		System.out.println(s + ", " + x + ", " + Arrays.toString(a));
	}
	
	/**
	 * THIS CHANGES THE NAME AND ARRAY
	 * 		-NAME CHANGES WITH FIELDS
	 * 		-ARRAY CHANGES WITH INDEXES (because the indexes of an array are references)
	 * 
	 * NO VOID METHOD CAN PERMANENTLY CHANGE AN INT
	 * (you can set it as a return type)
	 */
	public static void test2(Person s, int x, int[] arr) {
		s.setFirstName("Qibing");
		x = 5;
		//arr = new int[3];
		//AS LONG AS YOU DONT MAKE A NEW ARRAY, THE REFERENCES THEMSELVES WILL CHANGE.
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
	}
	
	/**
	 * PASS-BY-VALUE EXAMPLES
	 * DOES NOT CHANGE ANYTHING
	 */

	public static void test(Person s, int x, int[] arr) {
		String name = s.getFirstName();
		name = "Qibing";
		x = 5;
		arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
	}
}
