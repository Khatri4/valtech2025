package com.valtech.training.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.dtos.BookInfoDTO;
import com.valtech.training.first.entities.Book;
import com.valtech.training.first.repos.BookRepo;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	@Override
	public List<Book> getBooksByYearBetween(int i, int j) {
		return bookRepo.findAllByYearBetween(i, j);
	}

	@Override
	public List<Book> getBooksByPriceGreaterThan(int i) {
		return bookRepo.findAllByPriceGreaterThan(i);
	}
	
	@Override
	public List<Integer> findAllPriceByAuthorsId(int i) {
		return bookRepo.findAllPriceByAuthorsId(i);
	}
	
	public List<BookInfoDTO> getBookInfoByAuthor(int id){
		return bookRepo.getBookInfoByAuthor(id);
	}
	
}
