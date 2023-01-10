package com.mindtree.movie.booking.app.dao;

import java.util.List;

import com.mindtree.movie.booking.app.model.Booking;

import lombok.Data;

@Data
public class UserDao {

	
	private long userId;
	private String userName;
	private String mobileNumber;
	private String email;
	private List<BookingDao> bookingsDao;
}
