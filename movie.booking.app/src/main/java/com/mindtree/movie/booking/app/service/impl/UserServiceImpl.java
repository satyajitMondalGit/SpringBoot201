package com.mindtree.movie.booking.app.service.impl;

import org.springframework.stereotype.Service;

import com.mindtree.movie.booking.app.dao.RequestUserDao;
import com.mindtree.movie.booking.app.model.User;
import com.mindtree.movie.booking.app.repository.UserRepository;
import com.mindtree.movie.booking.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;
	@Override
	public RequestUserDao addUser(RequestUserDao reqUserDao) {
		User user = new User(reqUserDao.getUserId(),reqUserDao.getUserName(),reqUserDao.getMobileNumber(),reqUserDao.getEmail(), null);
		
		User updatedUser = userRepo.save(user);
		return new RequestUserDao(updatedUser.getUserId(),updatedUser.getUserName(),updatedUser.getMobileNumber(),updatedUser.getEmail());
	}

}
