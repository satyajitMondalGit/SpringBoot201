package com.mindtree.movie.booking.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.movie.booking.app.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

	@Query("FROM Booking b WHERE b.user.userId = :userId")
	List<Booking> findByUserId(long userId);
}
