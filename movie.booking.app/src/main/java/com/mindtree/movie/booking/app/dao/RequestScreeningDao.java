package com.mindtree.movie.booking.app.dao;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;


@Data
public class RequestScreeningDao {

	
	private Long id;
	private LocalDate date;
	private LocalTime startTime;
	private LocalTime endTime;
	private Double price;
}
