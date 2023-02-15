package com.petshopproject.model;

/*
 * 
 *  @author RT/S
 * 
 */

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PET_TABLE")
public class Pet implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int petId;

	private String petName;
	private int petAge;
	private String petCity;
	private String petStatus;

	// Many-to-One Implementation
	@ManyToOne
	@JoinColumn(name = "OWNER_ID")
	private Owner owner;

	// Non-Parameterized Constructor
	public Pet() {
		super();
	}

	// Parameterized Constructor
	public Pet(String petName, int petAge, String petCity, String petStatus, Owner owner) {
		super();
		this.petName = petName;
		this.petAge = petAge;
		this.petCity = petCity;
		this.petStatus = petStatus;
		this.owner = owner;
	}

	// Setters and Getters
	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public int getPetAge() {
		return petAge;
	}

	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}

	public String getPetCity() {
		return petCity;
	}

	public void setPetCity(String petCity) {
		this.petCity = petCity;
	}
	
	public String getPetStatus() {
		return petStatus;
	}

	public void setPetStatus(String petStatus) {
		this.petStatus = petStatus;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	
}
