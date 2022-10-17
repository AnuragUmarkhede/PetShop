package com.cybage.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
public class User 
{
	@Id
	private String userEmail;
	private String userFirstName;
	private String userLastName;
	private String userPassword;
	private String userContact;
	
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private String userAddress;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonManagedReference(value = "userJson")
	@JsonIgnore
	private List<FavouritePet> favouritePets;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonManagedReference(value = "userJson")
	@JsonIgnore
	private List<FavouritePetFood> favouritePetFoods;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonManagedReference(value = "favPetAccessoriesJson")
	@JsonIgnore
	private List<FavouritePetAccessories> favouritePetAccessories;
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private Cart cart;
}
