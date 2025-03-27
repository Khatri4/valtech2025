package com.valtech.training.streamingservice.services;

import java.util.List;

import com.valtech.training.streamingservice.vos.MovieVO;

public interface MovieService {

	MovieVO saveOrUpdateMovie(MovieVO mvo);

	MovieVO getMovie(long id);

	List<MovieVO> getAll();

	List<MovieVO> getMoviesByGenre(String genre);

	List<MovieVO> getMoviesByGenreAndLanguage(String genre, String lang);

}