package com.valtech.training.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.entities.Question;
import com.valtech.training.first.repos.QuestionRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public Question saveQuestion(Question question) {
		System.out.println("Question repo class = "+ questionRepo.getClass().getName());
		return questionRepo.save(question);
	}
	
	@Override
	public Question updateQuestion(Question question) {
		return questionRepo.save(question);
	}
	
	@Override
	public void deleteQuestion(Question question) {
		questionRepo.delete(question);
	}
	
	@Override
	public Question getQuestion(long id) {
		return questionRepo.getReferenceById(id);
	}
	
	@Override
	public List<Question> getAllQuestion() {
		return questionRepo.findAll();
	}
	
	@Override
	public long count() {
		return questionRepo.count();
	}

	@Override
	public List<Question> findAllByTopic(String topic) {
		return questionRepo.findAllByTopic(topic);
	}

	@Override
	public long countByTopic(String topic) {
		return questionRepo.countByTopic(topic);
	}

	@Override
	public long countByTopicAndQuestionTextContains(String topic, String keyword) {
		return questionRepo.countByTopicAndQuestionTextContains(topic, keyword);
	}

	@Override
	public long countByTopicAndQuestionTextContainsIgnoreCase(String topic, String keyword) {
		return questionRepo.countByTopicAndQuestionTextContainsIgnoreCase(topic, keyword);
	}

	@Override
	public List<Question> findAllByTopic(String topic, int page, int size) {
		return questionRepo.findAllByTopic(topic, Pageable.ofSize(size).withPage(page));
	}
}
