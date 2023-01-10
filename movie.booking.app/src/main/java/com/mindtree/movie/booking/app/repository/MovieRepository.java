package com.mindtree.movie.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.movie.booking.app.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
