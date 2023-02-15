package com.petshopproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshopproject.model.Owner;

@Repository
public interface OwnerDaoIntf extends JpaRepository<Owner, Integer>{

}
