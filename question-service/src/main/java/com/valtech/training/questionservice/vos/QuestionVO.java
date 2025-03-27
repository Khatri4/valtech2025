package com.valtech.training.questionservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.questionservice.entities.Question;

public record QuestionVO(int id, String questionText, String option1, String option2, String option3, String option4, String correctOption, String topic) {

	
	public static QuestionVO from(Question question) {
		return new QuestionVO(question.getId(), question.getQuestionText(), question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4(), question.getCorrectOption(), question.getTopic());
	}
	
	public Question to() {
		return new Question(questionText, option1, option2, option3, option4, correctOption, topic);
	}
	
	public static List<QuestionVO> from(List<Question> question){
		return question.stream().map(que -> QuestionVO.from(que)).collect(Collectors.toList());
	}
}
