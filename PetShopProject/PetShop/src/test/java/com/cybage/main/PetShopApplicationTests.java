package com.cybage.main;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cybage.daos.PetCategoryRepository;
import com.cybage.daos.PetRepository;
import com.cybage.daos.UserRepository;
import com.cybage.entities.Pet;
import com.cybage.entities.PetCategory;
import com.cybage.entities.User;

@SpringBootTest
class PetShopApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	PetCategoryRepository petCategoryRepository;
	
	@Autowired
	PetRepository petRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void testGetAllPetCategory()
	{
		List<PetCategory> petCategoryList = petCategoryRepository.findAll();
		assertThat(petCategoryList).size().isGreaterThan(0);
	}
	
	@Test
	public void testGetAllPets()
	{
		List<Pet> petsList = petRepository.findAll();
		assertThat(petsList).size().isGreaterThan(0);
	}
	
	@Test
	public void testGetAllUser()
	{
		List<User> usersList = userRepository.findAll();
		assertThat(usersList).size().isGreaterThan(0);
	}
	
	@Test
	public void testAddPetCategory()
	{
		PetCategory petCategory = new PetCategory();
		petCategory.setCategoryId(7);
		petCategory.setCategoryName("Elephant");
		petCategory.setCategoryImage("elephantImage");
		petCategoryRepository.save(petCategory);
		assertNotNull(petCategoryRepository.findByCategoryId(7).getClass());
	}
	

	@Test
	public void testDeletePetCategory()
	{		
		petCategoryRepository.deleteById(2);
		assertThat(petCategoryRepository.existsById(2)).isFalse();
	}
	
	@Test
	public void testUpdatePetCategory()
	{
		PetCategory petCategory = petCategoryRepository.findByCategoryId(1);
		petCategory.setCategoryName("zebra");
		petCategory.setCategoryImage("zebraImage");
		petCategoryRepository.save(petCategory);
		assertNotEquals("dog", petCategoryRepository.findByCategoryId(1).getCategoryName());
	}
	
	@Test
	public void testDeletePet()
	{
		petRepository.deleteById(5);
		assertThat(petRepository.existsById(5)).isFalse();
	}
	
}
