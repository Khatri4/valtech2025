package com.valtech.training.quizservice.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.quizservice.vos.QuizVO;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class QuizControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	TestRestTemplate restTemplate;
	
//	
//	@Test
//	void test() {
//		
//		String url = "http://localhost:"+port+"/api/v1/quiz/";
//		
//		QuizVO quizVO = restTemplate.postForObject(url, new QuizVO(0, 4, "GK", null), QuizVO.class);
//		QuizVO quizVO1 = restTemplate.postForObject(url, new QuizVO(0, 2, "GK", null), QuizVO.class);
//		QuizVO quizVO2= restTemplate.postForObject(url, new QuizVO(0, 3, "Java", null), QuizVO.class);
//		QuizVO quizVO3 = restTemplate.postForObject(url, new QuizVO(0, 5, "Java", null), QuizVO.class);
//		
//		assertEquals(4, quizVO.numberOfQues());
//		
//	}

	
	
	@Test
	void testAnswer() {
		String url =  "http://localhost:"+port+"/api/v1/quiz/takequiz/5";
		List<String> answers = new ArrayList<String>();
		answers.add("Blue");
		answers.add("Yellow");
		answers.add("Blue");
		answers.add("Red");
		
		
		QuizVO qvo = restTemplate.postForObject(url, answers, QuizVO.class);
		
		assertEquals(4, qvo.numberOfQues());

	}
}
