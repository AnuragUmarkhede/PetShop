package com.cybage.services;

import com.cybage.entities.Cart;

public interface ICartService {
	
	//Method to add item to cart
	public Cart addToCartList(int cartId, String sessionToken);
	
	// Method to get all cart item details
//	public List<Cart> getAllCarts();
	public Cart getCartBySessionToken(String sessionToken);

	// Method to delete cart item
//	public void deleteCart(int cartId);
	public Cart removecartItemFromCart(int cartId, String sessionToken);
	
	public void clearCart(String sessionToken);
}
