package com.mindtree.movie.booking.app.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.movie.booking.app.dto.AuditoriumTO;
import com.mindtree.movie.booking.app.dto.ResponseAuditoriumTO;
import com.mindtree.movie.booking.app.exception.ResourceNotFoundException;
import com.mindtree.movie.booking.app.model.Auditorium;
import com.mindtree.movie.booking.app.model.Seat;
import com.mindtree.movie.booking.app.repository.AuditoriumRepository;
import com.mindtree.movie.booking.app.repository.SeatRepository;
import com.mindtree.movie.booking.app.service.AuditoriumService;


@Service
public class AuditoriumServiceImpl implements AuditoriumService {
	
	@Autowired
	private AuditoriumRepository auditoriumRepo;
	
	@Autowired
	private SeatRepository seatRepo;

	@Override
	public ResponseAuditoriumTO addNewAuditorium(@Valid AuditoriumTO auditoriumTo) {
		
		
		Auditorium audito = Auditorium.build(0, auditoriumTo.getAuditoriumName(), auditoriumTo.getAuditoriumType(),auditoriumTo.getSeatCount() , null, null);
		Auditorium upAudi = auditoriumRepo.save(audito);
		
		int seatCount = auditoriumTo.getSeatCount();
		Set<Seat> seatList = new HashSet<>();

		for(int i=1; i<= seatCount; i++) {
			
			Seat s;
			if(i<seatCount/2) {
		
				s = Seat.build((long)0, i, "Front", null, upAudi);
				
			}else {
				s = Seat.build((long)0, i, "Back", null, upAudi);
				
			}
			
			Seat s1 = seatRepo.save(s);
			seatList.add(s1);
		}
		
		
		return new ResponseAuditoriumTO(upAudi.getAuditoriumId(), upAudi.getAuditoriumName(),upAudi.getAuditoriumType(),seatCount, null,seatList);
	}
	
}
