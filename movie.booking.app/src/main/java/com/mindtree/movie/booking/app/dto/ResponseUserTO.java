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
public class ResponseUserTO {

	private long userId;

	private String userName;

	private String mobileNumber;

	private String email;

}
