package com.pjp.cinema.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pjp.cinema.dto.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

}
