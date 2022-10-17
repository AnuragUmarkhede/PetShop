package com.cybage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.PetCategoryRepository;
import com.cybage.entities.PetCategory;
import com.cybage.exceptions.PetCateogryNotFoundException;

@Service
public class PetCategoryServiceImpl implements IPetCategoryService 
{
	@Autowired
	PetCategoryRepository petCategoryRepository;
	
	@Override
	public PetCategory addPetCategory(PetCategory petCategory) {
		return petCategoryRepository.save(petCategory);
	}

	@Override
	public PetCategory updatePetCategory(int categoryId, PetCategory petCategory) {
		petCategoryRepository.findById(categoryId).orElseThrow(()-> new PetCateogryNotFoundException("Pet category does not exist for category id "+categoryId));
		return petCategoryRepository.save(petCategory);
	}

	@Override
	public void deletePetCategory(int categoryId) {
		petCategoryRepository.deleteById(categoryId);
	}

	@Override
	public List<PetCategory> getAllPetCategory() {
		return petCategoryRepository.findAll();
	}

	@Override
	public PetCategory findByCategoryId(int categoryId) {
		return petCategoryRepository.findById(categoryId).orElseThrow(()-> new PetCateogryNotFoundException("Pet category does not exist for category id "+categoryId));
	}

	@Override
	public PetCategory findByCategoryName(String categoryName) {
		return petCategoryRepository.findByCategoryName(categoryName);
	}

}
