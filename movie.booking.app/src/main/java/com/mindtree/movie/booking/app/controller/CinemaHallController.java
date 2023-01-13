package com.mindtree.movie.booking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.movie.booking.app.dto.CinemaHallDTO;
import com.mindtree.movie.booking.app.service.CinemaHallService;

@RestController
public class CinemaHallController {
	
	@Autowired
	private CinemaHallService cinemaService;

	@PostMapping("/addCinemaHall")
	ResponseEntity<CinemaHallDTO> addCinemaHall(@RequestBody CinemaHallDTO cinemaTo ){
		
		return new ResponseEntity<CinemaHallDTO>(cinemaService.addCinemaHall(cinemaTo),HttpStatus.OK);
	}
}
