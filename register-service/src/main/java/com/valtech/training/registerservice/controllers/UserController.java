package com.valtech.training.registerservice.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.registerservice.services.UserService;
import com.valtech.training.registerservice.vos.UserVO;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<UserVO> getUserById(@PathVariable("id") long id) {
		try {
			return ResponseEntity.ok(userService.getUserById(id));
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.of(Optional.empty());
		}
		
	}
	
	@PostMapping("/")
	public UserVO signIn(@RequestBody UserVO uvo) {
		return userService.signIn(uvo);
	}

	
	@PostMapping("/subscription/{sid}")
	public UserVO addUserToSubscription(@PathVariable("sid") long sid, @RequestBody UserVO uvo) {
		return userService.addUserToSubscription(uvo, sid);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUserFromSubscription(@PathVariable("userId") long userId) {
		 userService.deleteUserFromSubscription(userId);
	}
}
