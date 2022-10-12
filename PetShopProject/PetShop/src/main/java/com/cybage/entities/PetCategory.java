package com.cybage.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class PetCategory 
{
	@Id
	@GeneratedValue
	private int categoryId;
	private String categoryName;
	private String categoryImage;
	
	@OneToMany(mappedBy = "petCategory",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Pet> pets;
}