package com.mindtree.movie.booking.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.movie.booking.app.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

	@Query("SELECT b FROM Booking b WHERE b.userId = ?1")
	Optional<List<Booking>> findByUserId(long userId);
}
