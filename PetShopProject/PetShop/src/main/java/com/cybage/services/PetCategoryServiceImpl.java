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
		PetCategory petCategoryToBeUpdated = petCategoryRepository.findById(categoryId).orElseThrow(()-> new PetCateogryNotFoundException("Pet category does not exist for category id "+categoryId));
		return petCategoryRepository.save(petCategoryToBeUpdated);
	}

	@Override
	public void deletePetCategory(int categoryId) {
		PetCategory petCategoryToBeDeleted = petCategoryRepository.findById(categoryId).orElseThrow(()-> new PetCateogryNotFoundException("Pet category does not exist for category id "+categoryId));
		petCategoryRepository.delete(petCategoryToBeDeleted);
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
