package com.cybage.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Cart 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	
	private String sessionToken;
	
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
	@JsonManagedReference(value = "cartJson")
	@JsonIgnore
	private List<Pet> pets;
	
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
	@JsonManagedReference(value = "cartJson")
	@JsonIgnore
	private List<PetFood> petFoods;
	
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
	@JsonManagedReference(value = "cartJson")
	@JsonIgnore
	private List<PetAccessories> petAccessories;
	
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
	@JsonManagedReference(value = "cartJson")
	@JsonIgnore
	private List<CartItem> cartItems;
	
	@OneToOne
	@JoinColumn(name="user_email")
	@JsonManagedReference(value = "cartJson")
	private User user;
	
	@OneToOne(mappedBy = "cart",cascade = CascadeType.ALL)
	private Order order;
 	
}
