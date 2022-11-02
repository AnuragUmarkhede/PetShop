package com.cybage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cybage.entities.PetFood;
import com.cybage.services.PetFoodServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/petFood")
public class PetFoodController {

	@Autowired
	PetFoodServiceImpl petFoodServiceImpl;

	@PostMapping("/addPetFood")
	public ResponseEntity<PetFood> addPetFood(@RequestBody PetFood petfood) {
		return new ResponseEntity<PetFood>(petFoodServiceImpl.addPetFood(petfood), HttpStatus.CREATED);
	}

	@PutMapping("/updatePetFood/{foodId}")
	public ResponseEntity<PetFood> updatePetFood(@PathVariable int foodId, @RequestBody PetFood petfood) {
		return new ResponseEntity<PetFood>(petFoodServiceImpl.updatePetFood(foodId, petfood), HttpStatus.OK);
	}

	@DeleteMapping("/deletePetFood/{foodId}")
	public ResponseEntity<String> deletePetFood(@PathVariable int foodId) {
		petFoodServiceImpl.deletePetFood(foodId);
		return new ResponseEntity<String>("Pet food details deleted successfully for food id " + foodId, HttpStatus.OK);
	}

	@GetMapping("/getAllFood")
	public ResponseEntity<List<PetFood>> getAllFood() {
		return new ResponseEntity<List<PetFood>>(petFoodServiceImpl.getAllFood(), HttpStatus.OK);
	}
	
	@GetMapping("/findByFoodName/{foodName}")
	public ResponseEntity<PetFood> findByFoodName(@PathVariable String foodName)
	{
		return new ResponseEntity<PetFood>(petFoodServiceImpl.findByFoodName(foodName), HttpStatus.OK);
	}
	
	@GetMapping("/findByFoodId/{foodId}")
	public ResponseEntity<PetFood> findByFoodId(@PathVariable int foodId)
	{
		return new ResponseEntity<PetFood>(petFoodServiceImpl.findByFoodId(foodId), HttpStatus.OK);
	}

}
