package com.instagram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.customException.PostNotFoundException;
import com.instagram.customException.UserNotFoundException;
import com.instagram.entity.Post;
import com.instagram.entity.User;
import com.instagram.repository.PostRepository;


import java.util.List;

@Service
public class PostService {

	 @Autowired
	    private PostRepository postRepository;

	    @Autowired
	    private UserService userService;

	    public Post createPost(Long userId, Post post) throws UserNotFoundException {
	        User user = userService.getUserById(userId);
	        post.setUser(user);
	        return postRepository.save(post);
	    }

	    public Post editPost(Long postId, Post postDetails) throws PostNotFoundException {
	        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException("Post not found"));
	        post.setDescription(postDetails.getDescription());
	        post.setImagePath(postDetails.getImagePath());
	        return postRepository.save(post);
	    }

	    public void deletePost(Long postId) throws PostNotFoundException {
	        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException("Post not found"));
	        postRepository.delete(post);
	    }

	    public List<Post> getPostsByUserId(Long userId) {
	        return postRepository.findByUserId(userId);
	    }}
