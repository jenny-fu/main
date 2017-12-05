package recursion;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println();
	}
	
	public int fib(int index) {
		if(index == 0 || index == 1)
			return 1;
		else {
			return fib(index - 1) + fib(index - 2);
		}
	}

}
