package com.pjp.cinema.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pjp.cinema.dto.Cover;

@Repository
public interface CoverRepository extends JpaRepository<Cover, Long> {

}
