package com.cybage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.entities.Cart;
import com.cybage.services.CartServiceImpl;

@RestController
@RequestMapping("/cart")
public class CartController 
{
	@Autowired
	CartServiceImpl cartServiceImpl;
	
	@GetMapping("/getAllCarts")
	public ResponseEntity<List<Cart>> getAllCarts()
	{
		return new ResponseEntity<List<Cart>>(cartServiceImpl.getAllCarts(), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCart/{cartId}")
	public ResponseEntity<String> deleteCart(@PathVariable int cartId)
	{
		cartServiceImpl.deleteCart(cartId);
		return new ResponseEntity<String>("Cart item deleted successfully with cart id "+cartId, HttpStatus.OK);
	}
}
