package com.cybage.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.entities.PetAccessories;

@Repository
public interface PetAccessoriesRepository extends JpaRepository<PetAccessories, Integer>{

	public PetAccessories findByItemName(String itemName);
	
	public PetAccessories findByItemId(int itemId);


}
