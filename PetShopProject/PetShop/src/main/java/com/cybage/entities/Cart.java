package com.cybage.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Cart 
{
	@Id
	@GeneratedValue
	private int cartId;
	
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Pet> pets;
	
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<PetFood> petFoods;
	
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<PetAccessories> petAccessories;
	
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<FavouritePetFood> favouritePetFoods;
	
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<FavouritePetAccessories> favouritePetAccessories;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
 	
}
