package com.booksworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.booksworld.dao.Book;
import com.booksworld.dao.User;
import com.booksworld.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/api/users")
	public List<User> Users() {
		List<User> users = userService.retrieveUsers();
		return users;
	}

	@GetMapping("/api/users/{userId}")
	public User getUser(@PathVariable(name = "userId") Long userId) {
		return userService.getUser(userId);
	}
	
	@PostMapping(path = "/api/user", consumes = "application/json", produces = "application/json")
	public void saveUser(@RequestBody User user) {
		userService.saveUser(user);
		System.out.println("User Saved Successfully");
	}
	
	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable(name = "userId") Long userId) {
		userService.deleteUser(userId);
		System.out.println("User Deleted Successfully");
	}

	@PutMapping("/api/user/{userId}")
	public void updateUser(@RequestBody User user, @PathVariable(name = "userId") Long userId) {
		User existing_user = userService.getUser(userId);
		if (existing_user != null) {
			user.setUserId(existing_user.getUserId());
			userService.updateUser(user);
		}
	}

}
