package com.mindtree.movie.booking.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.movie.booking.app.dto.BookingDTO;
import com.mindtree.movie.booking.app.dto.ResponseBookingDTO;
import com.mindtree.movie.booking.app.dto.ResponseCinemaHallDTO;
import com.mindtree.movie.booking.app.dto.UserDTO;
import com.mindtree.movie.booking.app.service.BookingService;

@RestController
public class BookingController {
	

	@Autowired
	private BookingService bookingService;
	

    @GetMapping("/allMovieShows")
    ResponseEntity<List<ResponseCinemaHallDTO>> getAllmovieShowDetails(){
    	return new ResponseEntity<List<ResponseCinemaHallDTO>>(bookingService.getAlShow(),HttpStatus.OK);
    }
    
    @PostMapping("/bookYourTickets")
    @ResponseBody
    ResponseEntity<ResponseBookingDTO> bookTickets(@RequestParam Long userId, @RequestParam long screeningId, @RequestParam int ticketsQuentity ){
    	
    	
    	return new ResponseEntity<ResponseBookingDTO>(bookingService.bookTickets(userId,screeningId,ticketsQuentity),HttpStatus.OK);
    }
    
    
    @GetMapping("/yourTicketDetails/{userId}")
    ResponseEntity<List<BookingDTO>> getEarlierTicketsDetails(@PathVariable Long userId ){
    	
    	   	
    	return new ResponseEntity<List<BookingDTO>>(bookingService.getEarlierTicketsDetails(userId),HttpStatus.OK);
    }
    
    
}
