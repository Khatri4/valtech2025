package com.valtech.training.quizservice.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.quizservice.vos.QuestionVO;

@SpringBootTest
class QuestionClientTest {

	@Autowired
	QuestionClient quesClient;
	
	@Autowired
	private QuizService quizService;

	
	
	@Test
	void test() {
		assertEquals(3, quesClient.getAllQuestionByTopic("GK", 3).size());
		System.out.println("GK questions"+ quesClient.getAllQuestionByTopic("GK", 3));
		System.out.println("====================================");
		System.out.println("GK questions"+ quesClient.getAllQuestionByTopic("GK", 3));
		System.out.println("=================================");
		assertEquals(2, quesClient.getAllQuestionByTopic("Java", 2).size());
//		System.out.println(quesClient.getAllQuestionByTopic("Java", 2));
		
	}
	
	
	@Test
	void questionsTest() {
		
		
		List<Integer> id = new ArrayList<Integer>();
		id.add(1);
		id.add(2);
		id.add(11);
		System.out.println(quesClient.getQuestionsByIds(id));
	}
	
}
