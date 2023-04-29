package com.pjp.cinema.dto;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cover {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String url;

	public Cover() {}

	public Cover(String url) {
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, url);
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
		Cover other = (Cover) obj;
		return Objects.equals(id, other.id) && Objects.equals(url, other.url);
	}

	@Override
	public String toString() {
		return "Cover[id=" + id + ", url=" + url + "]";
	}

}
