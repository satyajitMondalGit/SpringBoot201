package com.mindtree.movie.booking.app.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.movie.booking.app.dto.MovieTO;
import com.mindtree.movie.booking.app.model.Movie;
import com.mindtree.movie.booking.app.service.MovieService;

@RestController
public class MovieController {

	private Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService movieService;
	
	@PostMapping("/addMovie")
	ResponseEntity<Movie> addMovie(@RequestBody @Valid MovieTO movieTo){
		
		logger.info("MovieController - addMovie ", "movieTo", movieTo.toString() );
		
		return new ResponseEntity<>(movieService.addMovie(movieTo), HttpStatus.CREATED);
	}
}
