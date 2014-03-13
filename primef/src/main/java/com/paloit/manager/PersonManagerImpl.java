package com.paloit.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paloit.dao.PersonDao;
import com.paloit.entities.Course;
import com.paloit.entities.Person;

@Service
@Transactional(readOnly = true)
public class PersonManagerImpl implements PersonManager {

	private PersonDao personDao;
	private CourseManager courseManager;

	@Autowired
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Transactional(readOnly = false)
	public void savePerson(Person person) {
		List<Course> courses = person.getCourse();
		Long idPerson = personDao.savePerson(person);
		for(Course course : courses){
			if(course !=null  && course.getPerson()==null){
				course.setPerson(getPersonById(idPerson));
				courseManager.saveCourse(course);
			}
		}
	}

	public List<Person> getAllPersons() {
		return personDao.getAllPersons();
	}

	public Person getPersonById(Long id) {
		return personDao.getPersonById(id);
	}

	@Transactional(readOnly = false)
	public void deletePerson(Person person) {
		personDao.deletePerson(person);
	}

	@Autowired
	public void setCourseManager(CourseManager courseManager) {
		this.courseManager = courseManager;
	}

}
