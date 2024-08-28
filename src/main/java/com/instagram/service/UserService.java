package com.instagram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.customException.UserNotFoundException;
import com.instagram.entity.Post;
import com.instagram.entity.User;
import com.instagram.repository.PostRepository;
import com.instagram.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	PostRepository postRepository;

	public String saveUser(User user) {
		userRepository.save(user);
		return "Created Successfully";
	}

	public User getUserById(Long id) throws UserNotFoundException {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
	}

	public User getUserByUsername(String username) throws UserNotFoundException {
		return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found"));
	}

	public List<Post> signin(String username, String password) throws UserNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UserNotFoundException("User not found"));

		if (user.getPassword().equals(password)) {
			return postRepository.findByUserId(user.getId());
		} else {
			throw new UserNotFoundException("Invalid username or password");
		}
	}
}
