 package com.cybage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.entities.FavouriteList;
import com.cybage.services.FavouriteListServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/favouriteList")
public class FavouriteListController 
{
	@Autowired
	FavouriteListServiceImpl favouriteListServiceImpl;
	
	@PostMapping("/addToFavouriteList/{id}/{sessionToken}")
	public ResponseEntity<FavouriteList> addToFavouriteList(@PathVariable int id, @PathVariable String sessionToken)
	{
		return new ResponseEntity<FavouriteList>(favouriteListServiceImpl.addToFavouriteList(id, sessionToken), HttpStatus.CREATED);
	}
	
	@GetMapping("/getFavouriteListBySessionToken/{sessionToken}")
	public ResponseEntity<FavouriteList> getFavouriteListBySessionToken(@PathVariable String sessionToken)
	{
		return new ResponseEntity<FavouriteList>(favouriteListServiceImpl.getFavouriteListBySessionToken(sessionToken), HttpStatus.OK);
	}
	
	@DeleteMapping("/removeFavouriteItemFromFavouriteList/{id}/{sessionToken}")
	public ResponseEntity<FavouriteList> removeFavouriteItemFromFavouriteList(@PathVariable int id, @PathVariable String sessionToken)
	{
		return new ResponseEntity<FavouriteList>(favouriteListServiceImpl.removeFavouriteItemFromFavouriteList(id, sessionToken), HttpStatus.OK);
	}
	
	@DeleteMapping("/clearFavouriteList/{sessionToken}")
	public ResponseEntity<String> clearFavouriteList(@PathVariable String sessionToken)
	{
		favouriteListServiceImpl.clearFavouriteList(sessionToken);
		return new ResponseEntity<String>("List cleared!", HttpStatus.OK);
	}

}
