package com.petshopproject.model;

/*
 * 
 * 	@author RT/S
 * 
 */

import java.io.Serializable;
//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.MappedSuperclass;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "OWNER_TABLE")
public class Owner implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ownerId;

	private String ownerName;
	private String ownerPassword;
	
	// One-to-Many Mapping
	/*@OneToMany(mappedBy = "owner")
	private List<Pet> pets;*/

	// Non-Parameterized Constructor
	public Owner() {
		super();
	}

	// Parameterized Constructor
	public Owner(String ownerName, String ownerPassword) {
		super();
		this.ownerName = ownerName;
		this.ownerPassword = ownerPassword;
		//this.pets = pets;
	}

	// Getters and Setters
	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerPassword() {
		return ownerPassword;
	}

	public void setOwnerPassword(String ownerPassword) {
		this.ownerPassword = ownerPassword;
	}

/*	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}*/

}
