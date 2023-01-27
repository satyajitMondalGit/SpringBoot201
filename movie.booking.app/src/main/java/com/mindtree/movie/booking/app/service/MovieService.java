package com.mindtree.movie.booking.app.service;

import com.mindtree.movie.booking.app.dto.MovieTO;
import com.mindtree.movie.booking.app.model.Movie;

public interface MovieService {

	Movie addMovie(MovieTO movieTo);
	
}
