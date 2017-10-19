package arrays;

public class Hobby extends Thing{

	public Hobby(String des) {
		super(des);
	}

	public static Hobby randomHobby() {
		Hobby[] someHobbies = {new Hobby("programming"), new Hobby("dancing"), new Hobby("singing"), new Hobby("playing video games"), new Hobby("making origami"), new Hobby("playing guitar")};
		return someHobbies[(int) (Math.random() * someHobbies.length)];
	}
	
}
