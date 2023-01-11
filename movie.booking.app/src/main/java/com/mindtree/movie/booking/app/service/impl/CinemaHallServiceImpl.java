package com.mindtree.movie.booking.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.movie.booking.app.dao.CinemaHallDao;
import com.mindtree.movie.booking.app.model.CinemaHall;
import com.mindtree.movie.booking.app.repository.CinemaHallRepositorty;
import com.mindtree.movie.booking.app.service.CinemaHallService;


@Service
public class CinemaHallServiceImpl implements CinemaHallService {

	
	
	@Autowired
	private CinemaHallRepositorty cinemaRepo;
	

	@Override
	public CinemaHallDao addCinemaHall(CinemaHallDao cinemaDao) {
		
		CinemaHall cinemaHall = new CinemaHall(cinemaDao.getHallId(),cinemaDao.getHallName(),cinemaDao.getHallType(), null);
		
		CinemaHall cinemaHall_response = cinemaRepo.save(cinemaHall); 
		
		return new CinemaHallDao(cinemaHall_response.getHallId(),cinemaHall_response.getHallName(),cinemaHall_response.getHallType());
	}


	

	


}
