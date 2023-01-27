package com.mindtree.movie.booking.app.service;

import javax.validation.Valid;

public interface BookingService {

	Object bookTickets(@Valid Long userId, @Valid long screeningId, @Valid int ticketsQuentity);

	Object getBookingDetails(Long userId);
	
}
