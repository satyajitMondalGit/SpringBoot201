package com.mindtree.movie.booking.app.dao;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CinemaHallDao {
	
	private long hallId;	
	private String hallName;
	private String hallType;
}
