package com.mindtree.movie.booking.app.service.impl;

import java.util.List;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.movie.booking.app.dto.ResponseScreeningTO;
import com.mindtree.movie.booking.app.dto.ScreeningTO;
import com.mindtree.movie.booking.app.exception.ResourceNotFoundException;
import com.mindtree.movie.booking.app.model.Auditorium;
import com.mindtree.movie.booking.app.model.Movie;
import com.mindtree.movie.booking.app.model.Screening;
import com.mindtree.movie.booking.app.repository.AuditoriumRepository;
import com.mindtree.movie.booking.app.repository.MovieRepository;
import com.mindtree.movie.booking.app.repository.ScreeningRepository;
import com.mindtree.movie.booking.app.service.ScreeningService;

@Service
public class ScreeningServiceImpl implements ScreeningService {
	
	private Logger logger = LoggerFactory.getLogger(ScreeningServiceImpl.class);

	@Autowired
	private MovieRepository movieRepo;

	@Autowired
	private AuditoriumRepository audiRepo;

	@Autowired
	private ScreeningRepository scrRepo;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, readOnly = false)
	public ResponseScreeningTO addScreening(@Valid ScreeningTO scrTo) {

		Movie movie = movieRepo.findById((long) scrTo.getMovie_id())
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "Movie Id", scrTo.getMovie_id()));

		logger.info("ScreeningServiceImpl - addScreening","movie",movie.toString());
		
		Auditorium audi = audiRepo.findById((long) scrTo.getAuditorium_id()).orElseThrow(
				() -> new ResourceNotFoundException("Auditorium", "Auditorium Id", scrTo.getAuditorium_id()));

		logger.info("ScreeningServiceImpl - addScreening","Auditorium",audi.toString());
		
		Screening scr = Screening.build((long) 0, scrTo.getDate(), scrTo.getStartTime(), scrTo.getEndTime(),
				scrTo.getPrice(), false, null, null, audi, movie);

		Screening scrUpdate = scrRepo.save(scr);
		
		logger.info("ScreeningServiceImpl - addScreening","Screening",scrUpdate.toString());
		
		return new ResponseScreeningTO(scrUpdate.getId(), scrUpdate.getDate(), scrUpdate.getStartTime(),
				scrUpdate.getEndTime(), scrUpdate.getPrice(), scrUpdate.isHouseFull(), audi, movie);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, readOnly = true)
	public Object getAllScreeing(String title) {

		Movie movie = movieRepo.findByTitle(title)
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "title", title));
		
		logger.info("ScreeningServiceImpl - getAllScreeing","Movie",movie.toString());
		
		List<Screening> scrList = scrRepo.findByMovieId(movie.getMovieId()).orElseThrow(
				() -> new ResourceNotFoundException("Screening", "Movie Id", movie.getMovieId()));
		

		logger.info("ScreeningServiceImpl - getAllScreeing","scrList",scrList);
		
		return scrList;
	}

}
