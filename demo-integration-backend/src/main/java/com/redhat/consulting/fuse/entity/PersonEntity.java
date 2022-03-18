package com.redhat.consulting.fuse.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.redhat.consulting.fuse.model.PersonModel;

@Entity
@Table(name = "person")
@NamedQuery(name = "findAllPeople", query = "select a from PersonEntity a")
public class PersonEntity implements Serializable {

	private static final long serialVersionUID = 6932170202779243732L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="social_security")
	private String socialSecuriry;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="address")
	private String endereco;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name="city")
	private String city;
	
	@Column(name="zip_code")
	private String zipCode;
	
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "state_id", referencedColumnName = "id")	
	private StateEntity state;	
	
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "country_id", referencedColumnName = "id")    
    private CountryEntity country;
    
	public PersonEntity() {
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

	public String getSocialSecuriry() {
		return socialSecuriry;
	}

	public void setSocialSecuriry(String socialSecuriry) {
		this.socialSecuriry = socialSecuriry;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public StateEntity getState() {
		return state;
	}

	public void setState(StateEntity state) {
		this.state = state;
	}

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}
	
	public PersonModel toModel() {
		
		PersonModel model = new PersonModel();
		model.setNome(this.getName());
		model.setComplemento(this.getAddress2());
		model.setCidade(this.getCity());
		model.setPais(this.getCountry().getName());
		model.setEmail(this.getEmail());
		model.setEndereco(this.getEndereco());
		model.set_id(this.getId());
		model.setCelular(this.getMobile());
		model.setCpf(this.getSocialSecuriry());
		model.setUf(this.getState().getName());
		model.setCep(this.getSocialSecuriry());		
		
		return model;
	}

	@Override
	public String toString() {
		return "PersonEntity [id=" + id + ", name=" + name + ", email=" + email + ", socialSecuriry=" + socialSecuriry
				+ ", mobile=" + mobile + ", endereco=" + endereco + ", address2=" + address2 + ", city=" + city
				+ ", zipCode=" + zipCode + ", state=" + state + ", country=" + country + "]";
	}

	
	
}
