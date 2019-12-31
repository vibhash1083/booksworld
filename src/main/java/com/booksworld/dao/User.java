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
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "USER_LOCATION")
	private String userLocation;

	@Column(name = "IMAGE")
	private String image;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "PASSWORD")
	private String password;

//    @Transient
//    private String passwordConfirm;
//    
//    @ManyToMany
//    private Set<Role> roles;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public String getPasswordConfirm() {
//        return passwordConfirm;
//    }
//
//    public void setPasswordConfirm(String passwordConfirm) {
//        this.passwordConfirm = passwordConfirm;
//    }
//
//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }

}
