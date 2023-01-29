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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.movie.booking.app.dto.ResponseScreeningTO;
import com.mindtree.movie.booking.app.dto.ScreeningTO;
import com.mindtree.movie.booking.app.exception.WrongArgumentException;
import com.mindtree.movie.booking.app.service.ScreeningService;

@RestController
public class ScreeningController {

	private Logger logger = LoggerFactory.getLogger(ScreeningController.class);
	
	@Autowired
	ScreeningService screeningService;
	
	@PostMapping("/addScrinning")	
	ResponseEntity<ResponseScreeningTO> addAScreening(@RequestBody @Valid ScreeningTO scrTo){
		
		logger.info("ScreeningController - addAScreening","scrTo", scrTo.toString());
		 
		return new ResponseEntity<>(screeningService.addScreening(scrTo), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllScreeing/{movieTitle}")
	ResponseEntity<?> getAllScreeing (@PathVariable  @Valid String movieTitle){

		logger.info("ScreeningController - getAllScreeing","movieTitle", movieTitle);
		
		return new ResponseEntity<>(screeningService.getAllScreeing(movieTitle), HttpStatus.OK);
	}
}
