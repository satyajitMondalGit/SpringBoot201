package com.mindtree.movie.booking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.movie.booking.app.dao.RequestCinemaHallDao;
import com.mindtree.movie.booking.app.dao.ResponseCinemaHallDao;
import com.mindtree.movie.booking.app.service.ScreeningService;

@RestController
public class ScreeningController {

	@Autowired
	ScreeningService screeningService;
	
	@PostMapping("/addScrinning")	
	ResponseEntity<ResponseCinemaHallDao> addAScreening(@RequestBody RequestCinemaHallDao cinemaHallDao){
		 
		return new ResponseEntity<ResponseCinemaHallDao>(screeningService.addScreening(cinemaHallDao), HttpStatus.OK);
	}
}
