package com.cybage.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class FavouriteList 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String sessionToken;
	
	@OneToMany(mappedBy = "favouriteList",cascade = CascadeType.ALL)
	@JsonManagedReference(value = "favouriteListJson")
	@JsonIgnore
	private List<FavouriteItem> favouriteItems;
	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	@JsonBackReference(value = "cartJson")
	private Cart cart;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
}
