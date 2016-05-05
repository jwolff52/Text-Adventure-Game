package io.github.jwolff52.cyoa.entity.npc.enemy;
/**
 * @author Caymon
 * @version 0.1
 */
public enum EnemyType {
	Generic("Generic"), Goblin("Goblin"), Orv("Orc"), Wolf("Wolf"), Bear("Bear");
	
	private String asString;
	
	EnemyType(String asString) {
		this.asString = asString;
	}
	
	public String getAsString() {
		return this.asString;
	}
	
	public static EnemyType getFromString(String asString) {
        for (EnemyType type : EnemyType.values()) {
            if(type.getAsString().equalsIgnoreCase(asString)) {
                return type;
            }
        }
        return null;
    }
}
