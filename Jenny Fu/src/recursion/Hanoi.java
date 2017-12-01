package recursion;


public class Hanoi {

	public static void main(String[] args) {
		System.out.println(count(3, null, null, null));
	}
	
	public static int count(int num, String start, String help, String end) {
		if(num == 1)
			return 1;
		else
			
		if(num%2 == 0) {
			return count(num - 1, start, help, end);
		}
		else
			return count(num - 1, start, end, help);
	}
	
	//HOMEWORK:
		//HANDWRITTEN SOLUTION IN CODE!!
}

