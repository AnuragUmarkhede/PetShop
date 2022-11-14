package com.cybage.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cybage.entities.PetFood;

public interface IPetFoodService {
	

	//Method to add pet food details
	public PetFood addPetFood(PetFood petfood);
	
	//Method to update pet food details
	public PetFood updatePetFood(int foodId,PetFood petfood);
	
	//Method to delete pet food details
	public void deletePetFood(int foodId);
	
	//Method to get all pet food details
	public List<PetFood> getAllFood();
	
	//Method to find pet food by name
	public PetFood findByFoodName(String foodName);
	
	//Method to find pet food by category name
	public List<PetFood> findByFoodCategory(String foodCategory);
	
	//Method to find pet food by id
	public PetFood findByFoodId(int foodId);
	
	public void savePetFoodToDB(MultipartFile multipartFile,String foodName,String foodCategory,double foodPrice,int foodQuantity);

}
