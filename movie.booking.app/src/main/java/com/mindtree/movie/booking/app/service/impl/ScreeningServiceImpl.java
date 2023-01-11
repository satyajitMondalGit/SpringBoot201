package com.mindtree.movie.booking.app.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.movie.booking.app.dao.MovieDao;
import com.mindtree.movie.booking.app.dao.RequestCinemaHallDao;
import com.mindtree.movie.booking.app.dao.RequestScreeningDao;
import com.mindtree.movie.booking.app.dao.ResponseCinemaHallDao;
import com.mindtree.movie.booking.app.dao.ScreeningDao;
import com.mindtree.movie.booking.app.exception.ResourceNotFoundException;
import com.mindtree.movie.booking.app.model.CinemaHall;
import com.mindtree.movie.booking.app.model.Movie;
import com.mindtree.movie.booking.app.model.Screening;
import com.mindtree.movie.booking.app.repository.CinemaHallRepositorty;
import com.mindtree.movie.booking.app.repository.MovieRepository;
import com.mindtree.movie.booking.app.repository.ScreeningRepository;
import com.mindtree.movie.booking.app.service.ScreeningService;

@Service
public class ScreeningServiceImpl implements ScreeningService {
	@Autowired
	private MovieRepository movieRepo;
	
	@Autowired
	private CinemaHallRepositorty cinemaRepo;
	
	@Autowired
	private ScreeningRepository screeningRepo;

	@Override
	public ResponseCinemaHallDao addScreening(RequestCinemaHallDao cinemaHallDao) {
		
		long cinemaHallId = cinemaHallDao.getHallId();
		long movieId = cinemaHallDao.getMovieId();
		List<RequestScreeningDao > screeningDaoList = cinemaHallDao.getRequestScreeningDao(); 
		
		CinemaHall cinemaHall = cinemaRepo.findById(cinemaHallId)
				.orElseThrow(()->new ResourceNotFoundException("CinemaHall","hallId",cinemaHallId));
		Movie movie = movieRepo.findById(movieId)
				.orElseThrow(()->new ResourceNotFoundException("Movie","movieId",movieId));
		MovieDao movieDao = new MovieDao(movie.getMovieId(),movie.getTitle(),movie.getReleaseDate(),movie.getGenere(),movie.getDuration());
		List<ScreeningDao> list_Screeings = new ArrayList<ScreeningDao>();
		for(RequestScreeningDao req_ScrDao : screeningDaoList) {
			
			Screening screening = new Screening(req_ScrDao.getId(),req_ScrDao.getDate(),req_ScrDao.getStartTime(),req_ScrDao.getEndTime(),req_ScrDao.getPrice(),cinemaHall,movie);
			
			Screening screening_updated = screeningRepo.save(screening);
			
			ScreeningDao scrnningDao = new ScreeningDao(screening_updated.getId(), screening_updated.getDate(), screening_updated.getStartTime(),screening_updated.getEndTime(),screening_updated.getPrice(),movieDao);
			list_Screeings.add(scrnningDao);
			}	
		
		return new ResponseCinemaHallDao(cinemaHall.getHallId(),cinemaHall.getHallName(),cinemaHall.getHallType(),list_Screeings);
	}

}
