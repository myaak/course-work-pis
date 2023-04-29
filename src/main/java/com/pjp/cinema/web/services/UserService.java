package com.pjp.cinema.web.services;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjp.cinema.data.UserRepository;
import com.pjp.cinema.dto.Seat;
import com.pjp.cinema.dto.User;
import com.pjp.cinema.dto.UserLogin;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private SeatService seatService;
	private Logger log = LoggerFactory.getLogger(MovieSessionService.class);

	public User authUser(UserLogin login, HttpServletResponse response) {
		Optional<User> user = userRepo.findByEmail(login.getEmail());
		if (user.isPresent() 
				&& user.get().getPassword().equals(login.getPassword())) {
			response.setStatus(HttpServletResponse.SC_OK);
			return user.get();
		}
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		return null;
	}

	public List<User> getAll() {
		return userRepo.findAll();
	}

	public User getById(Long id) {
		return userRepo.findById(id).get();
	}

	public void delete(Long id) {
		userRepo.deleteById(id);
	}

	public User add(User user) {
		User res =  userRepo.save(user);
		log.info("{}", user);
		return res;
	}

}
