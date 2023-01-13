package com.mindtree.movie.booking.app.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.movie.booking.app.dto.BookingDTO;
import com.mindtree.movie.booking.app.dto.MovieDTO;
import com.mindtree.movie.booking.app.dto.ResponseBookingDTO;
import com.mindtree.movie.booking.app.dto.ResponseCinemaHallDTO;
import com.mindtree.movie.booking.app.dto.ScreeningDTO;
import com.mindtree.movie.booking.app.dto.UserDTO;
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
	public List<ResponseCinemaHallDTO> getAlShow() {

		List<CinemaHall> cinemaHallList = hallRepo.findAll();

		List<ResponseCinemaHallDTO> cinemaHallDto = cinemaHallList.stream().map(c -> new ResponseCinemaHallDTO(
				c.getHallId(), c.getHallName(), c.getHallType(),
				c.getScreenings().stream().map(s -> new ScreeningDTO(s.getId(), s.getStartTime(), s.getEndTime(),
						s.getDate(), s.getPrice(),
						new MovieDTO(s.getMovie().getMovieId(), s.getMovie().getTitle(), s.getMovie().getReleaseDate(),
								s.getMovie().getGenere(), s.getMovie().getDuration())))
						.collect(Collectors.toList())))
				.collect(Collectors.toList());

		return cinemaHallDto;
	}

	@Override
	public ResponseBookingDTO bookTickets(Long userId, long screeningId, int ticketsQuentity) {

		Screening screening = screeningRepo.findById(screeningId)
				.orElseThrow(() -> new ResourceNotFoundException("Screening", "Id", screeningId));

		ScreeningDTO scrDto = new ScreeningDTO(screening.getId(), screening.getDate(), screening.getStartTime(),
				screening.getEndTime(), screening.getPrice(),
				new MovieDTO(screening.getMovie().getMovieId(), screening.getMovie().getTitle(),
						screening.getMovie().getReleaseDate(), screening.getMovie().getGenere(),
						screening.getMovie().getDuration()));
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));
		UserDTO userDto = new UserDTO(user.getUserId(), user.getUserName(), user.getMobileNumber(), user.getEmail());
		Booking booking = new Booking();
		booking.setBookingDate(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
		booking.setBookingTime(LocalTime.now().format(DateTimeFormatter.ISO_TIME));
		booking.setScreeningId(screening.getId());
		booking.setTicketQty(ticketsQuentity);
		booking.setUserId(user.getUserId());
		// booking.setUser(user);

		Booking bookingUpdated = bookingRepo.save(booking);

		return new ResponseBookingDTO(bookingUpdated.getBookingId(),bookingUpdated.getBookingDate(),bookingUpdated.getBookingTime(),bookingUpdated.getTicketQty(),userDto,scrDto);

	}

	@Override
	public List<BookingDTO> getEarlierTicketsDetails(long userId) {

		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));
		
		List<Booking> bookingList = bookingRepo.findByUserId((long)userId).orElseThrow(() -> new ResourceNotFoundException("Booking", "UserId", userId));
		
		return bookingList.stream().map(b->new BookingDTO(b.getBookingId(),b.getBookingDate(),b.getBookingTime(),b.getTicketQty(),b.getScreeningId(),b.getUserId())).collect(Collectors.toList());
	}

}
