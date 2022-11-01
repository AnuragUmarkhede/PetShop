package com.cybage.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.entities.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> 
{	
	//Method to find pet by id
	public Pet findByPetId(int petId);
	
	//Method to find pet by name
	public Pet findByPetName(String petName);
}
