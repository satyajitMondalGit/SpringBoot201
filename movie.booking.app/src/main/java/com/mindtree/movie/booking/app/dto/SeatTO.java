package com.mindtree.movie.booking.app.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SeatTO {

private long seatId;
	

	private int seatNo;
	
	private String possition;
}
