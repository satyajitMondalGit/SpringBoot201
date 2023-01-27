package com.mindtree.movie.booking.app.controller;

import javax.validation.Valid;

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

	@Autowired
	ScreeningService screeningService;
	
	@PostMapping("/addScrinning")	
	ResponseEntity<ResponseScreeningTO> addAScreening(@RequestBody @Valid ScreeningTO scrTo){
		 
		return new ResponseEntity<>(screeningService.addScreening(scrTo), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllScreeing/{movieTitle}")
	ResponseEntity<?> getAllScreeing (@PathVariable String movieTitle){
		if(movieTitle == null && "".equals(movieTitle)) {
		
			throw new WrongArgumentException(" movie title can not be blank");
		}
		
		return new ResponseEntity<>(screeningService.getAllScreeing(movieTitle), HttpStatus.OK);
	}
}
