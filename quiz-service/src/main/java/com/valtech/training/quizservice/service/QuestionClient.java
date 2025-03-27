package com.valtech.training.quizservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.training.quizservice.vos.QuestionVO;
import com.valtech.training.quizservice.vos.QuizVO;

@Component
public class QuestionClient {
	
	public List<QuestionVO> getAllQuestionByTopic(String topic, int number){
		RestTemplate temp = new RestTemplate();
		String url = "http://localhost:9040/api/v1/question/random/"+topic+"/"+number;
		List<QuestionVO> ques = Arrays.asList(temp.getForObject(url, QuestionVO[].class)) ;
		
		List<Integer> ids = ques.stream().map(q -> q.id()).collect(Collectors.toList());
		
		System.out.println("========>>>>>>>>>>>>>"+ids);
		return ques;
	}
	
	
	public List<QuestionVO> getQuestionsByIds(List<Integer> ids){
		RestTemplate temp = new RestTemplate();
		String url = "http://localhost:9040/api/v1/question/ques/"+ids.stream().map(String::valueOf).collect(Collectors.joining(","));
		
		List<QuestionVO> questions = Arrays.asList(temp.getForObject(url, QuestionVO[].class));
		
		return questions;
		
	}

}
