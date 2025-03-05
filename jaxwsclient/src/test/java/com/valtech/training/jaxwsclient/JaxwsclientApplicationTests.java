package com.valtech.training.jaxwsclient;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.jaws.HelloWorld;
import com.valtech.training.jaws.Movie;
import com.valtech.training.jaws.webservices.MovieServiceWS;

@SpringBootTest
class JaxwsclientApplicationTests {
	
	@Autowired
	private MovieServiceWS movieServiceWS;
	
	@Autowired
	private HelloWorld helloWorld;

	@Test
	void contextLoads() {
		System.out.println(helloWorld.hello("Jax ws"));
		movieServiceWS.createMovie(new Movie(1, "Jab tak hain Jaan", "Rom", "hindi", List.of("Shah Rukh Khan")));
		movieServiceWS.createMovie(new Movie(2, "Hey Baby", "Rom-Com", "hindi", List.of("Akshay Kumar", "Ritesh Deshmukh")));
		System.out.println(movieServiceWS.getAllMovies());
	}

}
