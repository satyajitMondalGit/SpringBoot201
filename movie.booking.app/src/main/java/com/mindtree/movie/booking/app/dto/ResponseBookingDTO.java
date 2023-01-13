package com.mindtree.movie.booking.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBookingDTO {
	private long bookingId;
	private String  bookingDate;
	private String  bookingTime;
	private int ticketQty;
	private UserDTO UserDTO;
	private ScreeningDTO screeningDto;

}
