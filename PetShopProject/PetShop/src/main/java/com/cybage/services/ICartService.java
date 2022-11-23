package com.cybage.services;

import java.util.List;

import com.cybage.entities.CartItem;

public interface ICartService {
	
//	//Method to add item to cart
//	public Cart addToCartList(int cartId, String sessionToken);
//	
//	// Method to get all cart item details
////	public List<Cart> getAllCarts();
//	public Cart getCartBySessionToken(String sessionToken);
//
//	// Method to delete cart item
////	public void deleteCart(int cartId);
//	public Cart removecartItemFromCart(int cartId, String sessionToken);
//	
//	public void clearCart(String sessionToken);
	
	
	public CartItem addToCartList(int id, String userEmail);

	public List<CartItem> getCartList(String userEmail);
	
	public void removeCartItem(int id,String userEmail);
}
