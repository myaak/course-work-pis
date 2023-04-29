package com.pjp.cinema.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pjp.cinema.dto.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

	Optional<Genre> findByTitle(String title);

}
