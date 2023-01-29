package com.mindtree.movie.booking.app.model;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@ToString
@Entity
@Table(name = "seat")
public class Seat implements Comparable<Seat> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seat_id")
	private long seatId;

	@Column(name = "seat_no")
	private int seatNo;

	@Column(name = "possition")
	private String possition;

	@OneToMany(mappedBy = "seat")
	@JsonManagedReference
	private Set<SeatReserved> seatReserved;;

	@ManyToOne
	@JoinColumn(name = "auditorium_id", nullable = false)
	@JsonBackReference
	private Auditorium auditorium;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seat other = (Seat) obj;
		return seatId == other.getSeatId() && seatNo == other.getSeatNo();
	}

	@Override
	public int hashCode() {
		return Objects.hash(possition, seatId, seatNo);
	}

	@Override
	public int compareTo(Seat o) {

		return Comparator.comparingLong(Seat::getSeatId).thenComparingInt(Seat::getSeatNo)
				.thenComparing(Seat::getPossition).compare(this, o);
	}

}
