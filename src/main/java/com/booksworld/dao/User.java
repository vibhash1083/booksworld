package com.booksworld.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empId;
	
	@Column(name = "USER_NAME")
	private String name;
	
	@Column(name = "USER_LOCATION")
	private String location;
	
	@Column(name = "IMAGE")
	private String image_path;

}
