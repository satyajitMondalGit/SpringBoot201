package com.mindtree.movie.booking.app.service;

import com.mindtree.movie.booking.app.dao.ResponseCinemaHallDao;
import com.mindtree.movie.booking.app.dao.UserDao;

public interface BookingService {

	ResponseCinemaHallDao getAlShow();

	UserDao bookTickets(Long userId, long screeningId, int ticketsQuentity);

	UserDao getEarlierTicketsDetails(long userId);

}
