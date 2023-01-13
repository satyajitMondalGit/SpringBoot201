package com.mindtree.movie.booking.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
	
	private Long movieId;
	private String title;
	private String releaseDate;
	private String genere;
	private String duration;

}
