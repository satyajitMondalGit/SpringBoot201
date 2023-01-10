package com.mindtree.movie.booking.app.dao;

import java.util.List;

import lombok.Data;

@Data
public class CinemaHallDao {
	private long hallId;
	private String hallType;
	private List<ScreeningDao> screeningsDao;
}
