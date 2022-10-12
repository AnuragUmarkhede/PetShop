package com.cybage.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cybage.entities.Pet;
import com.cybage.services.PetServiceImpl;

@RestController
@RequestMapping("/pet")
public class PetController 
{
	@Autowired
	PetServiceImpl petServiceImpl;
	
	@PostMapping("/addPet")
	public ResponseEntity<Pet> addPet(@RequestBody Pet pet,@RequestParam("petImage") MultipartFile file) throws IOException
	{
		//upload the file to folder and update name to pet category
		pet.setPetImage(file.getOriginalFilename());
		File saveFile = new ClassPathResource("static/img").getFile();
		Path path = Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
		Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("Pet image is uploaded");
		return new ResponseEntity<Pet>(petServiceImpl.addPet(pet), HttpStatus.CREATED);
	}
	
	@PutMapping("/updatePet/{petId}")
	public ResponseEntity<Pet> updatePet(@PathVariable int petId, @RequestBody Pet pet,@RequestParam("petImage") MultipartFile file) throws IOException
	{
		//upload the file to folder and update name to pet category
		pet.setPetImage(file.getOriginalFilename());
		File saveFile = new ClassPathResource("static/img").getFile();
		Path path = Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
		Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
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
	
	@GetMapping("/findByPetId/{petId}")
	public ResponseEntity<Pet> findByPetId(@PathVariable int petId)
	{
		return new ResponseEntity<Pet>(petServiceImpl.findByPetId(petId), HttpStatus.OK);
	}
	
	@GetMapping("/findByPetName/{petName}")
	public ResponseEntity<Pet> findByPetName(@PathVariable String petName)
	{
		return new ResponseEntity<Pet>(petServiceImpl.findByPetName(petName), HttpStatus.OK);
	}
	
	
}
