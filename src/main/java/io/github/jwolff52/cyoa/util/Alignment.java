package io.github.jwolff52.cyoa.util;

public enum Alignment {
	Good("Good"), Evil("Evil"), Sarcastic("Sarcastic");

	private String asString;
	
	Alignment(String asString) {
		this.asString = asString;
	}
	
	public String getAsString() {
		return asString;
	}
	
	public static Alignment getFromString(String alignment) {
		switch(alignment.toLowerCase()) {
		case "good":
			return Alignment.Good;
		case "evil":
			return Alignment.Evil;
		default:
			return Alignment.Sarcastic;
		}
	}
}
