package com.cybage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.FavouriteItemRepository;
import com.cybage.daos.FavouriteListRepository;
import com.cybage.daos.PetAccessoriesRepository;
import com.cybage.daos.PetCategoryRepository;
import com.cybage.daos.PetFoodRepository;
import com.cybage.daos.PetRepository;
import com.cybage.entities.FavouriteItem;
import com.cybage.entities.FavouriteList;

@Service
public class FavouriteListServiceImpl implements IFavouriteListService {

	@Autowired
	FavouriteItemRepository favouriteItemRepository;

	@Autowired
	FavouriteListRepository favouriteListRepository;

	@Autowired
	PetServiceImpl petServiceImpl;

	@Autowired
	PetFoodServiceImpl petFoodServiceImpl;

	@Autowired
	PetAccessoriesServiceImpl petAccessoriesServiceImpl;
	
	@Autowired
	PetCategoryRepository petCategoryRepository;
	
	@Autowired
	PetRepository petRepository;
	
	@Autowired
	PetFoodRepository petFoodRepository;
	
	@Autowired
	PetAccessoriesRepository petAccessoriesRepository;

	@Override
	public FavouriteList addToFavouriteList(int id, String sessionToken) {
		FavouriteList favouriteList = new FavouriteList();
		FavouriteItem favouriteItem = new FavouriteItem();
		
		
		
		
		favouriteItem.setPet(petServiceImpl.findByPetId(id));
		favouriteItem.setPetFood(petFoodServiceImpl.findByFoodId(id));
		favouriteItem.setPetAccessories(petAccessoriesServiceImpl.findByItemId(id));
		favouriteList.getFavouriteItems().add(favouriteItem);
		favouriteList.setSessionToken(sessionToken);
		System.out.println("fav item"+favouriteItem);
		System.out.println("fav list"+favouriteList);
		return favouriteListRepository.save(favouriteList);
	}

	@Override
	public FavouriteList getFavouriteListBySessionToken(String sessionToken) {
		return favouriteListRepository.findBySessionToken(sessionToken);
	}

	@Override
	public FavouriteList removeFavouriteItemFromFavouriteList(int id, String sessionToken) {
		FavouriteList favouriteList = favouriteListRepository.findBySessionToken(sessionToken);
		List<FavouriteItem> favouriteItems = favouriteList.getFavouriteItems();
		FavouriteItem item = null;
		for (FavouriteItem item1 : favouriteItems) {
			if (item1.getId() == id) {
				item = item1;
			}
		}
		favouriteItems.remove(item);
		favouriteItemRepository.delete(item);
		favouriteList.setFavouriteItems(favouriteItems);
		return favouriteListRepository.save(favouriteList);
	}

	@Override
	public void clearFavouriteList(String sessionToken) {
		FavouriteList favouriteList = favouriteListRepository.findBySessionToken(sessionToken);
		favouriteListRepository.delete(favouriteList);
	}

}
