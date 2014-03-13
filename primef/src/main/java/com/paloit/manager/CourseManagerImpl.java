package com.paloit.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paloit.dao.CourseDao;
import com.paloit.entities.Course;
@Service
@Transactional(readOnly = true)
public class CourseManagerImpl  implements CourseManager{

	private CourseDao courseDao;

	@Autowired
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	@Transactional
	public void saveCourse(Course course) {
		courseDao.saveCourse(course);

	}

	public List<Course> getAllCourses() {
		return courseDao.getAllCourses();
	}

	public Course getCourseById(String id) {
		return courseDao.getCourseById(id);
	}
	public List<Course> getCourseByPersonne(Long id) {
		return courseDao.getCourseByPersonne(id);
	}
	@Transactional(readOnly = false)
	public void deleteCourse(Course course) {
		courseDao.deleteCourse(course);
	}
}
