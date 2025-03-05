package com.valtech.training.first.services;

import java.util.List;

import com.valtech.training.first.entities.Question;

public interface QuestionService {

	long count();
	
	Question saveQuestion(Question question);

	Question updateQuestion(Question question);

	void deleteQuestion(Question question);

	Question getQuestion(long id);

	List<Question> getAllQuestion();
	
	List<Question> findAllByTopic(String topic);
	
	List<Question> findAllByTopic(String topic, int page, int size);

	long countByTopic(String topic);

	long countByTopicAndQuestionTextContains(String topic, String keyword);

	long countByTopicAndQuestionTextContainsIgnoreCase(String topic, String keyword);

}