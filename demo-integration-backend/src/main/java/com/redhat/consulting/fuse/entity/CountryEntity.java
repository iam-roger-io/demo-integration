package com.redhat.consulting.fuse.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "country")
@NamedQuery(name = "findAllCountries", query = "select a from CountryEntity a")
public class CountryEntity implements Serializable {

	private static final long serialVersionUID = -5000132224861202987L;
	
	@Id    
	@Column(name="country_code")
	private String countryCode;

	@Column(name="name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="country_code")
	@JsonBackReference
	private List<StateEntity> states = new ArrayList<StateEntity>();
	
	public CountryEntity() {
		super();
	}
	
	public CountryEntity(String id) {
		super();
		this.countryCode = id;
	}	
	
	public CountryEntity(String id, String name) {
		super();
		this.countryCode = id;
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StateEntity> getStates() {
		return states;
	}

	public void setStates(List<StateEntity> states) {
		this.states = states;
	}

}