package com.paloit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.paloit.entities.Course;
@Repository("courseDao")
public class CourseDaoImpl implements CourseDao{
	@PersistenceContext
	private EntityManager entityManager;
	


	public void saveCourse(Course course) {
		if(course.getId() == null){
			entityManager.persist(course);
		}else{
			entityManager.merge(course);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Course> getAllCourses() {
		return entityManager.createQuery("from "+Course.class.getName()).getResultList();
	}

	public Course getCourseById(String id) {
		return   entityManager.createQuery("select p from "+Course.class.getName()+" p where p.id = "+id,Course.class).getSingleResult();
	}
	
	public List<Course> getCourseByPersonne(Long id) {
		return   entityManager.createQuery("select p from "+Course.class.getName()+" p where p.person.id = "+id,Course.class).getResultList();
	}

	public void deleteCourse(Course course) {
		entityManager.remove(course);
	}

	@SuppressWarnings("unchecked")
	public List<Course> getCoursebyName(String name) {
		return entityManager.createQuery("From "+Course.class.getName()+" WHERE name ="+name).getResultList();
	}
}
