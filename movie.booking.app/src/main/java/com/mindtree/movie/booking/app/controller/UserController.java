package com.mindtree.movie.booking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.movie.booking.app.dao.RequestUserDao;
import com.mindtree.movie.booking.app.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	ResponseEntity<RequestUserDao> addUser(@RequestBody RequestUserDao reqUserDao){
		
		return new ResponseEntity<RequestUserDao>(userService.addUser(reqUserDao), HttpStatus.OK);
	}
}
