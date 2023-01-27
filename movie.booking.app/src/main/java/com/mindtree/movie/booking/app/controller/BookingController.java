package com.mindtree.movie.booking.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.movie.booking.app.service.BookingService;

@RestController
public class BookingController {
	

	@Autowired
	private BookingService bookingService;
	

//    @GetMapping("/allMovieShows")
//    ResponseEntity<?> getAllmovieShowDetails(){
//    	return new ResponseEntity<>(bookingService.getAlShow(),HttpStatus.OK);
//    }
//    
    @PostMapping("/bookYourTickets")
    @ResponseBody
    ResponseEntity<?> bookTickets(@RequestParam @Valid Long userId, @Valid @RequestParam long screeningId, @RequestParam @Valid int ticketsQuentity ){
    	
    	
    	return new ResponseEntity<>(bookingService.bookTickets(userId,screeningId,ticketsQuentity),HttpStatus.OK);
    }
    
    
    @GetMapping("/getBookingDetails/{userId}")
    ResponseEntity<?> getBookingDetails(@PathVariable Long userId ){
    	
    	   	
    	return new ResponseEntity<>(bookingService.getBookingDetails(userId),HttpStatus.OK);
    }
    
    
}
