package com.mindtree.movie.booking.app.dto;

import java.util.List;

import com.mindtree.movie.booking.app.model.Booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestUserDTO {

	
	private long userId;
	private String userName;
	private String mobileNumber;
	private String email;
}
