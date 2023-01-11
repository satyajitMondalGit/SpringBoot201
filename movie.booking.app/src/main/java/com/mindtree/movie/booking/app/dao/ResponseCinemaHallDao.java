package com.mindtree.movie.booking.app.dao;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCinemaHallDao {
	
	private long hallId;
	private String hallName;
	private String hallType;
	private List<ScreeningDao> screeningsDao;
}
