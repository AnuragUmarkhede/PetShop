package com.cybage.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	@JsonBackReference(value = "favPetAccessoriesJson")
	private User user;
	
	@OneToMany(mappedBy = "favouritePetAccessories",cascade = CascadeType.ALL)
	@JsonManagedReference(value = "favPetAccessoriesJson")
	@JsonIgnore
	private List<PetAccessories> petAccessories;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	@JsonBackReference(value = "cartJson")
	private Cart cart;
}
