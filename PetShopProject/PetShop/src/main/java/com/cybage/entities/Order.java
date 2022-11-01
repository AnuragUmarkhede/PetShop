package com.cybage.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private String userAddress;
	private int pinCode;
	
	@OneToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	
}
