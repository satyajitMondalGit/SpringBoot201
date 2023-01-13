package com.mindtree.movie.booking.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	
	private long userId;
	private String userName;
	private String mobileNumber;
	private String email;
	
}
