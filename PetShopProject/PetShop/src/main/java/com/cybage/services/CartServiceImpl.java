package com.cybage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.CartRepository;
import com.cybage.entities.Cart;
import com.cybage.exceptions.CartNotFoundException;

@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	CartRepository cartRepository;
	
	@Override
	public List<Cart> getAllCarts() {
		return cartRepository.findAll();
	}

	@Override
	public void deleteCart(int cartId) {
		Cart cartItemToBeDeleted = cartRepository.findById(cartId).orElseThrow(()-> new CartNotFoundException("Cart item does not exist for id "+cartId));
		cartRepository.delete(cartItemToBeDeleted);
	}

}
