package com.cybage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.UserRepository;
import com.cybage.entities.User;
import com.cybage.entities.UserRole;
import com.cybage.exceptions.UserNotFoundException;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User addUser(User user) {
		user.setUserRole(UserRole.CUSTOMER);
		return userRepository.save(user);
	}

	@Override
	public User updateUser(String userEmail, User user) {
		userRepository.findById(userEmail)
				.orElseThrow(() -> new UserNotFoundException("User does not exist for email id " + userEmail));
		return userRepository.save(user);

	}

	@Override
	public User findByUserEmail(String userEmail) {
		return userRepository.findById(userEmail)
				.orElseThrow(() -> new UserNotFoundException("User does not exist for email id " + userEmail));

	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User fetchUserByEmailAndPassword(String email, String password) {
		return userRepository.findByUserEmailAndUserPassword(email, password);
	}

	public User login(User user) {
		return userRepository.findByUserEmailAndUserPassword(user.getUserEmail(), user.getUserPassword());

	}

}
