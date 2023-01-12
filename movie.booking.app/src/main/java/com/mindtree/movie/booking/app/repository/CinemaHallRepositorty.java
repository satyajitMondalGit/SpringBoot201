package com.mindtree.movie.booking.app.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.movie.booking.app.model.CinemaHall;

public interface CinemaHallRepositorty extends JpaRepository<CinemaHall, Long>{
	
	@Query(value = "select * from CinemaHall C where Screening S  S.Date >= D")
	Optional<CinemaHall> getAllShow(LocalDate D);

}
