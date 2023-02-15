package com.petshopproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshopproject.model.Pet;

@Repository
public interface PetDaoIntf extends JpaRepository<Pet, Integer>{

}
