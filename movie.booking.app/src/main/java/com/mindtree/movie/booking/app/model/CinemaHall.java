package com.mindtree.movie.booking.app.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name = "cinema_hall")
public class CinemaHall {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hall_id")
	private long hallId;
	
	@Column(name = "hall_type")
	private String hallType;
	
	@OneToMany(mappedBy = "cinemaHall", cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_hall_id", referencedColumnName = "hall_id" )
	@JsonManagedReference
	private List<Screening> screenings;
	
	
}
