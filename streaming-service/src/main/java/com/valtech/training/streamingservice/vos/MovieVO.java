package com.valtech.training.streamingservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.streamingservice.entities.Movie;

public record MovieVO(long id, String name, String genre, String language, int costPerView, long duration) {

	public static MovieVO from(Movie movie) {
		return new MovieVO(movie.getId(), movie.getName(), movie.getGenre(), movie.getLanguage(), movie.getCostPerView(), movie.getDuration());
	}
	
	public static List<MovieVO> from(List<Movie> m){
		return m.stream().map(mov -> MovieVO.from(mov)).collect(Collectors.toList());
	}
	
	public Movie to() {
		return new Movie(name, genre, language, duration, costPerView);
	}
}
