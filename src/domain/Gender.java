package domain;

public enum Gender {
	MALE("male"), FEMALE("female"), OTHER("other");

	private String description;

	private Gender(String description) {
		this.description = description;
	}

	Gender() {
		
	}

	public String getDescription() {
		return description;
	}
}
