package com.petshopproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshopproject.dao.PetDaoIntf;
import com.petshopproject.model.Pet;

@Service
public class PetServiceImpl implements PetServiceIntf {

	@Autowired
	private PetDaoIntf petDaoIntf;
	
	//*****************************************************************************************************
	// Find-All() Operation.
	
	@Override
	public List<Pet> findAllPets() {

		return petDaoIntf.findAll();
		
	}

	//*****************************************************************************************************
	// CRUD Operations : 
				
	//*****************************************************************************************************
	// Create() Operation.
	
	@Override
	public Pet addPet(Pet pet) {
		
		/*Pet tempPet = null;
		
		tempPet = petDaoIntf.save(pet);
		
		return tempPet;*/ 
		
		return petDaoIntf.save(pet);
		
	}

	//*****************************************************************************************************
	// Read() Operation.
	
	@Override
	public Pet findPetByID(int petIdKey) {
		
		Pet tempPet = null;
		
		Optional<Pet> petVar = petDaoIntf.findById(petIdKey);
		
		if (petVar.isPresent()) {
			
			tempPet = petVar.get();
			
		}
		
		return tempPet;
	}

	//*****************************************************************************************************
	// Update() Operation.
	
	@Override
	public Pet updatePet(Pet pet) {
	
		return petDaoIntf.save(pet);
		
	}

	//*****************************************************************************************************
	// Delete() Operation.
	
	@Override
	public int deletePetByID(int petIdKey) {
		

		petDaoIntf.deleteById(petIdKey);
		
		return petIdKey;
				
		/*Pet tempPet = findPetByID(petIdKey);
		
		if (tempPet.getPetId() > 0) {
			
			petDaoIntf.deleteById(petIdKey);
			
		}

		return petIdKey;*/
		
	}

}
