package com.paloit.dao;

import java.util.List;

import com.paloit.entities.Course;

public interface CourseDao {
	public void saveCourse(Course course);

	public List<Course> getAllCourses();

	public Course getCourseById(String id);
	public List<Course> getCourseByPersonne(Long id);

	public void deleteCourse(Course course);

	public List<Course> getCoursebyName(String name);
}
