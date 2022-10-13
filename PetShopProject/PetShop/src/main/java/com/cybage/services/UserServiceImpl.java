package com.cybage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.UserRepository;
import com.cybage.entities.User;
import com.cybage.exceptions.UserNotFoundException;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(String userEmail, User user) {
		User userToBeUpdated = userRepository.findById(userEmail).orElseThrow(()-> new UserNotFoundException("User does not exist for email id "+userEmail));
		return userRepository.save(userToBeUpdated);
		
	}
	
	@Override
	public User findByUserEmail(String userEmail) {
		return userRepository.findById(userEmail).orElseThrow(()-> new UserNotFoundException("User does not exist for email id "+userEmail));
		
	}
	
	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

}
