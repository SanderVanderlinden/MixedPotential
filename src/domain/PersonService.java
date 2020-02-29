package domain;

import db.PersonRepository;
import db.PersonRepositoryStub;

import java.util.List;

public class PersonService {
    private PersonRepository personRepository = new PersonRepositoryStub();

	public PersonService(){
	}

	public List<Person> getPersons() {
		return getPersonRepository().getAll();
	}

	public void addPerson(Person person) {
		getPersonRepository().add(person);
	}

	public void updatePersons(Person person) {
		getPersonRepository().update(person);
	}

	public void deletePerson(String id) {
		getPersonRepository().delete(id);
	}

	private PersonRepository getPersonRepository() {
		return personRepository;
	}

}
