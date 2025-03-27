package com.valtech.training.springsecurity.vos;

import com.valtech.training.springsecurity.entities.User;

public record UserVO(Long id, String username, String password) {

//	public UserVO from(User user) {
//		
//	}
	
	public User to() {
		return new User(id == null ? 0 : id, username, password, "USER");
	}
}
