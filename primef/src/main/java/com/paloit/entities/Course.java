package com.paloit.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course implements Serializable{
	private Long id;
	private String libelle;
	private Person person;
	
	public Course() {
	}
	public Course(String libelle) {
		this.libelle = libelle;
	}
	@Id
	@GeneratedValue
	@Column(name = "CourseId",columnDefinition="int")
	public Long getId() {
		return id;
	}
	@Column(name = "Libelle", nullable = false)
	public String getLibelle() {
		return libelle;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@ManyToOne
	@JoinColumn(name="idPerson",columnDefinition="int")
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
