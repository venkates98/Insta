package com.instagram.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.instagram.customException.PostNotFoundException;
import com.instagram.customException.UserNotFoundException;
import com.instagram.entity.Post;
import com.instagram.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostService postService;

	@PostMapping("/user/{userId}")
	public Post createPost(@PathVariable Long userId, @RequestBody Post post) throws UserNotFoundException {
		return postService.createPost(userId, post);
	}

	@PutMapping("/{postId}")
	public Post editPost(@PathVariable Long postId, @RequestBody Post postDetails) throws PostNotFoundException {
		return postService.editPost(postId, postDetails);
	}

	@DeleteMapping("/{postId}")
	public void deletePost(@PathVariable Long postId) throws PostNotFoundException {
		postService.deletePost(postId);
	}

	@GetMapping("/user/{userId}")
	public List<Post> getPostsByUserId(@PathVariable Long userId) {
		return postService.getPostsByUserId(userId);
	}
}
