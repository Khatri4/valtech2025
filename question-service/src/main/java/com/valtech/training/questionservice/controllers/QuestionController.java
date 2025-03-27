package com.valtech.training.questionservice.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.questionservice.service.QuestionService;
import com.valtech.training.questionservice.vos.QuestionVO;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/")
	public List<QuestionVO> getAllQuestions(){
		return questionService.getAllQuestions();
	}
	
	@GetMapping("/{id}")
	public QuestionVO getQuestion(@PathVariable(name="id") int id) {
		return questionService.getQuestionById(id);
	}
	
	@GetMapping("/topic/{topic}")
	public List<QuestionVO> getQuestionByTopic(@PathVariable(name="topic") String topic){
		return questionService.getQuestionByTopic(topic);
	}
	
	@GetMapping("/random/{topic}/{number}")
	public List<QuestionVO> getRandomQuestionByTopic(@PathVariable(name = "topic") String topic, @PathVariable(name="number") int number){
		return questionService.getRandomQuestionByTopic(topic, number);
	}
	
	@GetMapping("/ques/{ids}")
	public List<QuestionVO> getQuestionsByIds(@PathVariable("ids") String ids){
		List<Integer> id = Arrays.stream(ids.split(",")).map(Integer::parseInt).collect(Collectors.toList());
		return questionService.getQuestionsByListOfIds(id);
	}
	
	@PostMapping("/")
	public QuestionVO createQuestion(@RequestBody QuestionVO employeeVO) {
		return questionService.saveOrUpdateQuestion(employeeVO);
	}
}
