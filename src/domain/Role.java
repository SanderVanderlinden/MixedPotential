package domain;

public enum Role {
	SLACHTOFFER("slachtoffer"), NABESTAANDE("nabestaande");

	private String description;

	Role(String description) {
		this.description = description;
	}
	
	Role() {
		
	}

	public String getDescription() {
		return description;
	}
}
