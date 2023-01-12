package com.mindtree.movie.booking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.movie.booking.app.dao.ResponseCinemaHallDao;
import com.mindtree.movie.booking.app.dao.UserDao;
import com.mindtree.movie.booking.app.service.BookingService;

@RestController
public class BookingController {
	

	@Autowired
	private BookingService bookingService;
	

    @GetMapping("/allMovieShows")
    ResponseEntity<ResponseCinemaHallDao> getAllmovieShowDetails(){
    	return new ResponseEntity<ResponseCinemaHallDao>(bookingService.getAlShow(),HttpStatus.OK);
    }
    @PostMapping("/bookTickets")
    @ResponseBody
    ResponseEntity<UserDao> bookTickets(@RequestParam Long userId, @RequestParam long screeningId, @RequestParam int ticketsQuentity ){
    	
    	
    	return new ResponseEntity<UserDao>(bookingService.bookTickets(userId,screeningId,ticketsQuentity),HttpStatus.OK);
    }
    
    
    @GetMapping("/bookiedTicketDetails/(userId)")
    ResponseEntity<UserDao> getEarlierTicketsDetails(@PathVariable long userId ){
    	
    	   	
    	return new ResponseEntity<UserDao>(bookingService.getEarlierTicketsDetails(userId),HttpStatus.OK);
    }
    
    
}
