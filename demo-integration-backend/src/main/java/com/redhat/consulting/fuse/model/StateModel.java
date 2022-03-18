package com.redhat.consulting.fuse.model;

import java.io.Serializable;

public class StateModel implements Serializable {

	private static final long serialVersionUID = -5811316802185394958L;
	private Integer id;	
	private String name;
	private String abbreviation;
	
	public StateModel() {
		super();
	}	
		
	public StateModel(String abbreviations) {
		super();		
		this.abbreviation = abbreviations;	
	}
	
	public StateModel(Integer id, String name, String abbreviations) {
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
