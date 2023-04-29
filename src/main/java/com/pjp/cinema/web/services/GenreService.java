package com.pjp.cinema.web.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjp.cinema.data.GenreRepository;
import com.pjp.cinema.dto.Genre;

@Service
public class GenreService {

	private GenreRepository genreRepo;
	private Logger log;

	@Autowired
	public GenreService(GenreRepository genreRepo) {
		this.genreRepo = genreRepo;
		this.log = LoggerFactory.getLogger(GenreService.class);
	}

	public List<Genre> getAll() {
		return genreRepo.findAll();
	}

	public Genre getById(Long id) {
		return genreRepo.findById(id).get();
	}

	public void delete(Long id) {
		genreRepo.deleteById(id);
	}

	public void add(Genre genre) {
		genreRepo.save(genre);
		log.info("{}", genre);
	}

}
