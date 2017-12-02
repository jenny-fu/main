package recursion;


public class Hanoi {

	public static void main(String[] args) {
		System.out.println(count(4, "start", "help", "end"));
	}
	
	public static int count(int num, String start, String help, String end) {
		if(num == 1)
			return 1;
		else if(num%2 == 0) {
			return count(num - 1, start, end, help);
		}
		else
			return count(num - 1, start, help, end);
	}

	//HOMEWORK:
	//HANDWRITTEN SOLUTION IN CODE!!
}

