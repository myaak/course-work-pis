package com.pjp.cinema.dto;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;
	private int durationInMinutes;

	@ManyToOne
	private Cover cover;
	//private String coverURL;
	private String description;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Genre> genres;

	//@OneToMany
	//private List<MovieSession> sessions;

	public Movie(String title, int durationInMinutes, Cover cover, String description, List<Genre> genres) {
		this.title = title;
		this.durationInMinutes = durationInMinutes;
		this.cover = cover;
		this.description = description;
		this.genres = genres;
	}

	public Movie() {
	}

	//public List<MovieSession> getSessions() {
	//	return sessions;
	//}

	//public void setSessions(List<MovieSession> sessions) {
	//	this.sessions = sessions;
	//}

	public Cover getCover() {
		return cover;
	}

	public void setCover(Cover cover) {
		this.cover = cover;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDurationInMinutes() {
		return durationInMinutes;
	}

	public void setDurationInMinutes(int durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, title, durationInMinutes, cover, description, genres);
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
		Movie other = (Movie) obj;
		return Objects.equals(id, other.id) && Objects.equals(title, other.title)
				&& durationInMinutes == other.durationInMinutes && Objects.equals(cover, other.cover)
				&& Objects.equals(description, other.description) && Objects.equals(genres, other.genres);
	}

	@Override
	public String toString() {
		return "Movie[id=" + id + ", title=" + title + ", durationInMinutes=" + durationInMinutes + ", cover=" + cover
				+ ", description=" + description + ", genres=" + genres +  "]";
	}



}
