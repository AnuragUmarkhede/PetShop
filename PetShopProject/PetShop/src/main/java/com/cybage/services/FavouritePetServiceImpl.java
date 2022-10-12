package com.cybage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.FavouritePetRepository;
import com.cybage.entities.FavouritePet;
import com.cybage.exceptions.FavouritePetNotFoundException;

@Service
public class FavouritePetServiceImpl implements IFavouritePetService {
	
	@Autowired
	FavouritePetRepository favouritePetRepository;

	@Override
	public void deleteFavouritePet(int favouritePetId) {
		FavouritePet favouritePetToBeDeleted = favouritePetRepository.findById(favouritePetId).orElseThrow(()-> new FavouritePetNotFoundException("Favourite pet does not exist for id "+favouritePetId));
		favouritePetRepository.delete(favouritePetToBeDeleted);
	}

	@Override
	public List<FavouritePet> getAllFavouritePets() {
		return favouritePetRepository.findAll();
	}

}
