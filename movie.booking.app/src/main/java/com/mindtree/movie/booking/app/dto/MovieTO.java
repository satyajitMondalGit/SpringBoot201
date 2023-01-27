package com.mindtree.movie.booking.app.dto;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieTO {


	@NotBlank(message = "Movie Title cannot be null or empty")
	 private String title;
	 

	 @Pattern( message = "Date formate should be yyyy-mm-dd", regexp = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")
	 private String releaseDate;

	 private String genere;
	 

	 private String duration; 
	 
}
