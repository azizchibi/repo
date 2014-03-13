package com.paloit.manager;

import java.util.List;

import com.paloit.entities.Course;

public interface CourseManager {
	
	public void saveCourse(Course course);

	public List<Course> getAllCourses();

	public Course getCourseById(String id);
	
	public List<Course> getCourseByPersonne(Long long1);

	public void deleteCourse(Course course);
}
