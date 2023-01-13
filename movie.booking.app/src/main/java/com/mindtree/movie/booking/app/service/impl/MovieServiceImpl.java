package com.mindtree.movie.booking.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.movie.booking.app.dto.MovieDTO;
import com.mindtree.movie.booking.app.model.Movie;
import com.mindtree.movie.booking.app.repository.MovieRepository;
import com.mindtree.movie.booking.app.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepo;
	
	@Override
	public MovieDTO addMovie(MovieDTO movieDTO) {
		
		Movie movie = new Movie();
	
		movie.setTitle(movieDTO.getTitle());
		movie.setGenere(movieDTO.getGenere());
		movie.setDuration(movieDTO.getDuration());
		movie.setReleaseDate(movieDTO.getReleaseDate());
		Movie movie1 = movieRepo.save(movie);
		
	
		
		return new MovieDTO(movie1.getMovieId(),movie1.getTitle(),movie.getReleaseDate(),movie1.getDuration(),movie1.getGenere());
	}

}
