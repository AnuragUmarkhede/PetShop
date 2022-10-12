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

import com.cybage.entities.Pet;
import com.cybage.services.PetServiceImpl;

@RestController
@RequestMapping("/pet")
public class PetController 
{
	@Autowired
	PetServiceImpl petServiceImpl;
	
	@PostMapping("/addPet")
	public ResponseEntity<Pet> addPet(@RequestBody Pet pet)
	{
		return new ResponseEntity<Pet>(petServiceImpl.addPet(pet), HttpStatus.CREATED);
	}
	
	@PutMapping("/updatePet/{petId}")
	public ResponseEntity<Pet> updatePet(@PathVariable int petId, @RequestBody Pet pet)
	{
		return new ResponseEntity<Pet>(petServiceImpl.updatePet(petId, pet), HttpStatus.OK);
	}
	
	@DeleteMapping("/deletePet/{petId}")
	public ResponseEntity<String> deletePet(@PathVariable int petId)
	{
		petServiceImpl.deletePet(petId);
		return new ResponseEntity<String>("Pet details deleted successfully for pet id "+petId, HttpStatus.OK);
	}
	
	@GetMapping("/getAllPets")
	public ResponseEntity<List<Pet>> getAllPets()
	{
		return new ResponseEntity<List<Pet>>(petServiceImpl.getAllPets(), HttpStatus.OK);
	}
}
