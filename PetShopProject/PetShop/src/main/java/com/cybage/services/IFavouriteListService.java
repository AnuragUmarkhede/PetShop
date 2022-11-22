package com.cybage.services;

import com.cybage.entities.FavouriteList;

public interface IFavouriteListService {
	public FavouriteList addToFavouriteList(int id, String sessionToken , String userEmail);

	public FavouriteList getFavouriteListBySessionToken(String sessionToken);

	public FavouriteList removeFavouriteItemFromFavouriteList(int id, String sessionToken);

	public void clearFavouriteList(String sessionToken);
}
