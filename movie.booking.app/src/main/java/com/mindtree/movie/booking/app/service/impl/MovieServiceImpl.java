package com.mindtree.movie.booking.app.service.impl;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.movie.booking.app.dto.MovieTO;
import com.mindtree.movie.booking.app.model.Movie;
import com.mindtree.movie.booking.app.repository.MovieRepository;
import com.mindtree.movie.booking.app.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	
	private Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

	@Autowired
	private MovieRepository movieRepo;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, readOnly = false)
	public Movie addMovie(MovieTO movieTo) {
		Movie movie = Movie.build((long)0,movieTo.getTitle() , movieTo.getReleaseDate(), movieTo.getGenere(), movieTo.getDuration(), null);
		
	
		return movieRepo.save(movie);
	}
	
}
