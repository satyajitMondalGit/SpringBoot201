package com.mindtree.movie.booking.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.movie.booking.app.model.Screening;

public interface ScreeningRepository extends JpaRepository<Screening, Long>{
	
	@Query("from Screening s where s.movie.movieId = :movieId")
	Optional<List<Screening>> findByMovieId(long movieId);

	

}
