package com.mindtree.movie.booking.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.movie.booking.app.dto.UserDTO;
import com.mindtree.movie.booking.app.exception.ResourceNotFoundException;
import com.mindtree.movie.booking.app.model.User;
import com.mindtree.movie.booking.app.repository.UserRepository;
import com.mindtree.movie.booking.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDTO addUser(UserDTO userDto) {

		User user = new User(0,userDto.getUserName(),userDto.getMobileNumber(),userDto.getEmail());
		
		User updatedUser = userRepo.save(user);
		
		return new UserDTO(updatedUser.getUserId(),updatedUser.getUserName(),updatedUser.getMobileNumber(),updatedUser.getEmail());
	}

	@Override
	public UserDTO getUserDetails(long userId) {
		
		User updatedUser = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "userId",userId));
		
		return new UserDTO(updatedUser.getUserId(),updatedUser.getUserName(),updatedUser.getMobileNumber(),updatedUser.getEmail());
	}

	@Override
	public UserDTO updateUser(long userId, UserDTO userDto) {
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "userId",userId));
		user.setUserName(userDto.getUserName());
		user.setEmail(userDto.getEmail());
		user.setMobileNumber(userDto.getMobileNumber());
		User updatedUser = userRepo.save(user);
		return new UserDTO(updatedUser.getUserId(),updatedUser.getUserName(),updatedUser.getMobileNumber(),updatedUser.getEmail());
	}
	

}
