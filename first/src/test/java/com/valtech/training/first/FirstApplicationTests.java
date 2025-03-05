package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.entities.Question;
import com.valtech.training.first.services.QuestionService;

@SpringBootTest
@Transactional(propagation = Propagation.REQUIRED)
class FirstApplicationTests {

	@Autowired
	private Arithmetic arithmetic;
	
	@Autowired
	private SimpleInterest simpleInterest;
	
	@Autowired
	private QuestionService questionService;
	
	@Test
	void testArithmetic() {
		assertEquals(10, arithmetic.add(4, 6));
		assertEquals(200, simpleInterest.compute(200, 20, 5));
	}
	
	@Test
	@Rollback
	void questionService() {
		initData();
		assertEquals(6, questionService.countByTopic("GK"));
		assertEquals(6, questionService.countByTopic("Java"));
		assertEquals(2, questionService.countByTopicAndQuestionTextContainsIgnoreCase("Java", "Exception"));
		assertEquals(3, questionService.countByTopicAndQuestionTextContainsIgnoreCase("Java", "Interface"));
		assertEquals(5, questionService.findAllByTopic("GK", 0, 5).size());
		assertEquals(1, questionService.findAllByTopic("GK", 1, 5).size());
	}
	
	
	
	void initData() {
//		System.out.println("Question Service Class Name = " + questionService.getClass().getName());
//		long count = questionService.count();
//		if(count != 0) return;
		Question q = questionService.saveQuestion(new Question("What is the color of sky ?", "Red", "Blue", "White", "Orange", "Blue", "GK"));
		questionService.saveQuestion(new Question("What is the color of Mars ?", "Red", "Blue", "White", "Orange", "Red", "GK"));
		questionService.saveQuestion(new Question("What is the color of Moon ?", "Red", "Blue", "White", "Orange", "White", "GK"));
		questionService.saveQuestion(new Question("What is the color of Jupiter ?", "Red", "Blue", "White", "Yellow", "Yellow", "GK"));
		questionService.saveQuestion(new Question("What is the color of Saturn ?", "Red", "Blue", "White", "Orange", "Blue", "GK"));
		questionService.saveQuestion(new Question("What is the color of Venus ?", "Red", "Blue", "White", "Orange", "White", "GK"));
		
		
		questionService.saveQuestion(new Question("What is the super class of exceptions ?", "Objcet", "Exception", "Throwable", "Error", "Throwable", "Java"));
		questionService.saveQuestion(new Question("Which class used to create dynamic string ?", "String", "DynamicString", "StringBuilder", "Builder", "StringBuilder", "Java"));
		questionService.saveQuestion(new Question("How many methods are there in marker interface ?", "None", "One", "Two", "Many", "None", "Java"));
		questionService.saveQuestion(new Question("How many methods are there in functional interface ?", "None", "One", "Two", "Many", "One", "Java"));
		questionService.saveQuestion(new Question("Can an interface have private method ?", "yes", "no", "may be", "no methods can be there in interface", "yes", "Java"));
		questionService.saveQuestion(new Question("Which subclass of exception is not checked by the compiler ?", "Exception", "Error", "RuntimeException", "Many", "None", "Java"));
		
//		assertTrue(q.getId()>0);
//		assertEquals(count+1, questionService.count());
	}

}
