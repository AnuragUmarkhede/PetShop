package com.cybage.services;

import java.util.List;

import com.cybage.entities.PetAccessories;

public interface IPetAccessoriesService {

	// Method to add pet Accessories details
	public PetAccessories addPetAccessories(PetAccessories petAccessories);

	// Method to update pet Accessories details
	public PetAccessories updatePetAccessories(int itemId, PetAccessories petAccessories);

	// Method to delete pet Accessories details
	public void deletePetAccessories(int itemId);

	// Method to get all pet Accessories details
	public List<PetAccessories> getAllAccessories();

	// Method to find pet Accessories by name
	public PetAccessories findByItemName(String itemName);

	// Method to find pet Accessories by item id
	public PetAccessories findByItemId(int itemId);
}
