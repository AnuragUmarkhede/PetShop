package com.cybage.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.entities.FavouriteItem;

@Repository
public interface FavouriteItemRepository extends JpaRepository<FavouriteItem, Integer> {

}
