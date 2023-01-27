package com.mindtree.movie.booking.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.movie.booking.app.dto.MovieTO;
import com.mindtree.movie.booking.app.model.Movie;
import com.mindtree.movie.booking.app.repository.MovieRepository;
import com.mindtree.movie.booking.app.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepo;
	
	@Override
	public Movie addMovie(MovieTO movieTo) {
		Movie movie = Movie.build((long)0,movieTo.getTitle() , movieTo.getReleaseDate(), movieTo.getGenere(), movieTo.getDuration(), null);
		return movieRepo.save(movie);
	}
	
}
