package com.mindtree.movie.booking.app.service;

import java.util.List;

import com.mindtree.movie.booking.app.dto.BookingDTO;
import com.mindtree.movie.booking.app.dto.ResponseBookingDTO;
import com.mindtree.movie.booking.app.dto.ResponseCinemaHallDTO;
import com.mindtree.movie.booking.app.dto.UserDTO;
import com.mindtree.movie.booking.app.model.CinemaHall;

public interface BookingService {

	List<ResponseCinemaHallDTO> getAlShow();

	ResponseBookingDTO bookTickets(Long userId, long screeningId, int ticketsQuentity);

	List<BookingDTO> getEarlierTicketsDetails(long userId);

}
