package com.pjp.cinema.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class MovieSession {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Movie movie;

	//@ManyToOne
	//private Auditorium auditorium;
	private Long auditorium;
	private LocalDate date;
	private LocalTime startTime;

	//@OneToMany
	//@OneToMany(fetch = FetchType.EAGER)
	//private List<Seat> seats;

	public MovieSession(Movie movie, Long auditorium, LocalDate date, LocalTime startTime) {
		this.movie = movie;
		this.auditorium = auditorium;
		this.date = date;
		this.startTime = startTime;
	}

	public MovieSession() {
	}

	//public List<Seat> getSeats() {
	//	return seats;
	//}

	//public void setSeats(List<Seat> seats) {
	//	this.seats = seats;
	//}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Long getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(Long auditorium) {
		this.auditorium = auditorium;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, movie, auditorium, date, startTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		MovieSession other = (MovieSession) obj;
		return Objects.equals(id, other.id) && Objects.equals(movie, other.movie)
				&& Objects.equals(auditorium, other.auditorium) && Objects.equals(date, other.date)
				&& Objects.equals(startTime, other.startTime);
	}

	@Override
	public String toString() {
		return "MovieSession[id=" + id + ", movie=" + movie + ", auditorium=" + auditorium + ", date=" + date
				+ ", startTime=" + startTime + "]";
	}


}
