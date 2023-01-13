package com.mindtree.movie.booking.app.service;

import com.mindtree.movie.booking.app.dto.UserDTO;

public interface UserService {

	UserDTO addUser(UserDTO userDto);

	UserDTO getUserDetails(long userId);

	UserDTO updateUser(long userId, UserDTO userDto);

}
