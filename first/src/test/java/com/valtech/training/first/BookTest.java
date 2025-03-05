package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.first.services.BookService;
import com.valtech.training.first.services.PublisherService;

@SpringBootTest
public class BookTest {
	
	@Autowired
	private PublisherService publisherService;
	
	@Autowired
	private BookService bookService;

	@Test
	void test() {
		assertEquals(3, publisherService.getAllPublishers().size());
		assertEquals(6, bookService.getAllBooks().size());
		assertEquals(5, bookService.getBooksByYearBetween(2000,2006).size());
		assertEquals(3, bookService.getBooksByPriceGreaterThan(100).size());
		assertEquals(2, bookService.findAllPriceByAuthorsId(1).size());
		System.err.println(bookService.findAllPriceByAuthorsId(1));
		System.err.println(bookService.getBookInfoByAuthor(2));
	}

}
