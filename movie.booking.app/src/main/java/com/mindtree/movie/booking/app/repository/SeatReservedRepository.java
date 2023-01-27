package com.mindtree.movie.booking.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.movie.booking.app.model.SeatReserved;

public interface SeatReservedRepository extends JpaRepository<SeatReserved, Long> {

	@Query("from SeatReserved s where s.screening.id = :scrId")
	Optional<List<SeatReserved>> findByScreeingId(Long scrId);  
	
}
