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
public class AuditoriumTO {

	
	@NotBlank(message = "AuditoriumName cannot be null or empty")
	private String AuditoriumName;
	
	@Pattern(regexp = "INOX|PVR", message = "auditoriumType can only INOX or PVR" )
	private String auditoriumType;
	
	@NotNull
	private int seatCount;
}
