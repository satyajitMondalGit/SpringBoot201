package com.mindtree.movie.booking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mindtree.movie.booking.app.dto.MovieDTO;
import com.mindtree.movie.booking.app.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@PostMapping("/addMovie")
	ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movieDTO){
		
		
		return new ResponseEntity<MovieDTO>(movieService.addMovie(movieDTO), HttpStatus.OK);
	}
}
