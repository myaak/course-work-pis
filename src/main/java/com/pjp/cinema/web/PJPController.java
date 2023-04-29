package com.pjp.cinema.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pjp.cinema.dto.Genre;
import com.pjp.cinema.dto.Movie;
import com.pjp.cinema.dto.MovieSession;
import com.pjp.cinema.dto.Seat;
import com.pjp.cinema.dto.User;
import com.pjp.cinema.dto.UserLogin;
import com.pjp.cinema.web.services.GenreService;
import com.pjp.cinema.web.services.MovieService;
import com.pjp.cinema.web.services.MovieSessionService;
import com.pjp.cinema.web.services.SeatService;
//import com.pjp.cinema.web.services.StatusService;
import com.pjp.cinema.web.services.UserService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
public class PJPController {

	private UserService userService;
	//private AuditoriumService auditoriumService;
	private GenreService genreService;
	private MovieService movieService;
	private MovieSessionService movieSessionService;
	private SeatService seatService;
	//private StatusService statusService;

	@Autowired
	public PJPController(UserService userService, GenreService genreService,
			MovieService movieService, MovieSessionService movieSessionService, SeatService seatService) {
		this.userService = userService;
		//this.auditoriumService = auditoriumService;
		this.genreService = genreService;
		this.movieService = movieService;
		this.movieSessionService = movieSessionService;
		this.seatService = seatService;
		//this.statusService = statusService;
	}

	@PostMapping("auth/{login}")
	public User authUser(@RequestBody UserLogin login,
			HttpServletResponse response) {
		return userService.authUser(login, response);
	}



	@GetMapping("get/users")
	public List<User> getAllUsers() {
		return userService.getAll();
	}

	@GetMapping("get/user/{id}")
	public User getUserById(@PathVariable(name = "id") Long id) {
		return userService.getById(id);
	}

	@PostMapping("post/user")
	public void postUser(@RequestBody User user) {
		userService.add(user);
	}



	@GetMapping("get/seats")
	public List<Seat> getAllSeats() {
		return seatService.getAll();
	}

	@GetMapping("get/seat/{id}")
	public Seat getSeatById(@PathVariable(name = "id") Long id) {
		return seatService.getById(id);
	}

	//@PostMapping("post/seat")
	//public void postSeat(@RequestBody Seat seat) throws IOException {
	//	seatService.add(seat);
	//}



	@GetMapping("get/sessions")
	public List<MovieSession> getAllSessions() {
		return movieSessionService.getAll();
	}

	@GetMapping("get/session/{id}")
	public Movie getSessionById(@PathVariable(name = "id") Long id) {
		return movieService.getById(id);
	}

	@PostMapping("post/session")
	public void postSession(@RequestBody MovieSession movieSession) throws NoSuchElementException, IOException{
		movieSessionService.add(movieSession);
	}



	@GetMapping("get/movies")
	@CrossOrigin
	public List<Movie> getAllMovies() {
		return movieService.getAll();
	}

	@GetMapping("get/movie/{id}")
	@CrossOrigin
	public Movie getMoviesById(@PathVariable(name = "id") Long id) {
		return movieService.getById(id);
	}

	@CrossOrigin
	@PostMapping("post/movie")
	public void postMovie(@RequestBody Movie movie) throws NoSuchElementException, IOException {
		movieService.add(movie);
	}



	@GetMapping("get/genres")
	@CrossOrigin
	public List<Genre> getAllGenres() {
		return genreService.getAll();
	}

	@GetMapping("get/genre/{id}")
	@CrossOrigin
	public Genre getGenreById(@PathVariable(name = "id") Long id) {
		return genreService.getById(id);
	}
  
	@PostMapping("post/genre")
	@CrossOrigin
	public void postGenre(@RequestBody Genre genre) {
		genreService.add(genre);
	}



//	@GetMapping("get/cover/{id}")
//	@CrossOrigin
//	public @ResponseBody ResponseEntity<Resource> getCover(@PathVariable(name = "id") Long id) {
//		Resource result = movieService.getCover(id);
//		return ResponseEntity.ok().body(result);
//	}

	@GetMapping("get/cover/{id}")
	@CrossOrigin
	public ResponseEntity<InputStreamResource> getCover(@PathVariable(name = "id") Long id) throws IOException {
		Resource result = movieService.getCover(id);
		MediaType contentType = MediaType.IMAGE_JPEG;
		InputStream in = result.getInputStream();
		return ResponseEntity.ok().contentType(contentType).body(new InputStreamResource(in));
	}

	//@DeleteMapping("delete/genre/{id}")
	//public void deleteGenre(@PathVariable("id") Long id) {
	//	genreService.delete(id);
	//}



}
