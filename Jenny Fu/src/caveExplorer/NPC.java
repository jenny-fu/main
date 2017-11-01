package caveExplorer;

//Non Playable Character
public class NPC {
	
	//fields relating to navigation
	private CaveRoom[][] floor; //where npc roams
	private int currentRow;
	private int currentCol;
	private NPCRoom currentRoom;
	
	//fields relating to character
	private boolean active;
	private String activeDescription;
	private String inactiveDescription;
	
	public NPC() {
		this.floor = CaveExplorer.caves;
		this.activeDescription = "There is a peron waiting to talk to you.";
		this.inactiveDescription = "The person you spoke to eariler is standing here.";
		
		//to indicate the NPC doesn't have a position yet, use coordinates (-1, -1).
		this.currentCol = -1;
		this.currentRow = -1;
		this.currentRoom = null;
		this.active = true;
	}

	public void interact() {
		CaveExplorer.print("Hi! I'm a NPC. I say nothing at all until you say 'bye'.");
		String s = CaveExplorer.in.nextLine();
		while(!s.equalsIgnoreCase("bye")) {
			CaveExplorer.print("...");
			s = CaveExplorer.in.nextLine();
		}
		CaveExplorer.print("Well, that was fun. Later!");
		active = false;
	}
	
	public void setPosition(int row, int col) {
		if(row >= 0 && row < floor.length && col >=0 && col < floor[row].length && floor[row][col] instanceof NPCRoom) {
			
			//remove NPC from current room
			if(currentRoom != null) {
				currentRoom.leaveNPC();
			}
			
			currentRow = row;
			currentCol = col;
			currentRoom = (NPCRoom) floor[row][col];
			currentRoom.enterNPC(this);
		}
	}

	public boolean isActive() {
		return active;
	}

	public String getInactiveDescription() {
		return inactiveDescription;
	}

	public String getActiveDescription() {
		return activeDescription;
	}

	public void act() {
		if(active) {
			int[] move = calculateMovement();
			int newRow = currentRow + move[0];
			int newCol = currentCol + move[1];
			setPosition(newRow, newCol);
		}
	}

	public int[] calculateMovement() {
		int[] moves = new int[2];
		int[][] possibleMoves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		int rand = (int) (Math.random() * 4);
		moves[0] = possibleMoves[rand][0] + currentRow;
		moves[1] = possibleMoves[rand][1] + currentCol;
		while()
	}

}
