package com.pjp.cinema.web.services;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjp.cinema.data.SeatRepository;
import com.pjp.cinema.dto.MovieSession;
import com.pjp.cinema.dto.Seat;

@Service
public class SeatService {

	@Autowired
	private SeatRepository seatRepo;

	@Autowired
	private MovieSessionService sessionService;
	private Logger log = LoggerFactory.getLogger(MovieSessionService.class);

	public List<Seat> getAll() {
		return seatRepo.findAll();
	}

	public Seat getById(Long id) {
		return seatRepo.findById(id).get();
	}

	public void delete(Long id) {
		seatRepo.deleteById(id);
	}

	//public Seat add(Seat seat) throws IOException {
	//	//MovieSession movieSession = sessionService.add(seat.getSession());
	//	//seat.setSession(movieSession);

	//	//Seat res =  seatRepo.save(seat);
	//	//log.info("{}", seat);
	//	//return res;
	//}

}
