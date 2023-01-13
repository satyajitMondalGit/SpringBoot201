package com.mindtree.movie.booking.app.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class User {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name  = "user_id")
	private long userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "mobile")
	private String mobileNumber;
	
	@Column(name="email")
	private String email;
	

}
