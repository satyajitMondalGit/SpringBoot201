package com.mindtree.movie.booking.app.model;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name = "auditorium")
public class Auditorium implements Comparable<Auditorium> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auditorium_id")
	private long auditoriumId;
	
	@Column(name = "auditorium_name")
	private String AuditoriumName;
	
	
	@Column(name = "auditorium_type")
	private String auditoriumType;
	
	@Column(name = "seat_count")
	private int seatCount;
	
	@OneToMany(mappedBy = "auditorium")
	@JsonManagedReference
	private List<Screening> screenings;
	
	
	@OneToMany(mappedBy = "auditorium")
	@JsonManagedReference
	private Set<Seat> seats;


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auditorium other = (Auditorium) obj;
		return auditoriumId ==  other.getAuditoriumId() &&  AuditoriumName.equals(other.getAuditoriumName()) && auditoriumType.equals(other.getAuditoriumType());
	}


	@Override
	public int hashCode() {
		return Objects.hash( AuditoriumName, auditoriumId, auditoriumType);
	}


	@Override
	public int compareTo(Auditorium o) {
		
		return Comparator.comparingLong(Auditorium::getAuditoriumId)
				.thenComparing(Auditorium::getAuditoriumName)
				.thenComparing(Auditorium::getAuditoriumType).compare(this, o);
	}
	
	
	
}
