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
import com.sun.istack.NotNull;
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
@Table(name = "ticket_booking")
public class Booking {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "booking_id")
	 private long bookingId;
	
	@JsonFormat(pattern = "yyyy-mm-dd", shape = Shape.STRING)
	@Column(name = "booking_date")
	 private String  bookingDate;

	 @JsonFormat(pattern = "HH:mm:ss", shape = Shape.STRING)
	 @Column(name = "booking_time")
	 private String  bookingTime;
	 
	 @Column(name = "tkt_qty")
	 private int ticketQty;
	 
	 @NotNull
	 @Column(name= "fk_screening_id")
	 private long screeningId;
	 
	 @NotNull
	 @Column(name= "fk_user_ID")
	 private long userId;

	 
	 
}
