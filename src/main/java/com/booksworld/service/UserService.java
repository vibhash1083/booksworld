package com.booksworld.service;

import java.util.List;

import com.booksworld.dao.Book;
import com.booksworld.dao.User;

public interface UserService {

	 public List<User> retrieveUsers();
	
	public User getUser(Long userId);
	
	public void saveUser(User user);
	
	public void deleteUser(Long userId);
	 
	public void updateUser(User user);
	
}

