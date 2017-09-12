package introduction;
//class is a file describing a new data type
public class CodingConventions {
	//fields
	private String name;
	private String description;
	
	
	/*
		this is a special method, a "constructor"
		Notice it does not have a return type
		That is because the thing that is being returned is an instance of a class.
		Therefore, the name for the instructor must always match the class.
	*/
	public CodingConventions() {
		//In Java, fields are instantiated in a constructor
		name = "Jenny";
		description = "is a student";
	}
}
