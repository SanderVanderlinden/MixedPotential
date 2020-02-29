package domain;

public class Person {

	private String firstName;
	private String lastName;
	private Gender gender;
	private Role role;
    private String geboortedatum;
    private String geboorteplaats;
    private String nationaliteit;
    private String identiteitskaartnummer;
    private Boolean permission;


    public Person(String firstName, String lastName, Gender gender) {
		setFirstName(firstName);
		setLastName(lastName);
		setGender(gender);
	}

    public Person(String firstName, String lastName, Gender gender, String geboortedatum, String nationaliteit) {
        this(firstName, lastName, gender);
        setGeboortedatum(geboortedatum);
        setNationaliteit(nationaliteit);
    }

	public Person() {
	}



    public Gender getGender() {
        return this.gender;
    }

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName.isEmpty()) {
			throw new IllegalArgumentException("Geef voornaam op");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName.isEmpty()) {
			throw new IllegalArgumentException("Geef familienaam op");
		}
		this.lastName = lastName;
	}
	
    public String getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(String geboortedatum) {
        if (geboortedatum.isEmpty()) {
            throw new IllegalArgumentException("Geef geboortedatum op");
        }
        this.geboortedatum = geboortedatum;
    }
    
    public String getGeboorteplaats() {
        return geboorteplaats;
    }

    public void setGeboorteplaats(String geboorteplaats) {
        this.geboorteplaats = geboorteplaats;
    }
    
    public String getNationaliteit() {
        return nationaliteit;
    }


    public void setNationaliteit(String nationaliteit) {
        this.nationaliteit = nationaliteit;
    }

    public String getIdentiteitskaartnummer() {
        return identiteitskaartnummer;
    }

    public void setIdentiteitskaartnummer(String identiteitskaartnummer) {
        this.identiteitskaartnummer = identiteitskaartnummer;
    }

    public Boolean getPermission(){return permission;}

    public void setPermission(Boolean permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Person)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Person person = (Person) o;

        // Compare the data members and return accordingly
        return this.firstName.equals(person.firstName) &&
                this.lastName.equals(person.lastName) &&
                this.gender.equals(person.gender);
    }

	@Override
	public String toString() {
		return (firstName + " " + lastName + " " + gender + " " + geboortedatum + " " + nationaliteit);
	}

    public boolean matches(String firstName, String lastName, Gender gender, String geboortedatum, String nationaliteit) {
        if(firstName != null && !firstName.equals(this.getFirstName().toLowerCase())){
            return false;
        }
        if(lastName != null && !lastName.equals(this.getLastName().toLowerCase())){
            return false;
        }
        if(gender != null && !gender.equals(this.gender)){
            return false;
        }
        if(geboortedatum != null && !geboortedatum.equals(this.getGeboortedatum())){
            return false;
        }
        if(nationaliteit != null && !nationaliteit.equals(this.getNationaliteit().toLowerCase())){
            return false;
        }
        return true;
    }
}
