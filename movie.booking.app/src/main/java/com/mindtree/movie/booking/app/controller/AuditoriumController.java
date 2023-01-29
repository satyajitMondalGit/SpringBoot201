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

import com.mindtree.movie.booking.app.dto.AuditoriumTO;
import com.mindtree.movie.booking.app.dto.ResponseAuditoriumTO;
import com.mindtree.movie.booking.app.service.AuditoriumService;

@RestController
public class AuditoriumController {

	private Logger logger = LoggerFactory.getLogger(AuditoriumController.class);
	 
	@Autowired
	private AuditoriumService auditoriumService;

	@PostMapping("/addNewAuditorium")
	ResponseEntity<ResponseAuditoriumTO> addNewAuditorium(@RequestBody @Valid AuditoriumTO auditoriumTo ){
		
		logger.info("AuditoriumController - addNewAuditorium ","input auditoriumTo ", auditoriumTo.toString());
		
		return new ResponseEntity<ResponseAuditoriumTO>(auditoriumService
				.addNewAuditorium(auditoriumTo), HttpStatus.CREATED);
	}
}
