package com.mindtree.movie.booking.app.service;

import javax.validation.Valid;

import com.mindtree.movie.booking.app.dto.ResponseUserTO;
import com.mindtree.movie.booking.app.dto.UserTO;
import com.mindtree.movie.booking.app.model.User;

public interface UserService {

	ResponseUserTO addUser(@Valid UserTO userTo);

	ResponseUserTO getUserDetails(@Valid long userId);

	ResponseUserTO updateUser(@Valid long userId, @Valid UserTO userTo);
	
}
