package com.pjp.cinema.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pjp.cinema.dto.MovieSession;

@Repository
public interface MovieSessionRepository extends JpaRepository<MovieSession, Long> {

}
