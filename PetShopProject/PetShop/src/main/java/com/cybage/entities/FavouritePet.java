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
public class FavouritePet 
{
	@Id
	@GeneratedValue
	private int favouritePetId;
	
	@ManyToOne
	@JoinColumn(name="user_email")
	@JsonBackReference(value = "userJson")
	private User user;
	
	@OneToMany(mappedBy = "favouritePet",cascade = CascadeType.ALL)
	@JsonManagedReference(value = "favPetJson")
	@JsonIgnore
	private List<Pet> pets;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	@JsonBackReference(value = "cartJson")
	private Cart cart;
}
