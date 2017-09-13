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
	public CodingConventions(String name, int index) {
		//In Java, fields are instantiated in a constructor
		/*
			there is a local variable called 'name' and a field called 'name'
			the field persists but the local variable data is destroyed at
			the end of this method distinguish the field by using the reserved word 'this'
		*/
		this.name = name;
		description = IntroMain.DESCRIPTIONS[index];
	}
	
	public void doStuff() {
		//use a space between your operations
		System.out.println(name + description);
		System.out.println("The square root of 12 is " + Math.sqrt(12));;
	}
}
