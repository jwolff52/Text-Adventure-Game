package io.github.jwolff52.cyoa.entity;

public enum EntityType {
	NPC("NPC", true), Enemy("Enemy", false), Boss("Boss", false);
	
	private String asString;
	private Boolean friendly;
	
	EntityType(String asString, Boolean friendly) {
		this.asString = asString;
		this.friendly = friendly;
	}
	
	public String getAsString() {
		return this.asString;
	}
	
	public Boolean isFriendly() {
		return this.friendly;
	}
	
	public static EntityType getFromString(String asString) {
		for (EntityType type : EntityType.values()) {
			if (type.getAsString().equalsIgnoreCase(asString)) {
				return type;
			}
		}
		return null;
	}
}
