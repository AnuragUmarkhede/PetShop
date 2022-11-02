package com.cybage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.PetFoodRepository;
import com.cybage.entities.PetFood;
import com.cybage.exceptions.PetFoodNotFoundException;

@Service
public class PetFoodServiceImpl implements IPetFoodService {

	@Autowired
	PetFoodRepository petFoodRepository;  
	
	@Override
	public PetFood addPetFood(PetFood petfood) {
		return petFoodRepository.save(petfood);
	}

	@Override
	public PetFood updatePetFood(int foodId, PetFood petfood) {
		petFoodRepository.findById(foodId).orElseThrow(()-> new PetFoodNotFoundException("Pet Food does not exist for id"+foodId));
		return petFoodRepository.save(petfood);
	}

	@Override
	public void deletePetFood(int foodId) {
		petFoodRepository.deleteById(foodId);
	}

	@Override
	public List<PetFood> getAllFood() {
		return petFoodRepository.findAll();
	}

	@Override
	public PetFood findByFoodName(String foodName) {
		return petFoodRepository.findByFoodName(foodName);
	}

	@Override
	public PetFood findByFoodId(int foodId) {
		return petFoodRepository.findByFoodId(foodId);
	}
}
