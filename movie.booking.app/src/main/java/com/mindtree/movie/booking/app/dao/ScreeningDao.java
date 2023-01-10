package com.mindtree.movie.booking.app.dao;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;


@Data
public class ScreeningDao {

	
	private Long id;
	private LocalDate date;
	private LocalTime startTime;
	private LocalTime endTime;
	private Double price;
	private CinemaHallDao cinemaHallDao;
	private MovieDao movieDao;
}
