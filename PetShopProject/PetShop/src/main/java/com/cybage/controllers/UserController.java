package com.cybage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.entities.User;
import com.cybage.services.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user)
	{
		return new ResponseEntity<User>(userServiceImpl.addUser(user), HttpStatus.CREATED);
	}
	
	@PutMapping("/updateUser/{userEmail}")
	public ResponseEntity<User> updateUser(@PathVariable String userEmail, @RequestBody User user)
	{
		return new ResponseEntity<User>(userServiceImpl.updateUser(userEmail, user), HttpStatus.OK);
	}
	
	@GetMapping("/findByUserEmail/{userEmail}")
	public ResponseEntity<User> findByUserEmail(@PathVariable String userEmail)
	{
		return new ResponseEntity<User>(userServiceImpl.findByUserEmail(userEmail), HttpStatus.OK);
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>> getAllUser()
	{
		return new ResponseEntity<List<User>>(userServiceImpl.getAllUser(), HttpStatus.OK);
	}
	
	
	@PostMapping("/userLogin")
	public ResponseEntity<User> login(@RequestBody User user)
	{
		user=userServiceImpl.login(user);
		if(user!=null) {
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		else
		{
			return null;
		}
	}
	

}
