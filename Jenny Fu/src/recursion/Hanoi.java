package recursion;


public class Hanoi {

	public static void main(String[] args) {
		hanoi(5, "a", "b", "c");
	}
	
	public static void hanoi(int num, String start, String help, String end) {
		if(num == 1)
			System.out.println(start + " to " + end);
		else {
			hanoi(num - 1, start, end, help);
			System.out.println(start + " to " + end);
			hanoi(num - 1, help, start, end);
			
		}
	}

	//HOMEWORK:
	//HANDWRITTEN SOLUTION IN CODE!!
}

