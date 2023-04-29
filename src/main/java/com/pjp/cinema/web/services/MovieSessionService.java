package com.pjp.cinema.web.services;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjp.cinema.data.MovieSessionRepository;
import com.pjp.cinema.dto.Movie;
import com.pjp.cinema.dto.MovieSession;

@Service
public class MovieSessionService {

	@Autowired
	private MovieSessionRepository sessionRepo;

	@Autowired
	private MovieService movieServ;

	//@Autowired
	//private AuditoriumService auditoriumServ;
	private Logger log = LoggerFactory.getLogger(MovieSessionService.class);

	public List<MovieSession> getAll() {
		return sessionRepo.findAll();
	}

	public MovieSession getById(Long id) {
		return sessionRepo.findById(id).get();
	}

	public void delete(Long id) {
		sessionRepo.deleteById(id);
	}

	public MovieSession add(MovieSession session) throws NoSuchElementException, IOException {
		Movie movie = session.getMovie();
		if (movie != null) {
			Movie tmp = movieServ.getById(movie.getId());
			if (tmp != null) {
				session.setMovie(tmp);
			} else {
				throw new NoSuchElementException("movie does not exists");
			}
		}
		//Auditorium auditorium = session.getAuditorium();
		//if (auditoriumServ.getByNumber(auditorium.getNumber()).isEmpty()) {
		//	auditorium = auditoriumServ.add(auditorium);
		//}
		//movie.getGenres().forEach(i -> genreRepository.save(i));
		//session.setMovie(movie);
		//session.setAuditorium(auditorium);
		MovieSession res =  sessionRepo.save(session);
		log.info("{}", session);
		return res;
	}

}
