package com.mindtree.movie.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.movie.booking.app.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

}
