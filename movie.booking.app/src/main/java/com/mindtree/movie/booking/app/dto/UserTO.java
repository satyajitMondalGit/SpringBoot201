package com.mindtree.movie.booking.app.dto;

import java.util.Set;

import javax.persistence.Column;

import javax.validation.constraints.*;

import com.mindtree.movie.booking.app.model.Booking;
import com.mindtree.movie.booking.app.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserTO {

	@NotBlank(message = "username cannot be null or empty")
	private String userName;
	
	@Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered ")
	private String mobileNumber;
	
	@Email(message = "invalide email address")
	private String email;
	
	
}
