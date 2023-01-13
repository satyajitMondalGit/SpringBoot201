package com.mindtree.movie.booking.app.service;

import com.mindtree.movie.booking.app.dto.RequestCinemaHallDTO;
import com.mindtree.movie.booking.app.dto.ResponseCinemaHallDTO;

public interface ScreeningService {

	ResponseCinemaHallDTO addScreening(RequestCinemaHallDTO cinemaHallDao);

}
