package com.cybage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.PetAccessoriesRepository;
import com.cybage.entities.PetAccessories;
import com.cybage.exceptions.PetAccessoriesNotFoundException;

@Service
public class PetAccessoriesServiceImpl implements IPetAccessoriesService{

	@Autowired
	PetAccessoriesRepository petAccessoriesRepository; 
	
	@Override
	public PetAccessories addPetAccessories(PetAccessories petAccessories) {
		return petAccessoriesRepository.save(petAccessories);
	}

	@Override
	public PetAccessories updatePetAccessories(int itemId, PetAccessories petAccessories) {
	petAccessoriesRepository.findById(itemId).orElseThrow(()-> new PetAccessoriesNotFoundException("Pet Accessories does not exist for id"+itemId));
		return petAccessoriesRepository.save(petAccessories);
	}

	@Override
	public void deletePetAccessories(int itemId) {
		petAccessoriesRepository.deleteById(itemId);
	}

	@Override
	public List<PetAccessories> getAllAccessories() {
		return petAccessoriesRepository.findAll();
	}

	@Override
	public PetAccessories findByItemName(String itemName) {
		return petAccessoriesRepository.findByItemName(itemName);
	}

	@Override
	public PetAccessories findByItemId(int itemId) {
		return petAccessoriesRepository.findByItemId(itemId);
	}

	

}
