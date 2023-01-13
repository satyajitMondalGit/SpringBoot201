package com.mindtree.movie.booking.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.mindtree.movie.booking.app.model.Movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScreeningDTO {

	
	private Long id;
	private String date;
	private String startTime;
	private String endTime;
	private Double price;
	private MovieDTO movieDTO;
}
