package com.valtech.training.quizservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.quizservice.service.QuizService;
import com.valtech.training.quizservice.vos.QuestionVO;
import com.valtech.training.quizservice.vos.QuizVO;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {

	
	@Autowired
	private QuizService quizService;
	
	
	@GetMapping("/")
	public List<QuizVO> getAllQuizes(){
		return quizService.getAllQuizes();
	}
	
	@GetMapping("/{id}")
	public QuizVO getQuizById(@PathVariable(name = "id") int id) {
		return quizService.getQuizById(id);
	}
	
	@GetMapping("/quizId/{quizId}")
	public List<QuestionVO> getQuestionsByQuiz(@PathVariable(name="quizId") int quizId) {
		return quizService.getQuestionsForQuiz(quizId);
	}
	
	
	@PostMapping("/")
	public QuizVO createQuiz(@RequestBody QuizVO quiz) {
		return quizService.saveOrUpdateQuiz(quiz);
	}
	
	
	@PostMapping("/takequiz/{quizId}")
	public QuizVO takeQuiz(@PathVariable("quizId") int quizId, @RequestBody List<String> answers) {
		return quizService.takeQuiz(quizId, answers);
	}
}
