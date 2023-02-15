package com.petshopproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshopproject.dao.OwnerDaoIntf;
import com.petshopproject.model.Owner;
import com.petshopproject.model.Pet;

@Service
public class OwnerServiceImpl implements OwnerServiceIntf {
	
	@Autowired
	private OwnerDaoIntf ownerDaoIntf;
	
	@Autowired
	private PetServiceIntf petServiceIntf;

	//*****************************************************************************************************
	// Find All() Operation.
	
	@Override
	public List<Owner> findAllOwners() {
		
		return ownerDaoIntf.findAll();
		
	}

	//*****************************************************************************************************
	// CRUD Operations : 
					
	//*****************************************************************************************************
	// Create() Operation.
	
	@Override
	public Owner addOwner(Owner owner) {
		
		return ownerDaoIntf.save(owner);
		
	}

	//*****************************************************************************************************
	// Read() Operation.
	
	@Override
	public Owner findOwnerById(int ownerIdKey) {
		
		Owner tempOwner = null;
		
		Optional<Owner> ownerVar = ownerDaoIntf.findById(ownerIdKey);
		
		if (ownerVar.isPresent()) {
			tempOwner = ownerVar.get();
		}
		
		return tempOwner;
	}

	//*****************************************************************************************************
	// Update() Operation.
	
	@Override
	public Owner updateOwner(Owner owner) {
		
		return ownerDaoIntf.save(owner);
		
	}
	
	//*****************************************************************************************************
	// Delete() Operation.
	
	@Override
	public int deleteOwnerByID(int ownerIdKey) {
		
		ownerDaoIntf.deleteById(ownerIdKey);
		return ownerIdKey;
	}


	//*****************************************************************************************************
	// Login Owner() Operation.
	
	@Override
	public Owner loginOwner(Owner owner) {
		
		Owner tempOwner = null;
		
		Owner checkOwner = findOwnerById(owner.getOwnerId());
		
		if (owner.getOwnerPassword().equals(checkOwner.getOwnerPassword())) {
			tempOwner = checkOwner;
		}
		
		return tempOwner;
	}

	//*****************************************************************************************************
	// BUY-Pet() Operation.
	
	@Override
	public int buyPet(int ownerIdKey, int petIdKey) {
		
		int tempVar = 0;
		Pet tempPet = null;
		
		//PetServiceIntf petServiceIntf = new PetServiceImpl();
		
		Owner targetOwner = findOwnerById(ownerIdKey);
		Pet targetPet = petServiceIntf.findPetByID(petIdKey);
		
		//List<Pet> petsList = new ArrayList<Pet>();
		
		String compareVar = "Available";
		
		if (targetPet.getPetStatus().equals(compareVar)) {
			
			targetPet.setPetStatus("Sold");
			targetPet.setOwner(targetOwner);
			
			tempPet = petServiceIntf.updatePet(targetPet);
			
			//petsList.add(targetPet);
			
			//targetOwner.setPets(petsList);
			//tempOwner = updateOwner(targetOwner);
			
			if (tempPet != null) {
				tempVar = 1;
			}
		}
		else
		{
			tempVar = 2;
		}
		
		return tempVar;
	}

	//*****************************************************************************************************
	// findAllOwnerPets() Operation.
	
	@Override
	public List<Pet> findAllOwnerPets(int ownerIdKey) {
		
		//Owner tempOwner = findOwnerById(ownerIdKey);
		
		//List<Pet> tempPets = tempOwner.getPets();
		
		Owner tempOwner = null;
		
		List<Pet> tempPets = petServiceIntf.findAllPets();
		
		List<Pet> ownedPets = new ArrayList<Pet>();
		
		for (Pet pet : tempPets) {
			
			tempOwner = pet.getOwner();
			
			if (tempOwner != null) {
				//System.out.println(tempOwner.getOwnerId() + " = " + ownerIdKey);
				if (tempOwner.getOwnerId() == ownerIdKey) {
					
					//System.out.println("Comparing");
					ownedPets.add(pet);
				}
			}
		}
		
		return ownedPets;
	}

}
