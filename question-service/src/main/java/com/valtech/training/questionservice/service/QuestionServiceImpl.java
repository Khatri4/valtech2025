package com.valtech.training.questionservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.questionservice.entities.Question;
import com.valtech.training.questionservice.repos.QuestionRepo;
import com.valtech.training.questionservice.vos.QuestionVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public QuestionVO saveOrUpdateQuestion(QuestionVO qvo) {
		return QuestionVO.from(questionRepo.save(qvo.to()));
	}
	
	@Override
	public QuestionVO getQuestionById(int id) {
		return QuestionVO.from(questionRepo.getReferenceById(id));
	}
	
	@Override
	public List<QuestionVO> getQuestionByTopic(String topic) {
		return QuestionVO.from(questionRepo.findAllByTopic(topic));
	}
	
	@Override
	public List<QuestionVO> getAllQuestions(){
		return QuestionVO.from(questionRepo.findAll());
	}
	
	@Override
	public List<QuestionVO> getRandomQuestionByTopic(String topic, int number){
		return QuestionVO.from(questionRepo.findRandomQuestionsByTopic(topic, number));
	}
	
	
	@Override
	public List<QuestionVO> getQuestionsByListOfIds(List<Integer> ids){
		return QuestionVO.from(questionRepo.findAllById(ids));
	}
}
