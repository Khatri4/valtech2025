package com.valtech.training.quizservice.service;

import java.util.List;

import com.valtech.training.quizservice.vos.QuestionVO;
import com.valtech.training.quizservice.vos.QuizVO;

public interface QuizService {

	QuizVO saveOrUpdateQuiz(QuizVO qvo);

	QuizVO getQuizById(int id);

	List<QuizVO> getAllQuizes();

	List<QuestionVO> getQuestionsForQuiz(int quizid);

	QuizVO takeQuiz(int quizId, List<String> answers);


}