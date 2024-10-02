package com.mohan;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	
	private int id;
	private String name;
	private String address;
}
