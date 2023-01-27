package com.mindtree.movie.booking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.movie.booking.app.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {

	@Query("from Seat s where s.auditorium.auditoriumId = :id")
	List<Seat> findByAuditoriamId(long id);
}
