package com.mindtree.movie.booking.app.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCinemaHallDTO {
	
	private long hallId;
	private String hallName;
	private String hallType;
	private List<ScreeningDTO> screeningsDTO;
}
