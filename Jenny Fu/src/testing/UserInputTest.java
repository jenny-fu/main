package testing;

import java.util.Scanner;

public class UserInputTest{
	
	public static String getInput() {
		Scanner inputSource = new Scanner(System.in);
		String input = inputSource.nextLine();
		return input;
	}
	
	public static void howAreYou() {
		System.out.println("How are you feeling today?");
		String inputString = getInput();
		String[] positive = {"good", "great", "amazing"};
		String[] negative = {"bad", "terrible", "busy"};
		
		for(int i = 0; i < positive.length; i++) {
			if(inputString.indexOf(positive[i] == -1)) {
				for(int j = 0; j < negative.length; j++) {
					if(inputString.indexOf(negative[j] == -1)) {
						System.out.println("I dont understand. Please try again.");
						inputString = getInput();
					}
					else {
						System.out.println("Hope you feel better!");
					}
				}
			}
			else {
				System.out.println("I feel " + positive[i] + "too.");
			}
		}
	}
}
