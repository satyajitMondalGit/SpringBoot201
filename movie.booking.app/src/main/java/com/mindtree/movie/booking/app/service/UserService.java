package com.mindtree.movie.booking.app.service;

import javax.validation.Valid;

import com.mindtree.movie.booking.app.dto.UserTO;
import com.mindtree.movie.booking.app.model.User;

public interface UserService {

	User addUser(@Valid UserTO userTo);

	User getUserDetails(@Valid long userId);

	User updateUser(@Valid long userId, @Valid UserTO userTo);
	
}
