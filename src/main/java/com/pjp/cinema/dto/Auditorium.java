//package com.pjp.cinema.dto;
//
//import java.util.Objects;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//@Entity
//public class Auditorium {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//	private Long number;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Long getNumber() {
//		return number;
//	}
//
//	public void setNumber(Long number) {
//		this.number = number;
//	}
//
//	@Override
//	public boolean equals(Object otherObject) {
//		if (this == otherObject)
//			return true;
//		if (otherObject == null)
//			return false;
//		if (getClass() != otherObject.getClass())
//			return false;
//		Auditorium other = (Auditorium) otherObject;
//		return Objects.equals(id, other.id)
//			&& Objects.equals(number, other.number);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(id, number);
//	}
//
//	@Override
//	public String toString() {
//		return "Auditorium [id=" + id + ", number=" + number + "]";
//	}
//
//}
