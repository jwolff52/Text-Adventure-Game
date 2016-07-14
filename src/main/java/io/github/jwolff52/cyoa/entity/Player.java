package io.github.jwolff52.cyoa.entity;

import io.github.jwolff52.cyoa.inventory.Inventory;
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
	private int level;
	private int gold;
	private int health;
	private int maxHealth;
	private int experience;

	public Player(ArrayList<String> playerInfo, boolean newPlayer) {
		name = playerInfo.get(0);
		hometown = playerInfo.get(1);
		warriorClass = playerInfo.get(2);
		isMale = playerInfo.get(3).equalsIgnoreCase("male");
		race = playerInfo.get(4);
		alignment = new int[3];
		setAlignment(playerInfo.get(5).split(","));
		if(newPlayer) {
			setLevel(1);
			setGold(30);
			setHealth(100);
			setExperience(0);
		} else {
			setLevel(Integer.valueOf(playerInfo.get(6)));
			setGold(Integer.valueOf(playerInfo.get(7)));
			setHealth(Integer.valueOf(playerInfo.get(8)));
			setExperience(Integer.valueOf(playerInfo.get(9)));
		}
        inventory = new Inventory(name, level, newPlayer);
		setMaxHealth();
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append("\n");
        sb.append(hometown);
        sb.append("\n");
        sb.append(warriorClass);
        sb.append("\n");
        sb.append(isMale ? "Male" : "Female");
        sb.append("\n");
        sb.append(race);
        sb.append("\n");
        sb.append(getAlignmentForStorage());
        sb.append("\n");
        sb.append(level);
        sb.append("\n");
        sb.append(gold);
        sb.append("\n");
        sb.append(health);
        sb.append("\n");
        sb.append(experience);
        sb.append("\n");
        return sb.toString();
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

    public String getAlignmentForStorage() {
        StringBuilder sb = new StringBuilder();
        for (int i : alignment) {
            sb.append(i);
            sb.append(",");
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
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

	public static String incrementAlignment(AlignmentType type, String alignmentAsString) {
        String newAlignment;
        switch (type) {
            case Good:
                newAlignment = "x" + alignmentAsString.substring(alignmentAsString.indexOf(','));
                newAlignment.replace("x", ((Integer)(Integer.valueOf(alignmentAsString.substring(0,alignmentAsString.indexOf(','))) + 1)).toString());
                return newAlignment;
            case Evil:
                newAlignment = alignmentAsString.substring(0, alignmentAsString.indexOf(',') + 1) + "x" + alignmentAsString.substring(alignmentAsString.indexOf(',', alignmentAsString.indexOf(',') + 1), alignmentAsString.length());
                newAlignment.replace("x", ((Integer)(Integer.valueOf(alignmentAsString.substring(alignmentAsString.indexOf(',') + 1, alignmentAsString.indexOf(',', alignmentAsString.indexOf(',') + 1))) + 1)).toString());
                return newAlignment;
            default:
                newAlignment = alignmentAsString.substring(0, alignmentAsString.lastIndexOf(',') + 1) + "x";
                newAlignment.replace("x", ((Integer)(Integer.valueOf(alignmentAsString.substring(alignmentAsString.lastIndexOf(',') + 1)) + 1)).toString());
                return newAlignment;
        }
    }

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getHealth() {
		return health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth() {
		this.maxHealth = 20*(getLevel()/2) + 100;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
}
