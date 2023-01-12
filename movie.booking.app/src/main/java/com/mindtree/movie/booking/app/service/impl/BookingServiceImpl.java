package com.mindtree.movie.booking.app.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.movie.booking.app.dao.BookingDao;
import com.mindtree.movie.booking.app.dao.MovieDao;
import com.mindtree.movie.booking.app.dao.ResponseCinemaHallDao;
import com.mindtree.movie.booking.app.dao.ScreeningDao;
import com.mindtree.movie.booking.app.dao.UserDao;
import com.mindtree.movie.booking.app.exception.ResourceNotFoundException;
import com.mindtree.movie.booking.app.model.Booking;
import com.mindtree.movie.booking.app.model.CinemaHall;
import com.mindtree.movie.booking.app.model.Movie;
import com.mindtree.movie.booking.app.model.Screening;
import com.mindtree.movie.booking.app.model.User;
import com.mindtree.movie.booking.app.repository.BookingRepository;
import com.mindtree.movie.booking.app.repository.CinemaHallRepositorty;
import com.mindtree.movie.booking.app.repository.ScreeningRepository;
import com.mindtree.movie.booking.app.repository.UserRepository;
import com.mindtree.movie.booking.app.service.BookingService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookingServiceImpl implements BookingService {
	

	@Autowired
	private CinemaHallRepositorty hallRepo;
	
	@Autowired
	private BookingRepository bookingRepo;
	
	@Autowired
	private ScreeningRepository screeningRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public ResponseCinemaHallDao getAlShow() {
		LocalDate date = LocalDate.now(); 
		
		CinemaHall allScreening = hallRepo.getAllShow(date).orElseThrow(()-> new ResourceNotFoundException("CinemaHall", "Hall Id", 0));
		
		List<Screening> screeningList = allScreening.getScreenings();
		List<ScreeningDao> screeningDaoList = new ArrayList<ScreeningDao>();
		for(Screening scrn: screeningList) {
			Movie m = scrn.getMovie();
			MovieDao mDao = new MovieDao(m.getMovieId(),m.getTitle(),m.getReleaseDate(),m.getGenere(),m.getDuration());
			log.debug(mDao.toString());
			ScreeningDao sDao = new ScreeningDao(scrn.getId(),scrn.getDate(),scrn.getStartTime(),scrn.getEndTime(),scrn.getPrice(),mDao);
			log.debug(sDao.toString());
			screeningDaoList.add(sDao);
		}
	  
		
		return new ResponseCinemaHallDao(allScreening.getHallId(),allScreening.getHallName(),allScreening.getHallType(),screeningDaoList) ;
	}
	
	
	@Override
	public UserDao bookTickets(Long userId, long screeningId, int ticketsQuentity) {


		Screening screening  = screeningRepo.findById(screeningId).orElseThrow(()->new ResourceNotFoundException("Screening","Id",screeningId));
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","UserId",userId));
		Booking booking = new Booking();
		booking.setBookingDate(LocalDate.now());
		booking.setBookingTime(LocalTime.now());
		booking.setScreeningId(screening.getId());
		booking.setTicketQty(ticketsQuentity);
		booking.setUser(user);
		
		Booking bookingUpdated =bookingRepo.save(booking);
		
		Movie movie = screening.getMovie();
		MovieDao movieDao = new MovieDao(movie.getMovieId(),movie.getTitle(),movie.getReleaseDate(),movie.getGenere(),movie.getDuration());
		
		ScreeningDao scrnningDao = new ScreeningDao(screening.getId(), screening.getDate(), screening.getStartTime(),screening.getEndTime(),screening.getPrice(),movieDao);
		BookingDao bookingDao = new BookingDao(bookingUpdated.getBookingId(),bookingUpdated.getBookingDate(),bookingUpdated.getBookingTime(),bookingUpdated.getTicketQty(),scrnningDao);
		List<BookingDao> bookingDaoList = new ArrayList<BookingDao>();
		bookingDaoList.add(bookingDao);
		
		return new UserDao(user.getUserId(),user.getUserName(),user.getMobileNumber(),user.getEmail(),bookingDaoList); 
		
	}


	@Override
	public UserDao getEarlierTicketsDetails(long userId) {
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User Id", userId));
		List<Booking> bookingList = user.getBookings();
		List<BookingDao> bookingDaoList = new ArrayList<BookingDao>();
		for(Booking booking :bookingList) {
			Screening screening  = screeningRepo.findById(booking.getScreeningId()).orElseThrow(()->new ResourceNotFoundException("Screening","Id",booking.getScreeningId()));
			Movie movie = screening.getMovie();
			MovieDao movieDao = new MovieDao(movie.getMovieId(),movie.getTitle(),movie.getReleaseDate(),movie.getGenere(),movie.getDuration());
			ScreeningDao scrnningDao = new ScreeningDao(screening.getId(), screening.getDate(), screening.getStartTime(),screening.getEndTime(),screening.getPrice(),movieDao);
			BookingDao bookingDao = new BookingDao(booking.getBookingId(),booking.getBookingDate(),booking.getBookingTime(),booking.getTicketQty(),scrnningDao);
			bookingDaoList.add(bookingDao);
		}
		
		return new UserDao(user.getUserId(),user.getUserName(),user.getMobileNumber(),user.getEmail(),bookingDaoList); 
	}
	

}
