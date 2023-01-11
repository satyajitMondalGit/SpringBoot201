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
@Table(name = "screening")
public class Screening {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "screening_id")
	 private Long id;
	 
	 @Column(name = "screening_date")
	 private LocalDate date;

	 @Column(name = "start_time")
	 private LocalTime startTime;

	 @Column(name = "end_time")
	 private LocalTime endTime;

	 @Column(name = "price")
	 private Double price;
	 
	 @ManyToOne
	 @JsonBackReference
	 private CinemaHall cinemaHall;
	 
	 @ManyToOne
	 @JsonManagedReference
	 private Movie movie;

	

}
