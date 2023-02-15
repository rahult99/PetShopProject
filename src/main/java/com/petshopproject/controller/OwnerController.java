package com.petshopproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petshopproject.model.Owner;
import com.petshopproject.model.Pet;
import com.petshopproject.service.OwnerServiceIntf;
import com.petshopproject.service.PetServiceImpl;
import com.petshopproject.service.PetServiceIntf;

@RestController
@RequestMapping(value= "Owner")
public class OwnerController {
	
	@Autowired
	private OwnerServiceIntf ownerServiceIntf;
	
	@Autowired
	private PetServiceIntf petServiceIntf;
	
	
	//*****************************************************************************************************
	//= = = = = = = = = = = = = = = = = => Create-Owner Rest End Point <= = = = = = = = = = = = = = = = = =
	
	@PostMapping(value = "AddOwner")
	public ResponseEntity<String> addOwner(@RequestBody Owner owner){
		
		String tempMesasge = null;
		ResponseEntity<String> responseEntity;
		
		if (owner.getOwnerPassword().length() > 4) {
			
			Owner tempOwner = ownerServiceIntf.addOwner(owner);
			
			if (tempOwner != null) {
				
				tempMesasge= "Owner Added Successfully";
				responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.OK);
				
			} 
			else
			{
				tempMesasge = "Failed to Add Owner, Please Try Again !!";
				responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
			}
		} 
		else 
		{
			
			tempMesasge = "Password must be greater than 4 Digits !!";
			responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	//*****************************************************************************************************
	//= = = = = = = = = = = = = = = = = => Find-Owner Rest End Point <= = = = = = = = = = = = = = = = = =
	
	@GetMapping(value = "FindOwner/{ownerId}")
	public ResponseEntity<Owner> findOwnerById(@PathVariable("ownerId") int ownerIdKey){
		
		return new ResponseEntity<Owner>(ownerServiceIntf.findOwnerById(ownerIdKey), HttpStatus.OK);
	}
	
	@GetMapping(value = "AllOwner")
	public ResponseEntity<List<Owner>> findAllOwner(){
		
		return new ResponseEntity<List<Owner>>(ownerServiceIntf.findAllOwners(), HttpStatus.OK);
		
	}
	
	//*****************************************************************************************************
	//= = = = = = = = = = = = = = = = = => Update-Owner Rest End Point <= = = = = = = = = = = = = = = = = =
	
	@PutMapping(value= "UpdateOwner")
	public ResponseEntity<String> updateOwner(@RequestBody Owner owner){
		
		String tempMesasge = null;
		ResponseEntity<String> responseEntity;
		
		if (owner.getOwnerPassword().length() > 4) {
			
			Owner tempOwner = ownerServiceIntf.updateOwner(owner);
			
			if (tempOwner != null) {
				
				tempMesasge= "Owner Updated Successfully";
				responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.OK);
				
			} 
			else
			{
				tempMesasge = "Failed to Update Owner, Please Try Again !!";
				responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
			}
		} 
		else 
		{
			
			tempMesasge = "Password must be greater than 4 Digits !!";
			responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
		
	}
	
	//*****************************************************************************************************
	//= = = = = = = = = = = = = = = = = => Delete-Owner Rest End Point <= = = = = = = = = = = = = = = = = =
	
	@DeleteMapping(value = "DeleteOwner/{ownerId}")
	public ResponseEntity<String> deleteOwner(@PathVariable("ownerId") int ownerIdKey) {

		String tempMesasge = null;
		ResponseEntity<String> responseEntity = null;

		if (ownerIdKey > 0) {

			Owner tempOwner = ownerServiceIntf.findOwnerById(ownerIdKey);

			if (tempOwner != null) {

				int tempOwnerId = ownerServiceIntf.deleteOwnerByID(ownerIdKey);

				String ownerIdString = Integer.toString(tempOwnerId);

				String tempMessage = "Owner with ID : " + ownerIdString + " is Deleted.";

				responseEntity = new ResponseEntity<String>(tempMessage, HttpStatus.OK);
			} 
			else
			{

				tempMesasge = "No such Owner Exists";
				responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
			}
		} 
		else
		{

			tempMesasge = "Owner-ID cannot be 0 OR Less Than 0 !!";
			responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}
	
	//*****************************************************************************************************
	//= = = = = = = = = = = = = = = = = => Login-Owner Rest End Point <= = = = = = = = = = = = = = = = = =
	
	@PostMapping(value = "Login/{ownerId}/{ownerPassword}")
	public ResponseEntity<String> loginOwner(@PathVariable("ownerId") int ownerIDKey, @PathVariable("ownerPassword") String ownerPasswordKey){
		
		String tempMesasge = null;
		ResponseEntity<String> responseEntity = null;
		
		Owner tempOwner = new Owner();
		tempOwner.setOwnerId(ownerIDKey);
		tempOwner.setOwnerPassword(ownerPasswordKey);
		
		Owner loginResult = ownerServiceIntf.loginOwner(tempOwner);
		
		if (loginResult != null) {
			
			tempMesasge = "Login Successfull ! Welcome " + loginResult.getOwnerName() + " to the Pet Shop Application.";
			responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.OK);
		} 
		else 
		{
			tempMesasge = "Login Unsuccessfull, Please check ID and PassWord";
			responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	//*****************************************************************************************************
	//= = = = = = = = = = = = => Show List of All Available Pets Rest End Point <= = = = = = = = = = = = =
	
	@GetMapping(value = "AvailablePets")
	public ResponseEntity<List<Pet>> allAvailablePets(){
		
		ResponseEntity<List<Pet>> responseEntity;
		
		//PetServiceIntf petServiceIntf = new PetServiceImpl();
		
		List<Pet> pets = petServiceIntf.findAllPets();
		
		List<Pet> sortedPets = new ArrayList<Pet>();
		
		String compareVar = "Available";
		
		for (Pet pet : pets) {
			//System.out.println(pet.getPetName());
			if (pet.getPetStatus().equals(compareVar)) {
				
				sortedPets.add(pet);
				
			}
		}
		
		responseEntity = new ResponseEntity<List<Pet>>(sortedPets, HttpStatus.OK);
		
		return responseEntity;
	}
		
	//*****************************************************************************************************
	//= = = = = = = = = = = = = = = = = => BUY-PET Rest End Point <= = = = = = = = = = = = = = = = = =
	
	@PutMapping(value = "BuyPet/{ownerId}/{petId}")
	public ResponseEntity<String> buyPet(@PathVariable("ownerId") int ownerIdKey, @PathVariable("petId") int petIdKey){
		
		String tempMesasge = null;
		ResponseEntity<String> responseEntity = null;
		
		if (ownerIdKey > 0 && petIdKey > 0) {
			
			int buyPetResult = ownerServiceIntf.buyPet(ownerIdKey, petIdKey);
			
			if (buyPetResult == 1) {
				tempMesasge = "Pet Successfully Bought.";
				responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.OK);
			}
			if (buyPetResult == 2) {
				tempMesasge = "Not Available, Pet is already Sold !!.";
				responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
			}
		} 
		else 
		{
			tempMesasge = "Owner ID and Pet ID cannot be 0 or Smaller than 0.";
			responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	//*****************************************************************************************************
	//= = = = = = = = = = = = = => List of Pets owned by Owner Rest End Point <= = = = = = = = = = = = = =
	
	@GetMapping(value = "OwnedPets/{ownerId}")
	public ResponseEntity<List<Pet>> ownedPets(@PathVariable("ownerId") int ownerIdKey) {

		return new ResponseEntity<List<Pet>>(ownerServiceIntf.findAllOwnerPets(ownerIdKey), HttpStatus.OK);
		
	}

}
