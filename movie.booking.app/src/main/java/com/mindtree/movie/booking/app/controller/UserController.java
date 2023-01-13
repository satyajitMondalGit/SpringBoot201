package com.mindtree.movie.booking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.movie.booking.app.dto.UserDTO;
import com.mindtree.movie.booking.app.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDto){
		
		//return userDto;
		return new ResponseEntity<UserDTO>(userService.addUser(userDto), HttpStatus.OK);
	}
	
	@GetMapping("/getUserDetails/{userId}")
	ResponseEntity<UserDTO> getUserDetails(@PathVariable long userId ){
		
		return new ResponseEntity<UserDTO>(userService.getUserDetails(userId), HttpStatus.OK);
	}
	
	@PutMapping("/updateUser/{userId}")
	ResponseEntity<UserDTO> updateUser(@PathVariable long userId, @RequestBody UserDTO userDto ){
		
		return new ResponseEntity<UserDTO>(userService.updateUser(userId,userDto), HttpStatus.OK);
	}	
}
