package com.cybage.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.entities.FavouriteList;

@Repository
public interface FavouriteListRepository extends JpaRepository<FavouriteList, Integer> {
	public FavouriteList findBySessionToken(String sessionToken);
}
