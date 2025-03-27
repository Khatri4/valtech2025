package com.valtech.training.streamingservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.streamingservice.repos.MovieRepo;
import com.valtech.training.streamingservice.vos.MovieVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepo movieRepo;
	
	@Override
	public MovieVO saveOrUpdateMovie(MovieVO mvo) {
		return MovieVO.from(movieRepo.save(mvo.to()));
	}
	
	@Override
	public MovieVO getMovie(long id) {
		return MovieVO.from(movieRepo.getReferenceById(id));
	}
	
	@Override
	public List<MovieVO> getAll(){
		return MovieVO.from(movieRepo.findAll());
	}
	
	@Override
	public List<MovieVO> getMoviesByGenre(String genre){
		return MovieVO.from(movieRepo.findAllByGenre(genre));
	}
	
	@Override
	public List<MovieVO> getMoviesByGenreAndLanguage(String genre, String lang){
		return MovieVO.from(movieRepo.findAllByGenreAndLanguage(genre, lang));
	}
}
