package com.mindtree.movie.booking.app.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Autowired
	private MovieRepository movieRepo;

	@Autowired
	private AuditoriumRepository audiRepo;

	@Autowired
	private ScreeningRepository scrRepo;

	@Override
	public ResponseScreeningTO addScreening(@Valid ScreeningTO scrTo) {

		Movie movie = movieRepo.findById((long) scrTo.getMovie_id())
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "Movie Id", scrTo.getMovie_id()));

		Auditorium audi = audiRepo.findById((long) scrTo.getAuditorium_id()).orElseThrow(
				() -> new ResourceNotFoundException("Auditorium", "Auditorium Id", scrTo.getAuditorium_id()));

		
		Screening scr = Screening.build((long) 0, scrTo.getDate(), scrTo.getStartTime(), scrTo.getEndTime(),
				scrTo.getPrice(), false, null, null, audi, movie);

		Screening scrUpdate = scrRepo.save(scr);
		return new ResponseScreeningTO(scrUpdate.getId(), scrUpdate.getDate(), scrUpdate.getStartTime(),
				scrUpdate.getEndTime(), scrUpdate.getPrice(), scrUpdate.isHouseFull(), audi, movie);
	}

	@Override
	public Object getAllScreeing(String title) {

		Movie movie = movieRepo.findByTitle(title)
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "title", title));
		
		List<Screening> scrList = scrRepo.findByMovieId(movie.getMovieId()).orElseThrow(
				() -> new ResourceNotFoundException("Screening", "Movie Id", movie.getMovieId()));
		

		return scrList;
	}

}
