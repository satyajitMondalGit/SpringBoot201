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
	
	 @JsonIgnore
	 @OneToMany(mappedBy = "booking")
//	 @JsonManagedReference
	 private Set<SeatReserved> seatReserved;
	 
	
	 @ManyToOne
	 @JoinColumn(name="user_id", nullable=false)
	 @JsonBackReference
	 private User user;

//	 @JsonIgnore
	 @ManyToOne
	 @JoinColumn(name="screening_id", nullable=false)
	 @JsonBackReference
	 private Screening screening;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return bookingId==other.getBookingId() && bookingDate.equals(other.getBookingDate()) &&  bookingTime.equals(other.getBookingTime()) && ticketQty == other.getTicketQty();
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingDate, bookingId, bookingTime,  ticketQty);
	}
	 
	 
	 
}
