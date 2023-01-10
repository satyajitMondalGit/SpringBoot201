package com.mindtree.movie.booking.app.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "ticket_booking")
public class Booking {

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "booking_id")
	 private Long bookingId;
	
	@Column(name = "booking_date")
	 private LocalDate bookingDate;

	 @Column(name = "booking_time")
	 private LocalTime bookingTime;
	 
	 @Column(name = "tkt_qty")
	 private int ticketQty;
	 
	 @ManyToOne
	 @JsonBackReference
	 private User user;
}
