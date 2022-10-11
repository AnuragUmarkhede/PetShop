package com.cybage.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class User 
{
	@Id
	private String userEmail;
	private String userFirstName;
	private String userLastName;
	private String userPassword;
	private String userContact;
	private UserRole userRole;
	private Gender gender;
	private String userAddress;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<FavouritePet> favouritePets;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<FavouritePetFood> favouritePetFoods;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<FavouritePetAccessories> favouritePetAccessories;
}
