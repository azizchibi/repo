package com.paloit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.paloit.entities.Person;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	


	public Long savePerson(Person person) {
		if(person.getId() == null){
			entityManager.persist(person);
		}else{
			entityManager.merge(person);
		}
		return person.getId();
	}

	@SuppressWarnings("unchecked")
	public List<Person> getAllPersons() {
		return entityManager.createQuery("from "+Person.class.getName()).getResultList();
	}

	public Person getPersonById(Long id) {
		return   entityManager.createQuery("select p from "+Person.class.getName()+" p where p.id = "+id,Person.class).getSingleResult();
	}

	public void deletePerson(Person person) {
		entityManager.remove(person);
	}

	@SuppressWarnings("unchecked")
	public List<Person> getPersonbyName(String name) {
		return entityManager.createQuery("From "+Person.class.getName()+" WHERE name ="+name).getResultList();
	}

}
