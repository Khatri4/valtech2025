package com.valtech.training.streamingservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.streamingservice.services.MovieService;
import com.valtech.training.streamingservice.vos.MovieVO;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@PostMapping("/")
	public MovieVO saveMovie(@RequestBody MovieVO mvo) {
		return movieService.saveOrUpdateMovie(mvo);
	}
	
	@GetMapping("/")
	public List<MovieVO> getAllMovies(){
		return movieService.getAll();
	}
	
	@GetMapping("/{id}")
	public MovieVO getMovie(@PathVariable("id") long id){
		return movieService.getMovie(id);
	}
	
	@GetMapping("/genre/{genre}")
	public List<MovieVO> getMoviesByGenre(@PathVariable("genre") String genre ){
		return movieService.getMoviesByGenre(genre);
	}
	
	@GetMapping("/genre/{genre}/language/{lang}")
	public List<MovieVO> getMoviesByGenreAndLanguage(@PathVariable("genre") String genre, @PathVariable("lang") String lang){
		return movieService.getMoviesByGenreAndLanguage(genre, lang);
	}
	
	
	
	
}
