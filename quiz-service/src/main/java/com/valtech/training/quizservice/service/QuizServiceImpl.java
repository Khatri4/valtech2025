package com.valtech.training.quizservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.quizservice.entities.Quiz;
import com.valtech.training.quizservice.repos.QuizRepo;
import com.valtech.training.quizservice.vos.QuestionVO;
import com.valtech.training.quizservice.vos.QuizVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	private QuestionClient queClient;
	
	
	
	@Override
	public QuizVO saveOrUpdateQuiz(QuizVO qvo) {
		
		Quiz quiz = qvo.to();
		String topic = quiz.getTopic();
		int number = quiz.getNumberOfQues();
		List<QuestionVO> randomQuestions = queClient.getAllQuestionByTopic(topic, number);
		List<Integer> ids = randomQuestions.stream().map(q -> q.id()).collect(Collectors.toList());
		
		
		quiz.setTopic(topic);
		quiz.setNumberOfQues(number);
		quiz.setQuesID(ids);
		quiz.setAnswers(qvo.answers());
		
		return QuizVO.from(quizRepo.save(quiz));
	}
	
	
	@Override
	public QuizVO takeQuiz(int quizId, List<String> answers) {
		Quiz quiz = quizRepo.getReferenceById(quizId);
		quiz.setAnswers(answers);
		quiz = quizRepo.save(quiz);
		return QuizVO.from(quiz);
	}
	
	@Override
	public QuizVO getQuizById(int id) {
		return QuizVO.from(quizRepo.getReferenceById(id));
	}
	
	@Override
	public List<QuizVO> getAllQuizes(){
		return QuizVO.from(quizRepo.findAll());
	}
	
	@Override
	public List<QuestionVO> getQuestionsForQuiz(int quizid){
		Quiz quiz = quizRepo.getReferenceById(quizid);
		return queClient.getQuestionsByIds(quiz.getQuesID());
	}


}
