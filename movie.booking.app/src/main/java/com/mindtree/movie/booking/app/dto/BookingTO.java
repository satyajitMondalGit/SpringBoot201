package com.mindtree.movie.booking.app.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@ToString
public class BookingTO {

private long bookingId;

	 private String  bookingDate;

	 private String  bookingTime;

	 private int ticketQty;
	 
	 private long screeningId;
	 
	 private long AuditoriumId;
	 
	 List<SeatTO> setTo;
}
