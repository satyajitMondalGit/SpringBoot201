package com.mindtree.movie.booking.app.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.movie.booking.app.dto.BookingTO;
import com.mindtree.movie.booking.app.dto.SeatTO;
import com.mindtree.movie.booking.app.exception.HouseFullExcption;
import com.mindtree.movie.booking.app.exception.ResourceNotFoundException;
import com.mindtree.movie.booking.app.model.Booking;
import com.mindtree.movie.booking.app.model.Screening;
import com.mindtree.movie.booking.app.model.Seat;
import com.mindtree.movie.booking.app.model.SeatReserved;
import com.mindtree.movie.booking.app.model.User;
import com.mindtree.movie.booking.app.repository.BookingRepository;
import com.mindtree.movie.booking.app.repository.ScreeningRepository;
import com.mindtree.movie.booking.app.repository.SeatRepository;
import com.mindtree.movie.booking.app.repository.SeatReservedRepository;
import com.mindtree.movie.booking.app.repository.UserRepository;
import com.mindtree.movie.booking.app.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
	
	private Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ScreeningRepository scrRepo;

	@Autowired
	private SeatReservedRepository seatReservedRepo;

	@Autowired
	private SeatRepository SeatRepo;

	@Autowired
	private BookingRepository bookingRepo;

	@Value("${houseeFull}")
	private String HousefullMessage;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, readOnly = false)
	public Object bookTickets(@Valid Long userId, @Valid long screeningId, @Valid int ticketsQuentity) {

		
		
		List<Seat> unreserved;
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		logger.info("BookingServiceImpl - bookTickets", "user", user.toString());
		
		Screening scr = scrRepo.findById(screeningId)
				.orElseThrow(() -> new ResourceNotFoundException("Screening", "screeningId", screeningId));

		logger.info("BookingServiceImpl - bookTickets", "Screening", scr.toString());
		
		List<Seat> seatList = SeatRepo.findByAuditoriamId(scr.getAuditorium().getAuditoriumId());
		
		logger.info("BookingServiceImpl - bookTickets", "seatList", seatList);
		
		if (ticketsQuentity <= seatList.size()) {
			List<SeatReserved> reservedList = seatReservedRepo.findByScreeingId(scr.getId()).orElse(null);
			if (reservedList == null || reservedList.size() + ticketsQuentity <= seatList.size()) {
				List<Long> reservedSeatid = reservedList.stream().map(r -> r.getSeat().getSeatId())
						.collect(Collectors.toList());

				unreserved = seatList.stream().filter(s -> !reservedSeatid.contains(s.getSeatId()))
						.limit(ticketsQuentity).collect(Collectors.toList());

			} else {
				throw new HouseFullExcption(HousefullMessage);
			}

		} else {
			throw new HouseFullExcption(HousefullMessage);
		}

		//

		Booking booking = new Booking();
		booking.setBookingDate(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
		booking.setBookingTime(LocalTime.now().format(DateTimeFormatter.ISO_TIME));
		booking.setTicketQty(ticketsQuentity);
		booking.setUser(user);
		booking.setScreening(scr);

		logger.info("BookingServiceImpl - bookTickets", "booking", booking.toString());
		Booking updatedBooking = bookingRepo.save(booking);

		unreserved.stream().map(s -> seatReservedRepo.save(SeatReserved.build((long) 0, s, updatedBooking, scr)));
//				.collect(Collectors.toList());


		return BookingTO.build(updatedBooking.getBookingId(), updatedBooking.getBookingDate(),
				updatedBooking.getBookingTime(), ticketsQuentity, scr.getId(), scr.getAuditorium().getAuditoriumId(),
				unreserved.stream().map(s -> new SeatTO(s.getSeatId(), s.getSeatNo(), s.getPossition()))
						.collect(Collectors.toList()));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, readOnly = true)
	public Object getBookingDetails(Long userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		
		logger.info("BookingServiceImpl - getBookingDetails", "user", user.toString());
		
		List<Booking> bookingList = bookingRepo.findByUserId(user.getUserId());
		return bookingList;
	}

}
