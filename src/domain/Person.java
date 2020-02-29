package domain;

public class Person {

	private String firstName;
	private String lastName;
	private Gender gender;
	private Role role;


    public Person(String firstName, String lastName, Gender gender, Role role) {
		setFirstName(firstName);
		setLastName(lastName);
		setGender(gender);
		setRole(role);
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
			throw new IllegalArgumentException("No firstname given");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName.isEmpty()) {
			throw new IllegalArgumentException("No last name given");
		}
		this.lastName = lastName;
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
		return (firstName + " " + lastName + " " + gender);
	}

}
