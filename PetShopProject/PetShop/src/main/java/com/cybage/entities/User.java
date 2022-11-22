package com.cybage.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class User 
{
	@Id
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
    flags = Pattern.Flag.CASE_INSENSITIVE)
	private String userEmail;
	@NotBlank(message = "First name cant be empty!")
	private String userFirstName;
	@NotBlank(message = "Last name cant be empty!")
	private String userLastName;
	@NotBlank(message = "Password should not be null!")
	@Size(min = 4,max = 15, message = "Password should be between 4 to 15 characters!")
	private String userPassword;
	
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	
	@OneToOne(mappedBy = "user")
	@JsonBackReference(value = "cartJson")
	private Cart cart;
	
	@OneToMany(mappedBy = "userMail")
	@JsonManagedReference
	private List<FavouriteItem> favouriteItem;
	
}
