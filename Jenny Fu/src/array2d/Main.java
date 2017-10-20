package array2d;

public class Main {

	public static void main(String[] args) {
		
	}
	
	//THIS IDEA IS ANOTHER MAAJOR TOPIC IN AP CSA
	//It is the idea of avoiding an ArrayIndexOutOfBounds exception
	//You will see it on quizzes, test, and project rubrics. Always be mindful
	public static void changeNeighbors(int[] arr, int psn) {
		arr[psn]++;
		if(psn > 0) {
			arr[psn - 1]--;
		}
		if(psn < arr.length - 1) {
			arr[psn + 1]--;
		}
	}

}
