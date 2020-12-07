package arrays;

public class Person { 

	public static final String[] FIRST_START = {"Chr", "M", "L", "Gr", "Ph", "Th"};
	public static final String[] FIRST_MIDDLE = {"isti", "icha", "era", "eta", "ala", "ina", "ara"};
	public static final String[] FIRST_END = {"", "na","r","n", "tian", "rs", "mp", "les", "y"};

	public static final String[] LAST_START = {"Tr", "Br", "L", "Gr", "Sh", "B", "Th"};
	public static final String[] LAST_MIDDLE = {"on", "o", "an", "ola", "et", "e", "is"};
	public static final String[] LAST_END = {"", "son","ers","r", "tian", "ston", "ck"};

	private String firstName;
	private String lastName;
	private Borough home;
	private Hobby hobby;
	private Person[] friends;
	private String nickname;

	public Person(String first, String last, Borough home) {
		firstName = first;
		lastName = last;
		this.home = home;
		this.hobby = Hobby.randomHobby();
		friends = new Person[3];
		this.nickname = createNickname(firstName);
	}
	
	
	public Person(String first, String last) {
		firstName = first;
		lastName = last;
	}


	public String getLastName() {
		return lastName;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		nickname = createNickname(firstName);
	}
	

	//Java is PASS-BY-VALUE, meaning the parameters of the method are just values, not references.
	//So if you change those values, the original object is not affected.
	//In this case, name will not be changed. In fact, NOTHING can change this.firstName via name.
	
	public static String createNickname(String name) {
		String nickname = "";
		int sec = findSecond(name);
		nickname = name.substring(0, sec);
		return nickname;
	}

	public static int findSecond(String str) {
		int idx = str.length();
		boolean foundVowel = false;
		for(int i = 0; i < str.length(); i++) {
			if(str.toLowerCase().substring(i, i+ 1).equals("a") || str.toLowerCase().substring(i, i+ 1).equals("e") || str.toLowerCase().substring(i, i+ 1).equals("i") || str.toLowerCase().substring(i, i+ 1).equals("o") || str.toLowerCase().substring(i, i+ 1).equals("a") || str.toLowerCase().substring(i, i+ 1).equals("u")) {
				if(!foundVowel) {
					foundVowel = true;
				}else {
					return i;
				}
			}
		}
		return idx;
	}

	//chooses friends from people based on who is of same class as this instance and who has the same hobbies.
	public void mingle(Person[] people) {
		for(Person p: people) {
			if(p != this) {
				//reassign p to the better of the two friends (current bff or p)
				p = betterFriend(p, friends[0]);
				addFriendToFirstPlace(p);
			}
		}
	}

	public Person betterFriend(Person p, Person q) {
		if(p == null) {
			return q;
		}

		if(q == null) {
			return p;
		}

		if(p.getClass() == this.getClass() && q.getClass() == this.getClass()) {
			if(p.hobby == this.hobby)
				return p;
			if(q.hobby == this.hobby)
				return q;
		}

		if(p.getClass() == this.getClass()) {
			return p;
		}

		if(q.getClass() == this.getClass()) {
			return q;
		}

		//if none of these are true, just take p.
		return p;
	}

	//Moves all Person in friends back one index and puts p at index 0.
	public void addFriendToFirstPlace(Person p) {
		for(int i = friends.length - 1; i > 0; i--) {
			friends[i] = friends[i - 1];
		}
		friends[0] = p;
	}

	public void printFriends() {
		System.out.println("My name is " + firstName + " " + lastName + " and these are my friends:");
		for(Person f: friends) {
			if(f != null)
				System.out.println(f);
		}
	}

	public String toString() {
		return "My name is " + firstName + " " + lastName + " and I live in " + home + ". Call me " + nickname + ".\nI like " + hobby + ".";
	}
}
