package com.cybage.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cybage.entities.Gender;
import com.cybage.entities.Pet;

public interface IPetService 
{
	//Method to add pet details
	public Pet addPet(Pet pet);
	
	//Method to update pet details
	public Pet updatePet(int petId,Pet pet);
	
	//Method to delete pet details
	public void deletePet(int petId);
	
	//Method to get all pets details
	public List<Pet> getAllPets();
	
	//Method to find pet by id
	public Pet findByPetId(int petId);
	
	//Method to find pet by name
	public Pet findByPetName(String petName);
	
	public void savePetToDB(MultipartFile file, String petName, String petDescription, double petPrice, Gender gender,int petCategoryId);
	
}
