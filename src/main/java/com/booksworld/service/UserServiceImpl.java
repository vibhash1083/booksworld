package com.booksworld.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksworld.dao.Book;
import com.booksworld.dao.User;
import com.booksworld.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> retrieveUsers() {
		  List<User> users = userRepository.findAll();
		  return users;
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);

	}

	@Override
	public User getUser(Long userId) {
		 Optional<User> optTrans = userRepository.findById(userId);
		return optTrans.get();
	}
	
	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
		
	}
	

}

