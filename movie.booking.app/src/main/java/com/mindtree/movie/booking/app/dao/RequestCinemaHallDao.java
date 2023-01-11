package com.mindtree.movie.booking.app.dao;

import java.util.List;

import lombok.Data;

@Data
public class RequestCinemaHallDao {
	private Long hallId;
	private Long movieId;
	private List<RequestScreeningDao> RequestScreeningDao;
}
