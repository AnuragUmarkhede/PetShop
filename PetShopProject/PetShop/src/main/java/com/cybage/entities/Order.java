package com.cybage.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	private List<PetFood> petFoods;
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
	private List<PetAccessories> petAccessories;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
	private List<Pet> pets;
}
