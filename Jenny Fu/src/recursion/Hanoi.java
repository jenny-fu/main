package recursion;


public class Hanoi {

	public static void main(String[] args) {
		System.out.println(count(3, "start", "help", "end"));
	}
k
	public static int count(int num, String start, String help, String end) {
		if(num == 1)
			return 1;
		else if(num%2 == 0) {
			return count(num - 1, start, end, help) + 2;
		}
		else
			return count(num - 1, start, help, end) + 2;
	}

	//HOMEWORK:
	//HANDWRITTEN SOLUTION IN CODE!!
}

