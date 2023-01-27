package com.mindtree.movie.booking.app.dto;

import java.util.List;
import java.util.Set;

import com.mindtree.movie.booking.app.model.Screening;
import com.mindtree.movie.booking.app.model.Seat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseAuditoriumTO {

	private long auditoriumId;

	private String AuditoriumName;

	private String auditoriumType;

	private int seatCount;

	private List<Screening> screenings;

	private Set<Seat> seats;

}
