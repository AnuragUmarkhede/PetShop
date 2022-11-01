package com.cybage.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Pet
{
	@Id
	@GeneratedValue
	private int petId;
	@NotBlank(message = "Pet name should not be null!")
	private String petName;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@NotBlank(message = "Pet price should not be null!")
	@Positive(message = "Pet price should be greated than 0")
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
	@JoinColumn(name="id")
	@JsonBackReference(value = "favouriteListJson")
	private FavouriteList favouriteList;

	@OneToMany(mappedBy = "pet",cascade = CascadeType.ALL)
	@JsonManagedReference(value = "petJson")
	@JsonIgnore
	private List<FavouriteItem> favouriteItems;
}
