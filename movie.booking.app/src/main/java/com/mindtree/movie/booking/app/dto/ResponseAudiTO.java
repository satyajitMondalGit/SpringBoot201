package com.mindtree.movie.booking.app.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseAudiTO {

	private long auditoriumId;

	private String AuditoriumName;

	private String auditoriumType;

	private int seatCount;
}
