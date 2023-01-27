package com.mindtree.movie.booking.app.service;

import javax.validation.Valid;

import com.mindtree.movie.booking.app.dto.ResponseScreeningTO;
import com.mindtree.movie.booking.app.dto.ScreeningTO;

public interface ScreeningService {

	ResponseScreeningTO addScreening(@Valid ScreeningTO scrTo);

	Object getAllScreeing(String title);
	
}
