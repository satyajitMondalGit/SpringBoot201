package com.mindtree.movie.booking.app.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
	public Object bookTickets(@Valid Long userId, @Valid long screeningId, @Valid int ticketsQuentity) {

		int index = 0;
		List<Seat> unreserved;
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		Screening scr = scrRepo.findById(screeningId)
				.orElseThrow(() -> new ResourceNotFoundException("Screening", "screeningId", screeningId));

		List<Seat> seatList = SeatRepo.findByAuditoriamId(scr.getAuditorium().getAuditoriumId());
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

		Booking updatedBooking = bookingRepo.save(booking);

		unreserved.stream().map(s -> seatReservedRepo.save(SeatReserved.build((long) 0, s, updatedBooking, scr)))
				.collect(Collectors.toList());


		return BookingTO.build(updatedBooking.getBookingId(), updatedBooking.getBookingDate(),
				updatedBooking.getBookingTime(), ticketsQuentity, scr.getId(), scr.getAuditorium().getAuditoriumId(),
				unreserved.stream().map(s -> new SeatTO(s.getSeatId(), s.getSeatNo(), s.getPossition()))
						.collect(Collectors.toList()));
	}

	@Override
	public Object getBookingDetails(Long userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		
		
		List<Booking> bookingList = bookingRepo.findByUserId(userId);
		return bookingList;
	}

}
