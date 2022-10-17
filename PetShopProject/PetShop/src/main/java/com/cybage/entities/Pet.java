package com.cybage.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Pet 
{
	@Id
	@GeneratedValue
	private int petId;
	private String petName;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private double petPrice;
	private String petDescription;
	private String petImage;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	@JsonBackReference(value = "petCategoryJson")
	private PetCategory petCategory;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	@JsonBackReference(value = "cartJson")
	private Cart cart;
 
	@ManyToOne
	@JoinColumn(name="favourite_pet_id")
	@JsonBackReference(value = "favPetJson")
	private FavouritePet favouritePet;
	
}
