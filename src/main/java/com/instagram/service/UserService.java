package com.instagram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.customException.UserNotFoundException;
import com.instagram.entity.User;
import com.instagram.repository.UserRepository;

@Service
public class UserService {

	 @Autowired
	    private UserRepository userRepository;

	    public User saveUser(User user) {
	        return userRepository.save(user);
	    }

	    public User getUserById(Long id) throws UserNotFoundException {
	        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
	    }

	    public User getUserByUsername(String username) {
	        return userRepository.findByUsername(username);
	    }}