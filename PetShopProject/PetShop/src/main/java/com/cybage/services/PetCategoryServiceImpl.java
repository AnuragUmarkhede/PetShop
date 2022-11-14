package com.cybage.services;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

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

	@Override
	public void savePetCategoryToDB(MultipartFile file, String categoryName) {
		
		PetCategory petCategory = new PetCategory();
		String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a valid file");
		}
		try {
			petCategory.setCategoryImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		petCategory.setCategoryName(categoryName);
		petCategoryRepository.save(petCategory);
	}

}
