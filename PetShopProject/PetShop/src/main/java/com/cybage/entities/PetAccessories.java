package com.cybage.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
public class PetAccessories 
{
	@Id
	@GeneratedValue
	private int itemId;
	private String itemName;
	private String itemCategory;
	private double itemPrice;
	private String itemImage;
	private int itemQuantity;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	@JsonBackReference(value = "cartJson")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name="favourite_item_id")
	@JsonBackReference(value = "favPetAccessoriesJson")
	private FavouritePetAccessories favouritePetAccessories;
}
