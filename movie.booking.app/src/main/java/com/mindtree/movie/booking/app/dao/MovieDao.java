package com.mindtree.movie.booking.app.dao;

import lombok.Data;

@Data
public class MovieDao {
	
	private Long movieId;
	private String title;
	private String genere;
	private String duration;
	private ScreeningDao  screeningDao;

}
