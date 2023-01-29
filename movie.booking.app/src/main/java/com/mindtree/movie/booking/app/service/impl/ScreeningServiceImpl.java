package com.mindtree.movie.booking.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.movie.booking.app.dto.ResponseAudiTO;
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

		logger.info("ScreeningServiceImpl - addScreening","movie",movie.getTitle());
		
		Auditorium audi = audiRepo.findById((long) scrTo.getAuditorium_id()).orElseThrow(
				() -> new ResourceNotFoundException("Auditorium", "Auditorium Id", scrTo.getAuditorium_id()));

		logger.info("ScreeningServiceImpl - addScreening","Auditorium",audi.getAuditoriumName());
		
		Screening scr = Screening.build((long) 0, scrTo.getDate(), scrTo.getStartTime(), scrTo.getEndTime(),
				scrTo.getPrice(), false, null, null, audi, movie);

		Screening scrUpdate = scrRepo.save(scr);
		
	//	logger.info("ScreeningServiceImpl - addScreening","Screening",scrUpdate.getStartTime());
		
		return new ResponseScreeningTO(scrUpdate.getId(), scrUpdate.getDate(), scrUpdate.getStartTime(),
				scrUpdate.getEndTime(), scrUpdate.getPrice(), scrUpdate.isHouseFull(), new ResponseAudiTO(audi.getAuditoriumId(),audi.getAuditoriumName(),audi.getAuditoriumType(),audi.getSeatCount()), movie.getTitle());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, readOnly = true)
	public Object getAllScreeing(String title) {

		Movie movie = movieRepo.findByTitle(title)
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "title", title));
		
		logger.info("ScreeningServiceImpl - getAllScreeing","Movie",movie.getTitle());
		
		List<Screening> scrList = scrRepo.findByMovieId(movie.getMovieId()).orElseThrow(
				() -> new ResourceNotFoundException("Screening", "Movie Id", movie.getMovieId()));
		

	//	logger.info("ScreeningServiceImpl - getAllScreeing","scrList"+scrList);
		List<ResponseScreeningTO> responseToList = scrList.stream().map(s->new ResponseScreeningTO(s.getId(), s.getDate(), s.getStartTime(),
				s.getEndTime(), s.getPrice(), s.isHouseFull(), new ResponseAudiTO(s.getAuditorium().getAuditoriumId(),s.getAuditorium().getAuditoriumName(),s.getAuditorium().getAuditoriumType(),s.getAuditorium().getSeatCount()), movie.getTitle())).collect(Collectors.toList());
		
		return responseToList;
	}

}
