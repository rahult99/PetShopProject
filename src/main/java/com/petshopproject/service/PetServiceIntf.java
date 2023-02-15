package com.petshopproject.service;

import java.util.List;

import com.petshopproject.model.Pet;

public interface PetServiceIntf {
	
	//*****************************************************************************************************
	// Find All() Operation.
	
	public abstract List<Pet> findAllPets();
	
	//*****************************************************************************************************
	// CRUD Operations : 
			
	//*****************************************************************************************************
	// Create() Operation.
	
	public abstract Pet addPet(Pet pet);
	
	//*****************************************************************************************************
	// Read() Operation.
	
	public abstract Pet findPetByID(int petIdKey);
	
	//*****************************************************************************************************
	// Update() Operation.
	
	public abstract Pet updatePet(Pet pet);
	
	//*****************************************************************************************************
	// Delete() Operation.
	
	public abstract int deletePetByID(int petIdKey);

}
