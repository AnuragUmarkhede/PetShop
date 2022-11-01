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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

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
public class PetAccessories 
{
	@Id
	@GeneratedValue
	private int itemId;
	@NotBlank(message = "Pet accessory name should not be null!")
	private String itemName;
	@NotBlank(message = "Pet accessory category name should not be null!")
	private String itemCategory;
	@NotBlank(message = "Pet accessory price should not be null!")
	@Positive(message = "Pet accessory price should be greated than 0")
	private double itemPrice;
	private String itemImage;
	@Positive(message = "Pet accessory quantity should be greated than 0")
	private int itemQuantity;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	@JsonBackReference(value = "cartJson")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name="favourite_id")
	@JsonBackReference(value = "favouriteJson")
	private FavouriteList favourite;
	
	@OneToMany(mappedBy = "petAccessories",cascade = CascadeType.ALL)
	@JsonManagedReference(value = "petAccessoriesJson")
	@JsonIgnore
	private List<FavouriteItem> favouriteItems;
}
