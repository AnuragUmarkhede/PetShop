package com.cybage.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> 
{
	//Method to find user by email and password
	public User findByUserEmailAndUserPassword(String email, String password);
	
	//Method to find user by email
	public User findByUserEmail(String userEmail);

}
