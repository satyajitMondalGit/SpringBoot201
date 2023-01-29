package com.mindtree.movie.booking.app.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.mindtree.movie.booking.app.model.Auditorium;
import com.mindtree.movie.booking.app.model.Booking;
import com.mindtree.movie.booking.app.model.Movie;
import com.mindtree.movie.booking.app.model.SeatReserved;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseScreeningTO {

	private Long id;

	private String date;

	private String startTime;

	private String endTime;

	private Double price;

	private boolean isHouseFull;

	private ResponseAudiTO auditorium;

	private String movieTitle;

}
