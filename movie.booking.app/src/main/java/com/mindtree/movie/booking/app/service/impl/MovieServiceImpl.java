package com.mindtree.movie.booking.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.movie.booking.app.dao.MovieDao;
import com.mindtree.movie.booking.app.model.Movie;
import com.mindtree.movie.booking.app.repository.MovieRepository;
import com.mindtree.movie.booking.app.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepo;
	
	@Override
	public MovieDao addMovie(MovieDao movieDao) {
		
		Movie movie = new Movie();
	
		movie.setTitle(movieDao.getTitle());
		movie.setGenere(movieDao.getGenere());
		movie.setDuration(movieDao.getDuration());
		Movie movie1 = movieRepo.save(movie);
		
		movieDao.setMovieId(movie1.getMovieId());
		movieDao.setTitle(movie1.getTitle());
		movieDao.setGenere(movie1.getGenere());
		movieDao.setDuration(movie1.getDuration());
		
		return movieDao;
	}

}
