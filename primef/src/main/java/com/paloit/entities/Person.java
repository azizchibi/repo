package com.paloit.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "person")
public class Person implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 8496087166198616020L;
	private Long id;
	private String name;
	private Integer age;
	private BigDecimal anasse;
	private List<Course> course;
	private List<Course> courseList;
	public Person(Long idPerson) {
		this.id=idPerson;
	}

	public Person() {
	}

	@Id
	@GeneratedValue
	@Column(name = "PersonId",columnDefinition="int")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "PersonName", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PersonAge")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person == false) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		final Person person = (Person) obj;
		return new EqualsBuilder().append(name, person.getName())
				.append(id, person.getId()).append(age, person.getAge())
				.isEquals();
	}
	@Column(name = "Anasse",columnDefinition="decimal")
	public BigDecimal getAnasse() {
		return anasse;
	}

	public void setAnasse(BigDecimal anasse) {
		this.anasse = anasse;
	}
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="idPerson",insertable=false,updatable=false)
	@IndexColumn(name="CourseId")
	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	@Transient
	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}


}
