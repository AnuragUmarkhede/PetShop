package com.cybage.services;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cybage.daos.PetAccessoriesRepository;
import com.cybage.entities.PetAccessories;
import com.cybage.exceptions.PetAccessoriesNotFoundException;

@Service
public class PetAccessoriesServiceImpl implements IPetAccessoriesService {

	@Autowired
	PetAccessoriesRepository petAccessoriesRepository;

	@Override
	public void addPetAccessories(MultipartFile file, String itemName, String itemCategory, double itemPrice,
			int itemQuantity) {

		PetAccessories petAccessories = new PetAccessories();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a valid file");
		}
		try {
			petAccessories.setItemImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {

			e.printStackTrace();
		}

		petAccessories.setItemName(itemName);
		petAccessories.setItemCategory(itemCategory);
		petAccessories.setItemPrice(itemPrice);
		petAccessories.setItemQuantity(itemQuantity);

		petAccessoriesRepository.save(petAccessories);

	}

	@Override
	public void updatePetAccessories(int itemId, MultipartFile file, String itemName, String itemCategory,
			double itemPrice, int itemQuantity) {
		PetAccessories petAccessoriesToBeUpdated = petAccessoriesRepository.findById(itemId).orElseThrow(
				() -> new PetAccessoriesNotFoundException("Pet Accessories does not exist for id" + itemId));

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a valid file");
		}
		try {
			petAccessoriesToBeUpdated.setItemImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {

			e.printStackTrace();
		}

		petAccessoriesToBeUpdated.setItemName(itemName);
		petAccessoriesToBeUpdated.setItemCategory(itemCategory);
		petAccessoriesToBeUpdated.setItemPrice(itemPrice);
		petAccessoriesToBeUpdated.setItemQuantity(itemQuantity);

		petAccessoriesRepository.save(petAccessoriesToBeUpdated);
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

	@Override
	public List<PetAccessories> findByItemCategory(String itemCategory) {
		return petAccessoriesRepository.findByItemCategory(itemCategory);
	}

}
