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
public class PetFood 
{
	@Id
	@GeneratedValue
	private int foodId;
	private String foodName;
	private String foodCategory;
	private double foodPrice;
	private String foodImage;
	private int foodQuantity;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	@JsonBackReference(value = "cartJson")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "favourite_id")
	@JsonBackReference(value = "favouriteJson")
	private FavouriteList favourite;
	
	@OneToMany(mappedBy = "petFood",cascade = CascadeType.ALL)
	@JsonManagedReference(value = "petFoodJson")
	@JsonIgnore
	private List<FavouriteItem> favouriteItems;
}
