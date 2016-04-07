package io.github.jwolff52.cyoa.util;

public enum AlignmentType {
	Good("Good"), Evil("Evil"), Sarcastic("Sarcastic");

	private String asString;
	
	AlignmentType(String asString) {
		this.asString = asString;
	}
	
	public String getAsString() {
		return asString;
	}
	
	public static AlignmentType getFromString(String alignment) {
		switch(alignment.toLowerCase()) {
		case "good":
			return AlignmentType.Good;
		case "evil":
			return AlignmentType.Evil;
		default:
			return AlignmentType.Sarcastic;
		}
	}
}
