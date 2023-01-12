package com.mindtree.movie.booking.app.dao;

import java.time.LocalDate;
import java.time.LocalTime;

import com.mindtree.movie.booking.app.model.Movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScreeningDao {

	
	private Long id;
	private LocalDate date;
	private LocalTime startTime;
	private LocalTime endTime;
	private Double price;
	private MovieDao movieDao;
}
