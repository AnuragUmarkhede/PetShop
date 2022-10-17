package com.cybage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.entities.PetCategory;
import com.cybage.services.PetCategoryServiceImpl;

@RestController
@RequestMapping("/petCategory")
public class PetCategoryController
{
	@Autowired
	PetCategoryServiceImpl petCategoryServiceImpl;
	
	
	@PostMapping("/addPetCategory")
	public ResponseEntity<PetCategory> addPetCategory(@RequestBody PetCategory petCategory)
	{
		return new ResponseEntity<PetCategory>(petCategoryServiceImpl.addPetCategory(petCategory), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/updatePetCategory/{categoryId}")
	public ResponseEntity<PetCategory> updatePetCategory(@PathVariable int categoryId, @RequestBody PetCategory petCategory)
	{
		return new ResponseEntity<PetCategory>(petCategoryServiceImpl.updatePetCategory(categoryId, petCategory), HttpStatus.OK);
	}
	
	@DeleteMapping("/deletePetCategory/{categoryId}")
	public ResponseEntity<String> deletePetCategory(@PathVariable int categoryId)
	{
		petCategoryServiceImpl.deletePetCategory(categoryId);
		return new ResponseEntity<String>("Pet category details deleted successfully for pet category id "+categoryId, HttpStatus.OK);
	}
	
	@GetMapping("/getAllPetCategory")
	public ResponseEntity<List<PetCategory>> getAllPetCategory()
	{
		return new ResponseEntity<List<PetCategory>>(petCategoryServiceImpl.getAllPetCategory(), HttpStatus.OK);
	}
	
	@GetMapping("/findByCategoryId/{categoryId}")
	public ResponseEntity<PetCategory> findByCategoryId(@PathVariable int categoryId)
	{
		return new ResponseEntity<PetCategory>(petCategoryServiceImpl.findByCategoryId(categoryId), HttpStatus.OK);
	}
	
	@GetMapping("/findByCategoryName/{categoryName}")
	public ResponseEntity<PetCategory> findByCategoryName(@PathVariable String categoryName)
	{
		return new ResponseEntity<PetCategory>(petCategoryServiceImpl.findByCategoryName(categoryName), HttpStatus.OK);
	}
	
}
