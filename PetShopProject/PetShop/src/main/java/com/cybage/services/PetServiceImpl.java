package com.cybage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.PetRepository;
import com.cybage.entities.Pet;
import com.cybage.exceptions.PetNotFoundException;

@Service
public class PetServiceImpl implements IPetService {

	@Autowired
	PetRepository petRepository;
	
	@Override
	public Pet addPet(Pet pet) {
		return petRepository.save(pet);
	}

	@Override
	public Pet updatePet(int petId, Pet pet) {
		petRepository.findById(petId).orElseThrow(()-> new PetNotFoundException("Pet does not exist for id "+petId));
		return petRepository.save(pet);
	}

	@Override
	public void deletePet(int petId) {
		petRepository.deleteById(petId);
	}

	@Override
	public List<Pet> getAllPets() {
		return petRepository.findAll();
	}
	
	@Override
	public Pet findByPetId(int petId) {
		return petRepository.findById(petId).orElseThrow(()-> new PetNotFoundException("Pet does not exist for id "+petId));
		
	}

	@Override
	public Pet findByPetName(String petName) {
		return petRepository.findByPetName(petName);
	}

	
}
