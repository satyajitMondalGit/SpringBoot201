package com.mindtree.movie.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.movie.booking.app.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
