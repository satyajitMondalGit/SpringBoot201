package com.mindtree.movie.booking.app.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CinemaHallDTO {
	
	private long hallId;	
	private String hallName;
	private String hallType;
}
