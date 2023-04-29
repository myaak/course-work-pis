//package com.pjp.cinema.web.services;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.pjp.cinema.data.AuditoriumRepository;
//import com.pjp.cinema.dto.Auditorium;
//
//@Service
//public class AuditoriumService {
//
//	private AuditoriumRepository auditoriumRepo;
//
//	@Autowired
//	public AuditoriumService(AuditoriumRepository auditoriumRepo) {
//		this.auditoriumRepo = auditoriumRepo;
//	}
//
//	public List<Auditorium> getAll() {
//		return auditoriumRepo.findAll();
//	}
//
//	public Auditorium getById(Long id) {
//		return auditoriumRepo.findById(id).get();
//	}
//
//	public Optional<Auditorium> getByNumber(Long number) {
//		return auditoriumRepo.findByNumber(number);
//	}
//
//	public void delete(Long id) {
//		auditoriumRepo.deleteById(id);
//	}
//
//	public Auditorium add(Auditorium auditorium) {
//		return auditoriumRepo.save(auditorium);
//	}
//
//}
