package com.mindtree.movie.booking.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.movie.booking.app.dto.CinemaHallDTO;
import com.mindtree.movie.booking.app.model.CinemaHall;
import com.mindtree.movie.booking.app.repository.CinemaHallRepositorty;
import com.mindtree.movie.booking.app.service.CinemaHallService;


@Service
public class CinemaHallServiceImpl implements CinemaHallService {

	
	
	@Autowired
	private CinemaHallRepositorty cinemaRepo;
	

	@Override
	public CinemaHallDTO addCinemaHall(CinemaHallDTO cinemaDao) {
		
		CinemaHall cinemaHall = new CinemaHall(0,cinemaDao.getHallName(),cinemaDao.getHallType(), null);
		
		CinemaHall cinemaHall_response = cinemaRepo.save(cinemaHall); 
		
		return new CinemaHallDTO(cinemaHall_response.getHallId(),cinemaHall_response.getHallName(),cinemaHall_response.getHallType());
	}


	

	


}
