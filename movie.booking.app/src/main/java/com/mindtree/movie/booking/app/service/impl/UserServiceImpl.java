package com.mindtree.movie.booking.app.service.impl;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.movie.booking.app.dto.ResponseUserTO;
import com.mindtree.movie.booking.app.dto.UserTO;
import com.mindtree.movie.booking.app.exception.ResourceNotFoundException;
import com.mindtree.movie.booking.app.model.User;
import com.mindtree.movie.booking.app.repository.UserRepository;
import com.mindtree.movie.booking.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, readOnly = false)
	public ResponseUserTO addUser(@Valid UserTO userTo) {
		User user = User.build(0, userTo.getUserName(), userTo.getMobileNumber(), userTo.getEmail(), null);
		User savedUser = userRepo.save(user);
		
		logger.info("UserServiceImpl - addUser ", "User", savedUser.toString());
		return new ResponseUserTO(savedUser.getUserId(),savedUser.getUserName(),savedUser.getMobileNumber(),savedUser.getEmail());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, readOnly = true)
	public ResponseUserTO getUserDetails(@Valid long userId) {
		User user =  userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "userId",userId));
		
		logger.info("UserServiceImpl - getUserDetails ", "User", user.toString());
		
		return new ResponseUserTO(user.getUserId(),user.getUserName(),user.getMobileNumber(),user.getEmail());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, readOnly = false)
	public ResponseUserTO updateUser(@Valid long userId, @Valid UserTO userTo) {
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "userId",userId));
		
		logger.info("UserServiceImpl - updateUser ", "User", user.toString());
		User updatedUser = userRepo.save(User.build(user.getUserId(), userTo.getUserName(), userTo.getMobileNumber(), userTo.getEmail(), null));
		logger.info("UserServiceImpl - updateUser ", "updatedUser", updatedUser.toString());
		
		return new ResponseUserTO(updatedUser.getUserId(),updatedUser.getUserName(),updatedUser.getMobileNumber(),updatedUser.getEmail());
		
	}


}
