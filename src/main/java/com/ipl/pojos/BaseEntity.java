package com.ipl.pojos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass//mandatory cls level anno to tell hibernate 
//this is base class for other entities , do not create any table for it
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
