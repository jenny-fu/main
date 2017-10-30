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
	
	//gives this room access to another room (and vice-versa) and sets a door between them, updating the directions.
	public void setConnection(int direction, CaveRoom room, Door door) {
		addRoom(direction, room, door);
		room.addRoom(oppositeDirection(direction), this, door);
	}
	
	public static int oppositeDirection(int direction) {
		return (direction + 2) % 4;
	}

	public void addRoom(int direction, CaveRoom cave, Door door) {
		borderingRooms[direction] = cave;
		doors[direction] = door;
		setDirections();
	}
	
	public void interpretInput(String input) {
		while(!isValid(input)) {
			System.out.println("You can only enter 'w', 'a', 's', or 'd'.");
			input = CaveExplorer.in.nextLine();
		}
		String dirs = "wdsa";
		goToRoom(dirs.indexOf(input));
		
			/**
				int direction = 0;
				String[] key = {"w", "d", "s", "a"};
				for(int i = 0; i < key.length; i++) {
					if(input == key[i])
						direction = i;
						break;
				}
				goToRoom(direction);
			*/
	}
	
	//This will be where your group sets up all the caves and all the connections.
	public static void setUpCaves() {
		//ALL OF THIS CODE CAN BE CHANGED
		//1. Decide how big caves should be.
		CaveExplorer.caves = new CaveRoom[5][5];
		//2. Populate with caves and a default description. hint: when starting use coordinates
		for(int row = 0; row < CaveExplorer.caves.length; row++) {
			//Pay attention to the the difference
			for(int col = 0; col < CaveExplorer.caves[row].length; col++) {
				//create a "default" cave
				CaveExplorer.caves[row][col] = new CaveRoom("This cave has the coordinates (" + row + ", " + col + ").");
			}
		}
		//3. replace default rooms with custom rooms
		//LATER
		
		//4. set your starting room
		CaveExplorer.currentRoom = CaveExplorer.caves[0][1];
		CaveExplorer.currentRoom.enter();
		//5. set up doors
		CaveRoom[][] c = CaveExplorer.caves;
		c[0][1].setConnection(SOUTH, c[1][1], new Door());
	}

	public void goToRoom(int direction) {
		//first protect against null pointer exception
		//(user cannot go through non-existent door)
		if(borderingRooms[direction] != null && doors[direction] != null) {
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
		}
	}

	public boolean isValid(String input) {
		String validEntries = "wdsa";
		return (validEntries.indexOf(input) > -1) && (input.length() == 1);
	}

	public void enter() {
		contents = "x";
	}
	
	public void leave() {
		contents = defaultContents;
	}

	public void setDirections() {
		directions = "";
		boolean doorFound = false;
		for(int i = 0; i < doors.length; i++) {
			if(doors[i] != null) {
				doorFound = true;
				directions += "\n   There is a " + doors[i].getDescription() + " to " + toDirection(i) + ". " + doors[i].getDetails();
			}
		}
		if(!doorFound)
			directions += "There is no way out. You are trapped!";
			
			/**
				int count = 0;
				for(int i = 0; i < doors.length; i++) {
					if(doors[i] == null)
						count++;
					else
						System.out.println("There is a " + doors[i].getDescription() + " to " + toDirection(i) + ". " + doors[i].getDetails());
				}
				if(count == 4)
					System.out.println("There is no way out. You are trapped!");
			*/
	}
	
	public static String toDirection(int dir) {
		String[] des = {"the North", "the East", "the South", "the West"};
		return des[dir];
	}

	public String getDescription() {
		return description + "\n" + directions;
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

	public Door getDoor(int direction) {
		return doors[direction];
	}

}
