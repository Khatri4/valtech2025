package com.valtech.training.quizservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.quizservice.entities.Quiz;

public record QuizVO(int id, int numberOfQues, String topic, List<Integer> quesID, List<String> answers) {

	public static QuizVO from(Quiz q) {
		return new QuizVO(q.getId(), q.getNumberOfQues(), q.getTopic(), q.getQuesID(), q.getAnswers());
	}
	
	public static List<QuizVO> from(List<Quiz> quiz){
		return quiz.stream().map(q -> QuizVO.from(q)).collect(Collectors.toList()); 
	}
	
	public Quiz to() {
		Quiz quiz = new Quiz(numberOfQues, topic);
		quiz.setAnswers(answers);
		return quiz;
	}
}
