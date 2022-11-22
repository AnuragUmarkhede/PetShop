package com.cybage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.entities.FavouriteItem;
import com.cybage.services.FavouriteListServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/favouriteList")
public class FavouriteListController 
{

	@Autowired
	private FavouriteListServiceImpl favouriteListServiceImpl;
	
	@PostMapping("/addToFavouriteList/{id}/{userEmail}")
	public ResponseEntity<FavouriteItem> addToFavouriteList(@PathVariable int id, @PathVariable("userEmail") String userEmail)
	{
		return new ResponseEntity<FavouriteItem>(favouriteListServiceImpl.addToFavouriteList(id , userEmail), HttpStatus.CREATED);
	}
	
	@GetMapping("/getFavouriteList/{userEmail}")
	public ResponseEntity<List<FavouriteItem>> getFavouriteListBySessionToken(@PathVariable String userEmail)
	{
		return new ResponseEntity<List<FavouriteItem>>(favouriteListServiceImpl.getFavouriteList(userEmail), HttpStatus.OK);
	}
	
//	
//	@DeleteMapping("/removeFavouriteItemFromFavouriteList/{id}/{sessionToken}")
//	public ResponseEntity<FavouriteList> removeFavouriteItemFromFavouriteList(@PathVariable int id, @PathVariable String sessionToken)
//	{
//		return new ResponseEntity<FavouriteList>(favouriteListServiceImpl.removeFavouriteItemFromFavouriteList(id, sessionToken), HttpStatus.OK);
//	}
//	
//	@DeleteMapping("/clearFavouriteList/{sessionToken}")
//	public ResponseEntity<String> clearFavouriteList(@PathVariable String sessionToken)
//	{
//		favouriteListServiceImpl.clearFavouriteList(sessionToken);
//		return new ResponseEntity<String>("List cleared!", HttpStatus.OK);
//	}

}
