package com.mindtree.movie.booking.app.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScreeningTO {

	@Pattern( message = "Date formate should be Like yyyy-mm-dd", regexp = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")
	private String date;

	
	@Pattern( message = "Time formate should be Like HH:mm:ss ", regexp = "^([01][0-9]|2[0-3])\\:([0-5][0-9])\\:([0-5][0-9])$")
	private String startTime;

	@Pattern( message = "Time formate should be Like HH:mm:ss ", regexp = "^([01][0-9]|2[0-3])\\:([0-5][0-9])\\:([0-5][0-9])$")
	private String endTime;

	private Double price;


	private boolean isHouseFull;
	
	@NotNull
	private long auditorium_id;
	
	@NotNull
	private long movie_id;}
