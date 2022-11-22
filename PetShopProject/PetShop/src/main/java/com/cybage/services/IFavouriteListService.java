package com.cybage.services;

import java.util.List;

import com.cybage.entities.FavouriteItem;

public interface IFavouriteListService {
	public FavouriteItem addToFavouriteList(int id, String userEmail);

	public List<FavouriteItem> getFavouriteList(String userEmail);
//
//	public FavouriteList removeFavouriteItemFromFavouriteList(int id, String sessionToken);
//
//	public void clearFavouriteList(String sessionToken);
}
