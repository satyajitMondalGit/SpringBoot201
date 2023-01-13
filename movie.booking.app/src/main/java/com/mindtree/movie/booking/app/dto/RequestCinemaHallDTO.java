package com.mindtree.movie.booking.app.dto;

import java.util.List;

import lombok.Data;

@Data
public class RequestCinemaHallDTO {
	private Long hallId;
	private Long movieId;
	private List<RequestScreeningDTO> RequestScreeningDTO;
}
