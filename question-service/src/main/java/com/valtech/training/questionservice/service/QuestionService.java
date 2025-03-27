package com.valtech.training.questionservice.service;

import java.util.List;

import com.valtech.training.questionservice.vos.QuestionVO;

public interface QuestionService {

	QuestionVO saveOrUpdateQuestion(QuestionVO qvo);

	QuestionVO getQuestionById(int id);

	List<QuestionVO> getQuestionByTopic(String topic);

	List<QuestionVO> getAllQuestions();

	List<QuestionVO> getRandomQuestionByTopic(String topic, int number);

	List<QuestionVO> getQuestionsByListOfIds(List<Integer> ids);

}