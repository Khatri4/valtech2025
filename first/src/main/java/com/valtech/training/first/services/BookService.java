package com.valtech.training.first.services;

import java.util.List;
import java.util.Set;

import com.valtech.training.first.dtos.BookInfoDTO;
import com.valtech.training.first.entities.Book;
import com.valtech.training.first.entities.Publisher;

public interface BookService {

	List<Book> getAllBooks();

	List<Book> getBooksByYearBetween(int i, int j);

	List<Book> getBooksByPriceGreaterThan(int i);

	List<Integer> findAllPriceByAuthorsId(int i);

	List<BookInfoDTO> getBookInfoByAuthor(int i);

}