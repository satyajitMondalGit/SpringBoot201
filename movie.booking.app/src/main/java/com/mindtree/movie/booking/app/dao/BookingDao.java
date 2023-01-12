package com.mindtree.movie.booking.app.dao;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDao {
	private Long bookingId;
	private LocalDate bookingDate;
	private LocalTime bookingTime;
	private int ticketQty;
	private ScreeningDao screeningDao;
}
