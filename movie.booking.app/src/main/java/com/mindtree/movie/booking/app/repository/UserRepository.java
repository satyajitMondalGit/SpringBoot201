package com.mindtree.movie.booking.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.movie.booking.app.dto.ResponseUserTO;
import com.mindtree.movie.booking.app.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
