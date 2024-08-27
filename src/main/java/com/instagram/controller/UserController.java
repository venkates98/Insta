package com.instagram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instagram.customException.UserNotFoundException;
import com.instagram.entity.User;
import com.instagram.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/signup")
	public String createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) throws UserNotFoundException {
		return userService.getUserById(id);
	}

	@GetMapping("/username/{username}")
	public User getUserByUsername(@PathVariable String username) throws UserNotFoundException {
		return userService.getUserByUsername(username);
	}
}