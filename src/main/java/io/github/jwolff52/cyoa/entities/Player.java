package io.github.jwolff52.cyoa.entities;

import io.github.jwolff52.cyoa.entities.inventory.Inventory;
import io.github.jwolff52.cyoa.util.AlignmentType;

import java.util.ArrayList;

public class Player {
	private String name;
	private String hometown;
	private String warriorClass;
	private boolean isMale;
	private String race;
	private int[] alignment;
	private Inventory inventory;
	private int gold;

	public Player(ArrayList<String> playerInfo) {
		name = playerInfo.get(0);
		hometown = playerInfo.get(1);
		warriorClass = playerInfo.get(2);
		isMale = playerInfo.get(3).equalsIgnoreCase("male");
		race = playerInfo.get(4);
		alignment = new int[3];
		setAlignment(playerInfo.get(5).split(","));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getWarriorClass() {
		return warriorClass;
	}

	public void setWarriorClass(String warriorClass) {
		this.warriorClass = warriorClass;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}
	
	public String getAlignment() {
		int alignment = 0;
		for(int i = 1; i < this.alignment.length; i++) {
			if(this.alignment[i] > this.alignment[i - 1]) {
				alignment = i;
			}
		}
		switch(alignment) {
		case 0:
			return AlignmentType.Good.getAsString();
		case 1:
			return AlignmentType.Evil.getAsString();
		default: 
			return AlignmentType.Sarcastic.getAsString();
		}
	}
	
	public void setAlignment(String[] args) {
		for(int i = 0; i < args.length; i++) {
			alignment[i] = Integer.valueOf(args[i]);
		}
	}
	
	public void setAlignment(int[] alignment) {
		this.alignment = alignment;
	}
	
	public void incrementAlignment(AlignmentType type) {
		switch(type) {
		case Good:
			alignment[0]++;
			break;
		case Evil:
			alignment[1]++;
			break;
		default:
			alignment[2]++;
		}
	}

	public Inventory getInventory() {
		return inventory;
	}
}
