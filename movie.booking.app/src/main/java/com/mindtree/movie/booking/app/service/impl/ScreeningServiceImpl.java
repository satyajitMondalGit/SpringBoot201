package com.mindtree.movie.booking.app.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.movie.booking.app.dto.MovieDTO;
import com.mindtree.movie.booking.app.dto.RequestCinemaHallDTO;
import com.mindtree.movie.booking.app.dto.RequestScreeningDTO;
import com.mindtree.movie.booking.app.dto.ResponseCinemaHallDTO;
import com.mindtree.movie.booking.app.dto.ScreeningDTO;
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
	public ResponseCinemaHallDTO addScreening(RequestCinemaHallDTO cinemaHallDTO) {
		
		long cinemaHallId = cinemaHallDTO.getHallId();
		long movieId = cinemaHallDTO.getMovieId();
		List<RequestScreeningDTO > screeningDaoList = cinemaHallDTO.getRequestScreeningDTO(); 
		
		CinemaHall cinemaHall = cinemaRepo.findById(cinemaHallId)
				.orElseThrow(()->new ResourceNotFoundException("CinemaHall","hallId",cinemaHallId));
		Movie movie = movieRepo.findById(movieId)
				.orElseThrow(()->new ResourceNotFoundException("Movie","movieId",movieId));
		MovieDTO movieDTO = new MovieDTO(movie.getMovieId(),movie.getTitle(),movie.getReleaseDate(),movie.getGenere(),movie.getDuration());
		List<ScreeningDTO> list_Screeings = new ArrayList<ScreeningDTO>();
		for(RequestScreeningDTO req_ScrDto : screeningDaoList) {
			
			Screening screening = new Screening((long) 0,req_ScrDto.getDate(),req_ScrDto.getStartTime(),req_ScrDto.getEndTime(),req_ScrDto.getPrice(),cinemaHall,movie);
			
			Screening screening_updated = screeningRepo.save(screening);
			
			ScreeningDTO scrnningDao = new ScreeningDTO(screening_updated.getId(), screening_updated.getDate(), screening_updated.getStartTime(),screening_updated.getEndTime(),screening_updated.getPrice(),movieDTO);
			list_Screeings.add(scrnningDao);
			}	
		
		return new ResponseCinemaHallDTO(cinemaHall.getHallId(),cinemaHall.getHallName(),cinemaHall.getHallType(),list_Screeings);
	}

}
