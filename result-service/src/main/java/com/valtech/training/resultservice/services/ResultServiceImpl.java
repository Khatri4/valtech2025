package com.valtech.training.resultservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.resultservice.entities.Result;
import com.valtech.training.resultservice.repos.ResultRepo;
import com.valtech.training.resultservice.vos.ResultVO;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultRepo resultRepo;
	
	@Autowired
	private QuizClient quizClient;
	
	@Autowired
	private QuestionClient queClient;
	
	@Override
	public ResultVO testResults(int quizId) {
		List<String> submittedAnswers = quizClient.getSubmittedtAnswers(quizId);
		List<Integer> quesIds = quizClient.getQuesIdsFromQuiz(quizId);
		List<String> rightAnswers = queClient.getAnswersFromQuestionIds(quesIds);
		
		
		int score = 0;
		for(int i=0; i< rightAnswers.size(); i++) {
			if(rightAnswers.get(i).equalsIgnoreCase(submittedAnswers.get(i))) {
				score++;
			}
			
		}
		
		Result res = new Result();
		res.setQuizId(quizId);
		res.setScore(score);
		
		return ResultVO.from(resultRepo.save(res));
	}
}
