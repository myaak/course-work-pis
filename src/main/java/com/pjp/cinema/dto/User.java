package com.pjp.cinema.dto;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;

	@Column(unique = true)
	private String email;
	private String password;
	private String role;

	@OneToMany
	private List<Seat> seats;

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object otherObject) {
		if (this == otherObject)
			return true;
		if (otherObject == null)
			return false;
		if (getClass() != otherObject.getClass())
			return false;
		User other = (User) otherObject;
		return Objects.equals(id, other.id)
			&& Objects.equals(name, other.name)
			&& Objects.equals(email, other.email)
			&& Objects.equals(password, other.password)
			&& Objects.equals(role, other.role)
			&& Objects.equals(seats, other.seats);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, email, password, role, seats);
	}

	@Override
	public String toString() {
		return "User [id=" + id
			+ ", name=" + name
			+ ", email=" + email
			+ ", password=" + password
			+ ", role=" + role
			+ ", seats=" + seats + "]";
	}

	
}
