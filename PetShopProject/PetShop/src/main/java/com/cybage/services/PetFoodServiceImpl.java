package com.cybage.services;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

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

	@Override
	public void savePetFoodToDB(MultipartFile file,String foodName,String foodCategory,double foodPrice,int foodQuantity)
	{	
		PetFood petFood = new PetFood();
		String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a valid file");
		}
		try {
			petFood.setFoodImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		petFood.setFoodName(foodName);
		petFood.setFoodCategory(foodCategory);
		petFood.setFoodPrice(foodPrice);
		petFood.setFoodQuantity(foodQuantity);
		petFoodRepository.save(petFood);
		
	}

	@Override
	public List<PetFood> findByFoodCategory(String foodCategory) {
		return petFoodRepository.findByFoodCategory(foodCategory);
	}
}
