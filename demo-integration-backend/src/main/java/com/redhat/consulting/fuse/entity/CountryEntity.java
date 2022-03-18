package com.redhat.consulting.fuse.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "country")
@NamedQuery(name = "findAllCountries", query = "select a from CountryEntity a")
public class CountryEntity implements Serializable {

	private static final long serialVersionUID = -5000132224861202987L;
	
	@Id    
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String name;
	
	public CountryEntity() {
		super();
	}
	
	public CountryEntity(String id) {
		super();
		this.id = id;
	}	
	
	public CountryEntity(String id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	
}
