package com.cybage.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name="order_table")
public class Order 
{
	@Id
	@GeneratedValue
	private int orderId;
	private double orderPrice;
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<PetFood> petFoods;
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<PetAccessories> petAccessories;
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Cart> cartItems;
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Pet> pets;
}
