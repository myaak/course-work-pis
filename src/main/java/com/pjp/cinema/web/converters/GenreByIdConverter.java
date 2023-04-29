package com.pjp.cinema.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.pjp.cinema.data.GenreRepository;
import com.pjp.cinema.dto.Genre;

@Component
public class GenreByIdConverter implements Converter<Long, Genre>{

	@Autowired
	private GenreRepository repo;

	public Genre convert(Long id) {
		return repo.findById(id).get();
	}

}
