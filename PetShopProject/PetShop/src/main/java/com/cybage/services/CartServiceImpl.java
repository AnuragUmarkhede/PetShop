package com.cybage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.CartItemRepository;
import com.cybage.daos.CartRepository;
import com.cybage.entities.Cart;
import com.cybage.entities.CartItem;

@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	CartItemRepository cartItemRepository;
	
	@Autowired
	CartRepository cartRepository;

	@Autowired
	PetServiceImpl petServiceImpl;

	@Autowired
	PetFoodServiceImpl petFoodServiceImpl;

	@Autowired
	PetAccessoriesServiceImpl petAccessoriesServiceImpl;
	@Override
	public Cart addToCartList(int id, String sessionToken) {
		Cart cart = new Cart();
		CartItem cartItem = new CartItem();
		cartItem.setPet(petServiceImpl.findByPetId(id));
		cartItem.setPetFood(petFoodServiceImpl.findByFoodId(id));
		cartItem.setPetAccessories(petAccessoriesServiceImpl.findByItemId(id));
		cart.getCartItems().add(cartItem);
		cart.setSessionToken(sessionToken);
		return cartRepository.save(cart);
	}
	@Override
	public Cart getCartBySessionToken(String sessionToken) {
		return cartRepository.findBySessionToken(sessionToken);
	}
	@Override
	public Cart removecartItemFromCart(int cartId, String sessionToken) {
		
		Cart cart = cartRepository.findBySessionToken(sessionToken);
		List<CartItem> cartItems = cart.getCartItems();
		CartItem item = null;
		for (CartItem item1 : cartItems) {
			if (item1.getId() == cartId) {
				item = item1;
			}
		}
		cartItems.remove(item);
		cartItemRepository.delete(item);
		cart.setCartItems(cartItems);
		return cartRepository.save(cart);
	}
	@Override
	public void clearCart(String sessionToken) {

		Cart cart = cartRepository.findBySessionToken(sessionToken);
		cartRepository.delete(cart);
		
	}

	
}
