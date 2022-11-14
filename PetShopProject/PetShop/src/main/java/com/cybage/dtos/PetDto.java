package com.cybage.dtos;

import org.springframework.stereotype.Component;

import com.cybage.entities.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDto 
{
	private int categoryId;
	private int petId;
	private String petName;
	private Gender gender;
	private double petPrice;
	private String petDescription;
	private String petImage;
}
