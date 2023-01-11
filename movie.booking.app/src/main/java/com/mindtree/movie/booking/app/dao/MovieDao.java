package com.mindtree.movie.booking.app.dao;

import java.time.LocalDate;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDao {
	
	private Long movieId;
	private String title;
	private LocalDate releaseDate;
	private String genere;
	private String duration;

}
