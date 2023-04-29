package com.pjp.cinema.web.services;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pjp.cinema.data.CoverRepository;
import com.pjp.cinema.data.GenreRepository;
import com.pjp.cinema.data.MovieRepository;
import com.pjp.cinema.dto.Cover;
import com.pjp.cinema.dto.Genre;
import com.pjp.cinema.dto.Movie;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepo;

	@Autowired
	private GenreRepository genreRepository;

	@Autowired
	private CoverRepository coverRepo;

	private Logger log = LoggerFactory.getLogger(MovieService.class);
	private Path trackStoragePath = Paths.get("/home/thesr/homework/6sem/pis/program/cinema/src/main/resources/static/covers/");

	public List<Movie> getAll() {
		return movieRepo.findAll();
	}

	public Movie getById(Long id) {
		return movieRepo.findById(id).get();
	}

	public Optional<Movie> getByTitle(String title) {
		return movieRepo.findByTitle(title);
	}

	public void delete(Long id) {
		movieRepo.deleteById(id);
	}

	public Movie add(Movie movie) throws IOException {
		if (movie.getGenres() != null) {
			List<Genre> genres = new ArrayList<>();
			for (Genre g : movie.getGenres()) {
				Optional<Genre> tmp = genreRepository.findById(g.getId());
				if (tmp.isEmpty()) {
					throw new NoSuchElementException("Genre with id="
							+ g.getId()
							+ " does not exist");
				}
				genres.add(tmp.get());
			}
			movie.setGenres(genres);
		}
		if (movie.getCover() == null || movie.getCover().getUrl() == null) {
			movie.setCover(coverRepo.findById(1L).get());
		} else {
			Path coverPath = downloadCover(movie.getCover().getUrl());
			Cover cover = coverRepo.save(new Cover(coverPath.toString()));
			movie.setCover(cover);
		}
			//movie.setCoverURL(trackStoragePath + "/default.jpg");
		
		//} else {
			//Path coverPath = downloadCover(movie.getCoverURL());
			//movie.setCoverURL(coverPath.toString());
		//}
		//movie.getGenres().forEach(i -> genreRepository.save(i));
		Movie res = movieRepo.save(movie);
		return res;
	}

	private Path downloadCover(String coverURL) throws IOException {
		try {
			URL url = createFileURL(coverURL);

			//resolve track path without leading '/' in the track name
			Path coverPath;
			Path coverName = Paths.get(coverURL).getFileName();
			//if (coverURL.charAt(0) == '/') {
			//	coverPath = 
			//		trackStoragePath.resolve(coverURL.substring(1));
			//} else {
			coverPath = trackStoragePath.resolve(coverName);
			//}
			
			return saveCover(url, coverPath);
		} catch (FileAlreadyExistsException | FileNotFoundException | MalformedURLException e) {
			e.printStackTrace();
			throw new IOException();
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
	}



	private URL createFileURL(String urlString)
			throws MalformedURLException {
		URL url;
		//try {
			url = new URL(urlString);
		//} catch (MalformedURLException e) {
			//throw new AudioDataDownloadingException(e);
		//}
		return url;
	}

	private Path saveCover(URL fileURL, Path filePath) throws FileAlreadyExistsException, FileNotFoundException, IOException  {
        //log.debug("Saving photo");
        //String result;
        //if (cover == null || cover.isEmpty()) {
        //    log.debug("New cover is not present");
        //    Long id = movie.getId();
        //    if (id != null) {
        //        Optional<Movie> tmp = movieRepo.findById(id);
        //        log.info("Cover with id=" + id + " already exists");
        //        return tmp.get().getCoverURL();
        //    } else {
        //        log.info("Cover does not exist. Setting default photo");
        //        Path filePath =
        //            Paths.get("./src/main/resources/static/images/default.jpg");
        //        byte[] def = Files.readAllBytes(filePath);
        //        result.setData(def);
		//		result = 
        //    }
        //} else {
        //    logger.debug("New photo is present. Saving");
        //    result.setData(photo.getBytes());
        //}
        //return photoRepo.save(result);


		//try {
			if (!Files.exists(filePath)) {
				Files.createFile(filePath);
			} else {
				log.info("File: " + filePath + " already exists");
				return filePath;
			}
		//} catch (FileAlreadyExistsException e) {
			//throw new AudioDataDownloadingException(e);
		//} catch (IOException e) {
			//throw new AudioDataDownloadingException(e);
		//}

		int bufferSize = 1024;
		byte[] buffer  = new byte[bufferSize];
		int bytesRead = 0;

		try (BufferedInputStream input =
					new BufferedInputStream(fileURL.openStream());
				FileOutputStream output =
					new FileOutputStream(filePath.toString())) {
			while ((bytesRead = input.read(buffer, 0, bufferSize)) != -1)
				output.write(buffer, 0, bytesRead);
		}
		//catch (FileNotFoundException e) {
		//	throw new AudioDataDownloadingException(e);
		//} catch (IOException e) {
		//	throw new AudioDataDownloadingException(e);
		//}
		return filePath;

	}

	public Resource getCover(Long id) {
		Resource file = null;
		Cover cover = coverRepo.findById(id).get();
		try {
			file = new UrlResource(Paths.get(cover.getUrl()).toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return file;
	}


}
