package com.cybage.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class FavouriteItem 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "pet_id")
	@JsonBackReference(value = "petJson")
	private Pet pet;
	
	@ManyToOne
	@JoinColumn(name = "food_id")
	@JsonBackReference(value = "petFoodJson")
	private PetFood petFood;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	@JsonBackReference(value = "petAccessoriesJson")
	private PetAccessories petAccessories;
	
	@ManyToOne
	@JoinColumn(name = "favouriteList_id")
	@JsonBackReference(value = "favouriteListJson")
	private FavouriteList favouriteList;
}
