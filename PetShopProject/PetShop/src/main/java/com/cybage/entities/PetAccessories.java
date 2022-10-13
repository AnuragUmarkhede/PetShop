package com.cybage.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	@OneToOne(mappedBy = "favouriteItemId",cascade = CascadeType.ALL)
	private FavouritePetAccessories favouritePetAccessories;
}
