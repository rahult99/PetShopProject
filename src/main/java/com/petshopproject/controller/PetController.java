package com.petshopproject.controller;

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

import com.petshopproject.model.Pet;
import com.petshopproject.service.PetServiceIntf;

@RestController
@RequestMapping(value = "Pet")
public class PetController {
	
	@Autowired
	private PetServiceIntf petServiceIntf;
	
	//*****************************************************************************************************
	//= = = = = = = = = = = = = = = = = => Create-Pet Rest End Point <= = = = = = = = = = = = = = = = = =
	
	@PostMapping(value = "AddPet")
	public ResponseEntity<String> addPet(@RequestBody Pet pet) {

		String tempMesasge = null;
		ResponseEntity<String> responseEntity;

		if (pet.getPetAge() > 0) {

			Pet tempPet = petServiceIntf.addPet(pet);

			if (tempPet != null) {

				tempMesasge = "Pet Added Successfully. ";
				responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.OK);
			} 
			else {

				tempMesasge = "Failed to add Pet, Please Try Again !!";
				responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
			}
		} 
		else {
			
			tempMesasge = "Pet's Age cannot be less than Zero !!";
			responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	//*****************************************************************************************************
	//= = = = = = = = = = = = = = = = = => Find-Pet Rest End Points <= = = = = = = = = = = = = = = = = =
	
	@GetMapping(value = "FindPet/{petId}")
	public ResponseEntity<Pet> findPetById(@PathVariable("petId") int petIdKey){
		
		return new ResponseEntity<Pet>(petServiceIntf.findPetByID(petIdKey), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "AllPet")
	public ResponseEntity<List<Pet>> findAllPet(){
		
		return new ResponseEntity<List<Pet>>(petServiceIntf.findAllPets(), HttpStatus.OK);
		
	}
	
	//*****************************************************************************************************
	//= = = = = = = = = = = = = = = = = => Update-Pet Rest End Point <= = = = = = = = = = = = = = = = = =
	
	@PutMapping(value = "UpdatePet")
	public ResponseEntity<String> updatePet(@RequestBody Pet pet){
		
		String tempMesasge = null;
		ResponseEntity<String> responseEntity;

		if (pet.getPetAge() > 0) {

			Pet tempPet = petServiceIntf.updatePet(pet);

			if (tempPet != null) {

				tempMesasge = "Pet Updated Successfully. ";
				responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.OK);
			} 
			else {

				tempMesasge = "Failed to Update Pet, Please Try Again !!";
				responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
			}
		} 
		else {
			
			tempMesasge = "Pet's Age cannot be less than Zero !!";
			responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
		
	}
	
	//*****************************************************************************************************
	//= = = = = = = = = = = = = = = = = => Delete-Pet Rest End Point <= = = = = = = = = = = = = = = = = =
	
	@DeleteMapping(value = "DeletePet/{petId}")
	public ResponseEntity<String> deletePet(@PathVariable("petId") int petIdKey){
		
		String tempMesasge = null;
		ResponseEntity<String> responseEntity = null;
		
		if (petIdKey > 0) {
			
			Pet tempPet = petServiceIntf.findPetByID(petIdKey);
			
			if (tempPet != null) {
				
				int tempPetId = petServiceIntf.deletePetByID(petIdKey);
				
				String petIdString = Integer.toString(tempPetId);
				
				String tempMessage = "Pet with ID : " + petIdString + " is Deleted.";
				
				responseEntity =  new ResponseEntity<String>(tempMessage, HttpStatus.OK);
			} 
			else {

				tempMesasge = "No such Pet Exists";
				responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
			}
		}
		else {
			
			tempMesasge = "Pet-ID cannot be 0 OR Less Than 0 !!";
			responseEntity = new ResponseEntity<String>(tempMesasge, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
}
