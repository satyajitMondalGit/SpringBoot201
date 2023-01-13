package com.mindtree.movie.booking.app.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "screening")
public class Screening {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "screening_id")
	 private Long id;
	 
	 @JsonFormat(pattern = "yyyy-mm-dd", shape = Shape.STRING)
	 @Column(name = "screening_date")
	 private String date;

	
	 @JsonFormat(pattern = "HH:mm:ss", shape = Shape.STRING)
	 @Column(name = "start_time")
	 private String startTime;

	
	 @JsonFormat(pattern = "HH:mm:ss", shape = Shape.STRING)
	 @Column(name = "end_time")
	 private String endTime;

	 @Column(name = "price")
	 private Double price;
	 
	 @ManyToOne
	 @JsonBackReference
	 private CinemaHall cinemaHall;
	 
	 @ManyToOne
	 @JsonManagedReference
	 private Movie movie;

	

}
