package com.cybage.services;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cybage.daos.PetRepository;
import com.cybage.entities.Gender;
import com.cybage.entities.Pet;
import com.cybage.exceptions.PetNotFoundException;

@Service
public class PetServiceImpl implements IPetService {

	@Autowired
	PetRepository petRepository;
	
	@Override
	public Pet addPet(Pet pet) {
		return petRepository.save(pet);
	}

	@Override
	public Pet updatePet(int petId, Pet pet) {
		petRepository.findById(petId).orElseThrow(()-> new PetNotFoundException("Pet does not exist for id "+petId));
		return petRepository.save(pet);
	}

	@Override
	public void deletePet(int petId) {
		petRepository.deleteById(petId);
	}

	@Override
	public List<Pet> getAllPets() {
		return petRepository.findAll();
	}
	
	@Override
	public Pet findByPetId(int petId) {
		return petRepository.findById(petId).orElseThrow(()-> new PetNotFoundException("Pet does not exist for id "+petId));
		
	}

	@Override
	public Pet findByPetName(String petName) {
		return petRepository.findByPetName(petName);
	}

	@Override
	public void savePetToDB(MultipartFile file, String petName, String petDescription, double petPrice, Gender gender,int petCategoryId) {
		Pet pet = new Pet();
		String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a valid file");
		}
		try {
			pet.setPetImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		pet.setPetName(petName);
		pet.setPetDescription(petDescription);
		pet.setPetPrice(petPrice);
		pet.setGender(gender);
		pet.getPetCategory().setCategoryId(petCategoryId);
		
		petRepository.save(pet);
	}

}
