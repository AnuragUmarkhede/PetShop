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

import com.cybage.entities.PetAccessories;
import com.cybage.services.PetAccessoriesServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/petaccessories")
public class PetAccessoriesController {
	
	@Autowired
	PetAccessoriesServiceImpl petAccessoriesServiceImpl;
	
	@PostMapping("/addPetAccessories")
	public ResponseEntity<PetAccessories> addPetAccessories(@RequestBody PetAccessories petAccessories)
	{
		return new ResponseEntity<PetAccessories>(petAccessoriesServiceImpl.addPetAccessories(petAccessories), HttpStatus.CREATED);
	}
	
	@PutMapping("/updatePetAccessories/{itemId}")
	public ResponseEntity<PetAccessories> updatePetAccessories(@PathVariable int itemId, @RequestBody PetAccessories petAccessories)
	{
		return new ResponseEntity<PetAccessories>(petAccessoriesServiceImpl.updatePetAccessories(itemId, petAccessories), HttpStatus.OK);
	}
	
	@DeleteMapping("/deletePetAccessories/{itemId}")
	public ResponseEntity<String> deletePetAccessories(@PathVariable int itemId)
	{
		petAccessoriesServiceImpl.deletePetAccessories(itemId);
		return new ResponseEntity<String>("Pet Accessories details deleted successfully for Accessories id "+itemId, HttpStatus.OK);
	}
	
	@GetMapping("/getAllAccessories")
	public ResponseEntity<List<PetAccessories>> getAllAccessories()
	{
		return new ResponseEntity<List<PetAccessories>>(petAccessoriesServiceImpl.getAllAccessories(), HttpStatus.OK);
	}
	 
	@GetMapping("/findByItemName/{itemName}")
	public ResponseEntity<PetAccessories> findByItemName(@PathVariable String itemName)
	{
		return new ResponseEntity<PetAccessories>(petAccessoriesServiceImpl.findByItemName(itemName), HttpStatus.OK);
	}

}
