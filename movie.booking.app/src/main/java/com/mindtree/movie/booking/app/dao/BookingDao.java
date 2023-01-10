package com.mindtree.movie.booking.app.dao;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;


@Data
public class BookingDao {
	private Long bookingId;
	private LocalDate bookingDate;
	private LocalTime bookingTime;
	private int ticketQty;
	private UserDao userDao;
}
