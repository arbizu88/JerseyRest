package com.crunchify.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "persona")
public class Persona {

	private Integer id;
	private String name;
	private String lastName;
	private Integer age;
	private String ced;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "lastName")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "age")
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Column(name = "ced")
	public String getCed() {
		return ced;
	}
	public void setCed(String ced) {
		this.ced = ced;
	}
	
}
