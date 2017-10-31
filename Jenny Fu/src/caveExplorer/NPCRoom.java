package caveExplorer;

public class NPCRoom extends CaveRoom {
	
	private NPC presentNPC;

	public NPCRoom(String description) {
		super(description);
		presentNPC = null;
	}
	
	public boolean canEnter() {
		return presentNPC == null;
	}
	
	public void enterNPC(NPC m) {
		presentNPC = m;
	}
	
	public void leaveNPC() {
		presentNPC = null;
	}
	
	//helpful if you want to change the rules of "canEnter".
	public boolean containsNPC() {
		return presentNPC != null;
	}
	
	/**
	 * ABOVE - New features to CaveRoom
	 * BELOW - Override methods (methods replace CaveRoom methods)
	 */
	
	public String validKeys() {
		return "wdase";
	}

	public void printAllowedEntry() {
		CaveExplorer.print("You can only enter 'w', 'a', 's', or 'd' to move, or you can enter 'e' to interact.");
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
			if(containsNPC() && presentNPC.isActive()) {
				presentNPC.interact();
			}else
				CaveExplorer.print("There is nothing to interact with.");
		}else
			CaveExplorer.print("That key does nothing.");
	}
	
	public String getContents() {
		if(containsNPC() && presentNPC.isActive()) {
			return "M";
		}else
			//return what would be return otherwise
			return super.getContents();
	}
	
	public String getDescription() {
		if(containsNPC() && !presentNPC.isActive()) {
			return super.getDescription() + "\n" + presentNPC.getInactiveDescription();
		}else
			return super.getDescription();
	}
}
