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
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "screening")
public class Screening implements Comparable<Screening> {

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

	@Column(name = "is_house_full")
	private boolean isHouseFull;

	@JsonIgnore
	@OneToMany(mappedBy = "screening")
	private Set<SeatReserved> seatReserved;

	@JsonIgnore
	@OneToMany(mappedBy = "screening")
	private Set<Booking> bookings;

	@ManyToOne
	@JoinColumn(name = "auditorium_id", nullable = false)
	@JsonBackReference
	private Auditorium auditorium;

	@ManyToOne
	@JoinColumn(name = "movie_id", nullable = false)
	@JsonBackReference
	private Movie movie;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Screening other = (Screening) obj;
		return id == other.getId() && date.equals(other.getDate()) && startTime.equals(other.getStartTime());
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, endTime, id, isHouseFull, price, startTime);
	}

	@Override
	public int compareTo(Screening o) {

		return Comparator.comparingLong(Screening::getId).thenComparing(Screening::getDate)
				.thenComparing(Screening::getStartTime).thenComparing(Screening::getEndTime)
				.thenComparingDouble(Screening::getPrice).compare(this, o);
	}

}
