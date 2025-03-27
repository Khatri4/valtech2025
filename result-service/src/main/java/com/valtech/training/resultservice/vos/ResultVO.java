package com.valtech.training.resultservice.vos;

import com.valtech.training.resultservice.entities.Result;

public record ResultVO(int id, int quizId, int score) {

	public static ResultVO from(Result res) {
		return new ResultVO(res.getId(), res.getQuizId(), res.getScore());
	}
	
	public Result to() {
		return new Result(quizId, score);
	}
}
