/*
 *   Palo-it  source code: 
 */
package com.paloit.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.paloit.entities.Course;
import com.paloit.entities.Person;
import com.paloit.manager.CourseManager;
import com.paloit.manager.PersonManager;

/**
 * PersonBean
 * 
 * @author Palo-IT
 * @since 22 févr. 2013
 */
@ManagedBean(name = "personBean")
@Component
@ViewScoped
public class PersonBean {
	// =========================================================================
	// ATTRIBUTES
	// =========================================================================
	private Person person;

	private PersonManager manager;

	private Person selectedPerson;

	private List<Person> filteredPersons; 

	private String name;

	private CourseManager courseManager;


	// =========================================================================
	// CONSTRUCTORS
	// =========================================================================

	public PersonBean() {
	}

	// =========================================================================
	// METHODS
	// =========================================================================
	public String savePerson() {
		manager.savePerson(selectedPerson);
		return "";
	}

	public void deletePerson(ActionEvent event) {
		manager.deletePerson(selectedPerson);
	}

	public String editPerson(){
		return "";
	}

	public String newPerson(){
		reinit();
		return "";
	}
	public String addCourse(){
		Course course = new Course(this.getName());
		List<Course> courses = selectedPerson.getCourse();
		courses.add(course);
		selectedPerson.setCourse(courses);
		this.name="";
		return null;
	}

	public void reinit() {
		selectedPerson = new Person();
	}

	// =========================================================================
	// OVERRIDES
	// =========================================================================

	// =========================================================================
	// GETTERS & SETTERS
	// =========================================================================
	public List<Person> getAllPersons() {
		return manager.getAllPersons();
	}

	public Person getPerson() {
		try {
			List<Course> courses = new ArrayList<Course>(person.getCourse());
			person.setCourseList(courses);
		} catch (Exception e) {
		}
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Autowired
	public void setManager(PersonManager manager) {
		this.manager = manager;
	}

	public Person getSelectedPerson() {
//		selectedPerson.setCourse(courseManager.getCourseByPersonne(selectedPerson.getId()));
		return selectedPerson;
	}

	public void setSelectedPerson(Person selectedPerson) {
		this.selectedPerson = selectedPerson;
	}

	public List<Person> getFilteredPersons() {
		return filteredPersons;
	}

	public void setFilteredPersons(List<Person> filteredPersons) {
		this.filteredPersons = filteredPersons;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Autowired
	public void setCourseManager(CourseManager courseManager) {
		this.courseManager = courseManager;
	}


}
