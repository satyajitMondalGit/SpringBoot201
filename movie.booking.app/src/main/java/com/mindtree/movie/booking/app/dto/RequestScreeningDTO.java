package com.mindtree.movie.booking.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;


@Data
public class RequestScreeningDTO {

	
	private Long id;
	private String date;
	private String startTime;
	private String endTime;
	private Double price;
}
