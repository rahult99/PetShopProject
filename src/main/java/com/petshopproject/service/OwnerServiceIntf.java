package com.petshopproject.service;

import java.util.List;

import com.petshopproject.model.Owner;
import com.petshopproject.model.Pet;

public interface OwnerServiceIntf {

	
	//*****************************************************************************************************
	// Find All() Operation.
		
	public abstract List<Owner> findAllOwners();
		//public abstract List<Pet> findAllPets();
	
	//*****************************************************************************************************
	// CRUD Operations : 
				
	//*****************************************************************************************************
	// Create() Operation.
		
	public abstract Owner addOwner(Owner owner);
		//public abstract Pet addPet(Pet pet);
		
	//*****************************************************************************************************
	// Read() Operation.
		
	public abstract Owner findOwnerById(int ownerIdKey);
		//public abstract Pet findPetByID(int petIdKey);
		
	//*****************************************************************************************************
	// Update() Operation.
		
	public abstract Owner updateOwner(Owner owner);
		//public abstract Pet updatePet(Pet pet);
		
	//*****************************************************************************************************
	// Delete() Operation.
	
	public abstract int deleteOwnerByID(int ownerIdKey);
	
	//*****************************************************************************************************
	// Login Owner() Operation.
	
	public abstract Owner loginOwner(Owner owner);
	
	//*****************************************************************************************************
	// BUY-Pet() Operation.
	
	public abstract int buyPet(int ownerIdKey, int petIdKey);
	
	//*****************************************************************************************************
	// findAllOwnerPets() Operation.
	
	public List<Pet> findAllOwnerPets(int ownerIdKey);
	
	
}
