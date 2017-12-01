package recursion;

public class LionsPuzzle {

	public static void main(String[] args) {
		int lions = 101;
		System.out.println(lions + " lions decide to eat the sheep? " + eatSheepOrNot(lions));
	}

	public static boolean eatSheepOrNot(int lions) {
		if(lions == 1) {
			return true;
		}else {
			//Eat the sheep knowing that the other lions wouldn't eat the sheep.
			return !eatSheepOrNot(lions - 1);
		}
	}

}
