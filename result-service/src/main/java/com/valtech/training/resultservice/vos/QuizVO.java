package com.valtech.training.resultservice.vos;

import java.util.List;

public record QuizVO(int id, int numberOfQues, String topic, List<Integer> quesID, List<String> answers) {

}
