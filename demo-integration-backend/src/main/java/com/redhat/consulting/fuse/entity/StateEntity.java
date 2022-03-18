package com.redhat.consulting.fuse.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "state")
@NamedQuery(name = "findAllStates", query = "select a from StateEntity a")
public class StateEntity implements Serializable {

	private static final long serialVersionUID = -5811316802185394958L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;	
	
	@Column(name="name")
	private String name;
	
	@Column(name="abbreviation")
	private String abbreviation;
	
	public StateEntity() {
		super();
	}	
	
	public StateEntity(Integer id) {
		super();		
		this.id = id;
	}
		
	public StateEntity(String abbreviations) {
		super();		
		this.abbreviation = abbreviations;	
	}
	
	public StateEntity(Integer id, String name, String abbreviations) {
		super();
		this.id = id;
		this.abbreviation = abbreviations;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}	
	
}
