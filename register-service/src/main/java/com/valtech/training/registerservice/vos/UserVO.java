package com.valtech.training.registerservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;

public record UserVO(long id, String name, int age, String mobile, String email ,Boolean isKid, long subId) {
	
	public static UserVO from(User user) {
		return new UserVO(user.getId(), user.getName(), user.getAge(), user.getMobile(), user.getEmail(), user.isKid(), user.getSubscription().getId());
	}
	
	public static List<UserVO> from(List<User> user){
		return user.stream().map(u -> UserVO.from(u)).collect(Collectors.toList());
	}
	
	public User to(Subscription sub) {
		User user = new User(name, mobile, age, email, isKid);
		user.setSubscription(sub);
		return user;
	}
	

		


}
