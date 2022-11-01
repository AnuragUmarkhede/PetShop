package com.cybage.services;

import java.util.List;

import com.cybage.entities.PetCategory;

public interface IPetCategoryService 
{
	//Method to add pet category
	public PetCategory addPetCategory(PetCategory petCategory);
	
	//Method to update pet category
	public PetCategory updatePetCategory(int categoryId,PetCategory petCategory);
	
	//Method to delete pet category
	public void deletePetCategory(int categoryId);
	
	//Method to get all pet category details
	public List<PetCategory> getAllPetCategory();
	
	//Method to find pet category by id
	public PetCategory findByCategoryId(int categoryId);
		
	//Method to find pet category by name
	public PetCategory findByCategoryName(String categoryName);
	
}
