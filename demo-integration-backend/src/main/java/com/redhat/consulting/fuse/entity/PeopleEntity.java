package com.redhat.consulting.fuse.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.redhat.consulting.fuse.model.PeopleModel;


@Entity
@Table(name = "people")
@NamedQueries({
		@NamedQuery(name = "findAllPeople", query = "select a from PeopleEntity a"),
		@NamedQuery(name = "findAllStudents", query = "select a from PeopleEntity a where a.type = 1"),
		@NamedQuery(name = "findAllTeachers", query = "select a from PeopleEntity a where a.type = 2")
})

public class PeopleEntity implements Serializable {

	private static final long serialVersionUID = 6932170202779243732L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;

	@Column(name="mobile")
	private String mobile;
	
	@Column(name="type")
	private Integer type;
	    
    
	public PeopleEntity() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public PeopleModel toModel() {
		
		PeopleModel model = new PeopleModel();
		model.setName(this.getName());
		model.setEmail(this.getEmail());		
		model.setId(this.getId());
		model.setMobile(this.getMobile());
		
		return model;
	}

	@Override
	public String toString() {
		return "PeopleEntity [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile  + ", type=" + type + "]";
	}

	
	
}
