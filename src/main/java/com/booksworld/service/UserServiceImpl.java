package com.booksworld.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksworld.dao.User;
import com.booksworld.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	
	@Override
	public User getUser(Long userId) {
		 Optional<User> optTrans = userRepository.findById(userId);
		return optTrans.get();
	}


	

}

