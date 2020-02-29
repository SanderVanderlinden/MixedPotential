package db;

import domain.Gender;
import domain.Person;
import domain.Role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonRepositoryStub implements PersonRepository {
	private Map<String, Person> persons = new HashMap<String, Person>();
	
	public PersonRepositoryStub () {
		Person bart = new Person("Bart", "Putteman", Gender.MALE, "1995-03-12", "Belg", Role.SLACHTOFFER, true);
		add(bart);
		Person wim = new Person("Wim", "Luykx", Gender.MALE, "1995-12-06", "Belg", Role.SLACHTOFFER, true);
		add(wim);
		Person els = new Person("Els", "Elsen", Gender.FEMALE, "1974-10-12", "Nederlander", Role.SLACHTOFFER, true);
		add(els);
		Person idk = new Person("weethet", "niezogoed", Gender.OTHER, "2000-10-12", "Wereldburger", Role.SLACHTOFFER, true);
		add(idk);
	}
	
	public Person get(String personId){
		if(personId == null){
			throw new IllegalArgumentException("No id given");
		}
		return persons.get(personId);
	}
	
	public List<Person> getAll(){
		return new ArrayList<Person>(persons.values());
	}

	public void add(Person person){
		if(person == null){
			throw new IllegalArgumentException("No person given");
		}
		if (persons.containsKey(person.getFirstName())) {
			throw new IllegalArgumentException("User already exists");
		}
		persons.put(person.getFirstName(), person);
	}
	
	public void update(Person person){
		if(person == null){
			throw new IllegalArgumentException("No person given");
		}
		persons.put(person.getFirstName(), person);
	}
	
	public void delete(String personId){
		if(personId == null){
			throw new IllegalArgumentException("No id given");
		}
		persons.remove(personId);
	}

}
