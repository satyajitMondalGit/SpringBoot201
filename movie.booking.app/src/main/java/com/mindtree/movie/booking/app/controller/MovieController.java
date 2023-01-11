package com.mindtree.movie.booking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.movie.booking.app.dao.MovieDao;
import com.mindtree.movie.booking.app.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@PostMapping("/addMovie")
	ResponseEntity<MovieDao> addMovie(@RequestBody MovieDao movieDao){
		
		return new ResponseEntity<MovieDao>(movieService.addMovie(movieDao), HttpStatus.OK);
	}
}
