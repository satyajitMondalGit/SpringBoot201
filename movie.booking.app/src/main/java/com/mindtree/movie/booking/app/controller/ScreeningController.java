package com.mindtree.movie.booking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.movie.booking.app.dto.RequestCinemaHallDTO;
import com.mindtree.movie.booking.app.dto.ResponseCinemaHallDTO;
import com.mindtree.movie.booking.app.service.ScreeningService;

@RestController
public class ScreeningController {

	@Autowired
	ScreeningService screeningService;
	
	@PostMapping("/addScrinning")	
	ResponseEntity<ResponseCinemaHallDTO> addAScreening(@RequestBody RequestCinemaHallDTO cinemaHallDao){
		 
		return new ResponseEntity<ResponseCinemaHallDTO>(screeningService.addScreening(cinemaHallDao), HttpStatus.OK);
	}
}
