package com.mindtree.movie.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.movie.booking.app.model.Auditorium;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {

}
