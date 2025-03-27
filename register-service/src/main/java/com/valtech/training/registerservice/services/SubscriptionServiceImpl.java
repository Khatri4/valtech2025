package com.valtech.training.registerservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.registerservice.entities.User;
import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.repos.UserRepo;
import com.valtech.training.registerservice.vos.SubscriptionVO;
import com.valtech.training.registerservice.vos.UserVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SubscriptionServiceImpl implements SubscriptionService {
	
	@Autowired
	private SubscriptionRepo subRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserService userService;
	
	public SubscriptionVO addSubscription(SubscriptionVO svo) {
		List<User> user = userRepo.findAll();
		return SubscriptionVO.from(subRepo.save(svo.to(user)));
	}
	
	@Override
	public SubscriptionVO getSubscriptionById(long subId) {
		return SubscriptionVO.from(subRepo.getReferenceById(subId));
	}
	
	@Override
	public List<SubscriptionVO> getAllSubscription(){
		return SubscriptionVO.from(subRepo.findAll());
	}

}
