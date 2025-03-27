package com.valtech.training.registerservice.services;

import java.util.List;

import com.valtech.training.registerservice.vos.UserVO;

public interface UserService {

	UserVO addUserToSubscription(UserVO uvo, long sid);

	UserVO getUserById(long id);

	List<UserVO> getUserBySubscriptionId(long subId);

	UserVO signIn(UserVO uvo);

	void deleteUserFromSubscription(long userId);

}