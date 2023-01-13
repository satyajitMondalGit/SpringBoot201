package com.mindtree.movie.booking.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.movie.booking.app.model.Screening;

public interface ScreeningRepository extends JpaRepository<Screening, Long>{
	
	List<Screening> findByDateAfter(String string);

	

}
