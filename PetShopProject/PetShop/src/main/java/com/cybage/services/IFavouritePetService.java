package com.cybage.services;

import java.util.List;

import com.cybage.entities.FavouritePet;

public interface IFavouritePetService 
{
	//Method to delete favourite pet
	public void deleteFavouritePet(int favouritePetId);
	
	//Method to get all favourite pet details
	public List<FavouritePet> getAllFavouritePets();
}
