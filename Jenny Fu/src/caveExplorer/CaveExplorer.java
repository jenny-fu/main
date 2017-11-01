package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {
	
	public static CaveRoom[][] caves; //every room in the cave
	public static Scanner in; //user input
	public static CaveRoom currentRoom; //changes based on how user navigated
	public static Inventory inventory; //where all objects found in cave kept
	public static boolean playing = true;
	
	public static NPC[] npcs;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		CaveRoom.setUpCaves();
		
		inventory = new Inventory();
		startExploring();
	}

	public static void startExploring() {
		while(playing) {
			npcActions();
			print(inventory.getDescription());
			print(currentRoom.getDescription());
			print("What would you like to do?");
			String input = in.nextLine();
			currentRoom.interpretInput(input);
		}
	}
	
	public static void npcActions() {
		for(NPC n: npcs) {
			n.act();
		}
		inventory.updateMap();
	}

	public static void print(String s) {
		//Later, you can replace with more sophisticated "multiLinePrint" from Chatbot.
		System.out.println(s);
	}
}
