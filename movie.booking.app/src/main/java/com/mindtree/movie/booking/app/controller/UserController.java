package com.mindtree.movie.booking.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.movie.booking.app.dto.UserTO;
import com.mindtree.movie.booking.app.model.User;
import com.mindtree.movie.booking.app.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	ResponseEntity<User> addUser(@RequestBody @Valid UserTO userTo){
		
		//return userDto;
		return new ResponseEntity<>(userService.addUser(userTo), HttpStatus.CREATED);
	}
	
	@GetMapping("/getUserDetails/{userId}")
	ResponseEntity<User> getUserDetails(@PathVariable @Valid long userId ){
		
		
		
		return new ResponseEntity<>(userService.getUserDetails(userId), HttpStatus.OK);
	}
	
	@PutMapping("/updateUser/{userId}")
	ResponseEntity<User> updateUser(@PathVariable @ Valid long userId, @RequestBody @ Valid UserTO userTo ){
		
		return new ResponseEntity<>(userService.updateUser(userId,userTo), HttpStatus.OK);
	}	
}
