package com.cybage.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
public class FavouritePetAccessories 
{
	@Id
	@GeneratedValue
	private int favouriteItemId;
	
	@ManyToOne
	@JoinColumn(name="user_email")
	@JsonBackReference
	private User user;
	
	@OneToOne
	@JoinColumn(name="item_id")
	private PetAccessories petAccessories;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	@JsonBackReference
	private Cart cart;
}
