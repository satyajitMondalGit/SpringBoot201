package com.mindtree.movie.booking.app.service;

import com.mindtree.movie.booking.app.dao.RequestCinemaHallDao;
import com.mindtree.movie.booking.app.dao.ResponseCinemaHallDao;

public interface ScreeningService {

	ResponseCinemaHallDao addScreening(RequestCinemaHallDao cinemaHallDao);

}
