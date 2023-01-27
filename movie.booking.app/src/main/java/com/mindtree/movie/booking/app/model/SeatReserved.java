package com.mindtree.movie.booking.app.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@ToString
@Entity
@Table(name  = "seat_booking")
public class SeatReserved {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seat_reserved_id")
	private long reserviedId;
	
	@ManyToOne
	@JoinColumn(name = "seat_id", nullable=false)
	private Seat seat;
	
	@ManyToOne
	@JoinColumn(name = "booking_id", nullable=false)
	@JsonBackReference
	private Booking booking;
	 
	
	@ManyToOne
	@JoinColumn(name = "screening_id", nullable=false)
	@JsonBackReference
	private Screening screening;


	@Override
	public int hashCode() {
		return Objects.hash(booking, reserviedId, screening, seat);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeatReserved other = (SeatReserved) obj;
		return  reserviedId == other.getReserviedId();
	}


	


}
