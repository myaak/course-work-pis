package com.pjp.cinema.configurations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pjp.cinema.data.CoverRepository;
import com.pjp.cinema.data.GenreRepository;
import com.pjp.cinema.data.MovieRepository;
import com.pjp.cinema.data.MovieSessionRepository;
import com.pjp.cinema.dto.Cover;
import com.pjp.cinema.dto.Genre;
import com.pjp.cinema.dto.Movie;
import com.pjp.cinema.dto.MovieSession;

@Configuration
public class PJPConfiguration {

	private Logger log = LoggerFactory.getLogger(PJPConfiguration.class);

	//@Bean
	//public CommandLineRunner initData(GenreRepository gRepo, CoverRepository cRepo, MovieRepository mRepo) {
	//	return args -> {
	//		log.info("Preloading " + gRepo.save(new Genre("classic")));
	//		log.info("Preloading " + gRepo.save(new Genre("comedy")));
	//		log.info("Preloading " + gRepo.save(new Genre("drama")));
	//		log.info("Preloading " + gRepo.save(new Genre("melodrama")));
	//		log.info("Preloading " + gRepo.save(new Genre("biopic")));
	//		log.info("Preloading " + gRepo.save(new Genre("horror")));
	//		log.info("Preloading " + gRepo.save(new Genre("action")));

	//		log.info("Preloading " + cRepo.save(new Cover("/home/thesr/homework/6sem/pis/program/cinema/src/main/resources/static/covers/default.jpg")));
	//		log.info("Preloading " + cRepo.save(new Cover("/home/thesr/homework/6sem/pis/program/cinema/src/main/resources/static/covers/1011.jpg")));
	//		log.info("Preloading " + cRepo.save(new Cover("/home/thesr/homework/6sem/pis/program/cinema/src/main/resources/static/covers/ribalka.jpg")));

	//		Cover cover1 = cRepo.findById(1L).get();
	//		Cover cover2 = cRepo.findById(2L).get();
	//		Cover cover3 = cRepo.findById(3L).get();
	//		Genre genre1 = gRepo.findById(1L).get();
	//		Genre genre2 = gRepo.findById(2L).get();
	//		Genre genre3 = gRepo.findById(6L).get();
	//		log.info("Preloading " + mRepo.save(new Movie("Dmb", 85, cover1, "Dembel is unavoidable", List.of(genre1, genre2))));
	//		log.info("Preloading " + mRepo.save(new Movie("Terminator", 85, cover2, "Da pribudet spasitel", List.of(genre1, genre3))));
	//		log.info("Preloading " + mRepo.save(new Movie("Osobennosti nacionalnoi ribalki", 85, cover3, "Nu, za solidnoe mujskoe molchanie", List.of(genre1))));
	//	};
	//}
	@Bean
	public CommandLineRunner initData(GenreRepository gRepo, CoverRepository cRepo, MovieRepository mRepo, MovieSessionRepository msRepo) {
		return args -> {
			log.info("Preloading " + gRepo.save(new Genre("classic")));
			log.info("Preloading " + gRepo.save(new Genre("comedy")));
			log.info("Preloading " + gRepo.save(new Genre("drama")));
			log.info("Preloading " + gRepo.save(new Genre("melodrama")));
			log.info("Preloading " + gRepo.save(new Genre("biopic")));
			log.info("Preloading " + gRepo.save(new Genre("horror")));
			log.info("Preloading " + gRepo.save(new Genre("action")));

			log.info("Preloading " + cRepo.save(new Cover("/home/thesr/homework/6sem/pis/program/cinema/src/main/resources/static/covers/default.jpg")));
			log.info("Preloading " + cRepo.save(new Cover("/home/thesr/homework/6sem/pis/program/cinema/src/main/resources/static/covers/1011.jpg")));
			log.info("Preloading " + cRepo.save(new Cover("/home/thesr/homework/6sem/pis/program/cinema/src/main/resources/static/covers/ribalka.jpg")));

			Cover cover1 = cRepo.findById(1L).get();
			Cover cover2 = cRepo.findById(2L).get();
			Cover cover3 = cRepo.findById(3L).get();

			Genre genre1 = gRepo.findById(1L).get();
			Genre genre2 = gRepo.findById(2L).get();
			Genre genre3 = gRepo.findById(6L).get();

			log.info("Preloading " + mRepo.save(new Movie("Dmb", 85, cover1, "Dembel is unavoidable", List.of(genre1, genre2))));
			log.info("Preloading " + mRepo.save(new Movie("Terminator", 85, cover2, "Da pribudet spasitel", List.of(genre1, genre3))));
			log.info("Preloading " + mRepo.save(new Movie("Osobennosti nacionalnoi ribalki", 85, cover3, "Nu, za solidnoe mujskoe molchanie", List.of(genre1))));

			Movie movie1 = mRepo.findById(1L).get();
			Movie movie2 = mRepo.findById(2L).get();
			Movie movie3 = mRepo.findById(3L).get();

			log.info("Preloading " + msRepo.save(new MovieSession(movie1, 1L, LocalDate.of(2023, 5, 23), LocalTime.of(11, 10))));
			//log.info("Preloading " + msRepo.save(new MovieSession(movie1, 2L, LocalDate.of(2023, 5, 23), LocalTime.of(14, 10))));



		};
	}

}
