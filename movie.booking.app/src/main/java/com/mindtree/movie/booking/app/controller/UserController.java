package com.mindtree.movie.booking.app.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.movie.booking.app.dto.ResponseUserTO;
import com.mindtree.movie.booking.app.dto.UserTO;
import com.mindtree.movie.booking.app.model.User;
import com.mindtree.movie.booking.app.service.UserService;

@RestController
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);
	 
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	ResponseEntity<ResponseUserTO> addUser(@RequestBody @Valid UserTO userTo){
		
		logger.info("UserController - addUser", "Input user To ", userTo.toString());
		//return userDto;
		return new ResponseEntity<>(userService.addUser(userTo), HttpStatus.CREATED);
	}
	
	@GetMapping("/getUserDetails/{userId}")
	ResponseEntity<ResponseUserTO> getUserDetails(@PathVariable @Valid long userId ){
		
		logger.info("UserController - getUserDetails ","Input user Id", userId);
		
		return new ResponseEntity<>(userService.getUserDetails(userId), HttpStatus.OK);
	}
	
	@PutMapping("/updateUser/{userId}")
	ResponseEntity<ResponseUserTO> updateUser(@PathVariable @ Valid long userId, @RequestBody @ Valid UserTO userTo ){
		
		logger.info("UserController - updateUser ","Input user Id", userId);
		logger.info("UserController - updateUser","Input user To", userTo.toString());
		
		return new ResponseEntity<>(userService.updateUser(userId,userTo), HttpStatus.OK);
	}	
}
