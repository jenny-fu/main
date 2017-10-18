package arrays;

public class Borough {
	
	public static final Borough[] NY_BOROUGHS = {new Borough("Queens"), new Borough("Brooklyn"), new Borough("Manhattan"), new Borough("Staten Island"), new Borough("Bronx")};
	
	private String name;
	
	public Borough(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}

