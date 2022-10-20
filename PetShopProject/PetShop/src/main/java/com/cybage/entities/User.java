package com.cybage.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private FavouriteList favouriteList;
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private Cart cart;
	
}
