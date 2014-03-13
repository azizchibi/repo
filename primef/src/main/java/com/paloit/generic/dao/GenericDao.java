package com.paloit.generic.dao;

import java.util.List;

import com.paloit.entities.Person;

public interface GenericDao {
	public void savePerson(Person person);

	public List<Person> getAllPersons();

	public Person getPersonById(String id);

	public void deletePerson(Person person);
	
	public List<Person> getPersonbyName(String name);

}
