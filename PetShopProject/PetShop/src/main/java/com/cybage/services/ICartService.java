package com.cybage.services;

import java.util.List;

import com.cybage.entities.Cart;

public interface ICartService 
{
	//Method to get all cart item details
	public List<Cart> getAllCarts();
	
	//Method to delete cart item
	public void deleteCart(int cartId);
}
