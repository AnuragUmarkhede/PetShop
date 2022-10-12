package com.cybage.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.entities.FavouritePet;

@Repository
public interface FavouritePetRepository extends JpaRepository<FavouritePet, Integer> {

}
