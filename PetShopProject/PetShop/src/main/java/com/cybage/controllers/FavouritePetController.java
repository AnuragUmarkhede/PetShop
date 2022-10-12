package com.cybage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.entities.FavouritePet;
import com.cybage.services.FavouritePetServiceImpl;

@RestController
@RequestMapping("/favouritePet")
public class FavouritePetController 
{
	@Autowired
	FavouritePetServiceImpl favouritePetServiceImpl;
	
	@DeleteMapping("/deleteFavouritePet/{favouritePetId}")
	public ResponseEntity<String> deleteFavouritePet(@PathVariable int favouritePetId)
	{
		favouritePetServiceImpl.deleteFavouritePet(favouritePetId);
		return new ResponseEntity<String>("Favourite pet details deleted successfully for favouite pet id "+favouritePetId, HttpStatus.OK);
	}
	
	@GetMapping("/getAllFavouritePets")
	public ResponseEntity<List<FavouritePet>> getAllFavouritePets()
	{
		return new ResponseEntity<List<FavouritePet>>(favouritePetServiceImpl.getAllFavouritePets(), HttpStatus.OK);
	}
}
