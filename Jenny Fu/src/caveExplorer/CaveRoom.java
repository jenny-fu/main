package caveExplorer;

public class CaveRoom {
	
	private String description; //what the room looks like
	private String directions; //what you can do
	private String contents; //symbol representing what's in the room
	private String defaultContents;
	//rooms are organized by direction, "null" signifies no room/door in that direction
	private CaveRoom[] borderingRooms;
	private Door[] doors;

	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		//difference between defaultContents and contents is:
		//"contents" become and 'x' when you go in the room.
		//When you leave, it goes back to defaultContents.
		
		//by default, arrays will populate with 'null' meaning there are no connections.
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}

	public void setDirections() {
		directions = "";
		boolean doorFound = false;
		for(int i = 0; i < doors.length; i++) {
			if(doors[i] != null) {
				doorFound = true;
				directions += "\n   There is a " + doors[i].getDescription() + " to " + toDirection(i) + ". " + doors[i].getDetails();
			}
		if(!doorFound)
			directions += "There is no way out. Youa re trapped.";
			
//		int count = 0;
//		for(int i = 0; i < doors.length; i++) {
//			if(doors[i] == null)
//				count++;
//			else
//				System.out.println("There is a " + doors[i].getDescription() + " to " + toDirection(i) + ". " + doors[i].getDetails());
//		}
//		if(count == 4)
//			System.out.println("You are trapped!");
	}
	
	public static String toDirection(int dir) {
		String[] des = {"the North", "the East", "the South", "the West"};
		return des[dir];
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}

}
