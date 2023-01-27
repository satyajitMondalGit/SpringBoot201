package com.mindtree.movie.booking.app.service;

import javax.validation.Valid;

import com.mindtree.movie.booking.app.dto.AuditoriumTO;
import com.mindtree.movie.booking.app.dto.ResponseAuditoriumTO;
import com.mindtree.movie.booking.app.model.Auditorium;

public interface AuditoriumService {

	ResponseAuditoriumTO addNewAuditorium(@Valid AuditoriumTO auditoriumTo);

	

}
