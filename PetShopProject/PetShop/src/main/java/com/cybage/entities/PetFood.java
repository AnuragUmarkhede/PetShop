package com.cybage.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class PetFood 
{
	@Id
	@GeneratedValue
	private int foodId;
	private String foodName;
	private String foodCategory;
	private double foodPrice;
	private String foodImage;
	private int foodQuantity;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
}
