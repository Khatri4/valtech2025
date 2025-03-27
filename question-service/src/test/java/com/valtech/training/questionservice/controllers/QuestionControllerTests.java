package com.valtech.training.questionservice.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.questionservice.vos.QuestionVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class QuestionControllerTests {
	
	@LocalServerPort
	private Integer port;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void addQuestions() {
		String url = "http://localhost:"+port+"/api/v1/question/";
		List ques = restTemplate.getForObject(url,List.class);
		if(ques.size()==0) {
			System.err.println("Adding questions.........");
			
			QuestionVO ques1 = restTemplate.postForObject(url, new QuestionVO(0, "What is the color of sky ?", "Red", "Blue", "White", "Orange", "Blue", "GK"), QuestionVO.class);
			QuestionVO ques2 = restTemplate.postForObject(url, new QuestionVO(0, "What is the color of Mars ?", "Red", "Blue", "White", "Orange", "Red", "GK"), QuestionVO.class);
			QuestionVO ques3 = restTemplate.postForObject(url, new QuestionVO(0, "What is the color of Moon ?", "Red", "Blue", "White", "Orange", "White", "GK"), QuestionVO.class);
			QuestionVO ques4 = restTemplate.postForObject(url, new QuestionVO(0, "What is the color of Jupiter ?", "Red", "Blue", "White", "Yellow", "Yellow", "GK"), QuestionVO.class);
			QuestionVO ques5 = restTemplate.postForObject(url, new QuestionVO(0, "What is the color of Saturn ?", "Red", "Blue", "White", "Orange", "Blue", "GK"), QuestionVO.class);
			QuestionVO ques6 = restTemplate.postForObject(url, new QuestionVO(0, "What is the color of Venus ?", "Red", "Blue", "White", "Orange", "White", "GK"), QuestionVO.class);
			
			
			
			QuestionVO ques7 = restTemplate.postForObject(url, new QuestionVO(0, "What is the super class of exceptions ?", "Objcet", "Exception", "Throwable", "Error", "Throwable", "Java"), QuestionVO.class);
			QuestionVO ques8 = restTemplate.postForObject(url, new QuestionVO(0 ,"Which class used to create dynamic string ?", "String", "DynamicString", "StringBuilder", "Builder", "StringBuilder", "Java"), QuestionVO.class);
			QuestionVO ques9 = restTemplate.postForObject(url, new QuestionVO(0, "How many methods are there in marker interface ?", "None", "One", "Two", "Many", "None", "Java"), QuestionVO.class);
			QuestionVO ques10 = restTemplate.postForObject(url, new QuestionVO(0, "How many methods are there in functional interface ?", "None", "One", "Two", "Many", "One", "Java"), QuestionVO.class);
			QuestionVO ques11 = restTemplate.postForObject(url, new QuestionVO(0, "Can an interface have private method ?", "yes", "no", "may be", "no methods can be there in interface", "yes", "Java"), QuestionVO.class);
			QuestionVO ques12 = restTemplate.postForObject(url, new QuestionVO(0, "Which subclass of exception is not checked by the compiler ?", "Exception", "Error", "RuntimeException", "Many", "None", "Java"), QuestionVO.class);
			
		}
	}

}
