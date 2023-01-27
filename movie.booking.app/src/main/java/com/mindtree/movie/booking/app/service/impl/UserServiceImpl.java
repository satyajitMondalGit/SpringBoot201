package com.mindtree.movie.booking.app.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.movie.booking.app.dto.UserTO;
import com.mindtree.movie.booking.app.exception.ResourceNotFoundException;
import com.mindtree.movie.booking.app.model.User;
import com.mindtree.movie.booking.app.repository.UserRepository;
import com.mindtree.movie.booking.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User addUser(@Valid UserTO userTo) {
		User user = User.build(0, userTo.getUserName(), userTo.getMobileNumber(), userTo.getEmail(), null);
		return userRepo.save(user);
	}

	@Override
	public User getUserDetails(@Valid long userId) {
		return userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "userId",userId));
	}

	@Override
	public User updateUser(@Valid long userId, @Valid UserTO userTo) {
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "userId",userId));
		
		return User.build(user.getUserId(), userTo.getUserName(), userTo.getMobileNumber(), userTo.getEmail(), null);
	}


}
