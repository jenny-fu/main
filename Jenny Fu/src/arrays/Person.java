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
	
	public Person(String first, String last, Borough home) {
		firstName = first;
		lastName = last;
		this.home = home;
	}
	
	public String toString() {
		return "My name is " + firstName + " " + lastName + " and I live in " + home + ".";
	}
}
