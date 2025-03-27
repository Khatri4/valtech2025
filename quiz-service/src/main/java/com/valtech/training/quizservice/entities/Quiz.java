package com.valtech.training.quizservice.entities;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Quiz {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quiz_id")
	@SequenceGenerator(name = "quiz_id", sequenceName = "quizid", allocationSize = 1)
	private int id;
	private int numberOfQues;
	private String topic;
	
	
	@ElementCollection()
	@CollectionTable(name = "quiz_ques", joinColumns = @JoinColumn(name = "quizID"))
	private List<Integer> quesID; 
	
	@ElementCollection()
	@CollectionTable(name="quiz_results", joinColumns = @JoinColumn(name="quizID"))
	private List<String> answers;
	

	
	public Quiz() {}
	public Quiz(int numberOfQues, String topic) {
		super();
		this.numberOfQues = numberOfQues;
		this.topic = topic;
	}
	public Quiz(int numberOfQues, String topic, List<Integer> quesID) {
		super();
		this.numberOfQues = numberOfQues;
		this.topic = topic;
		this.quesID = quesID;
	}	
	public Quiz(int numberOfQues, String topic, List<Integer> quesID, List<String> answers) {
		super();
		this.numberOfQues = numberOfQues;
		this.topic = topic;
		this.quesID = quesID;
		this.answers = answers;
	}
	
	
	
	public List<String> getAnswers() {
		return answers;
	}
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	
	public List<Integer> getQuesID() {
		return quesID;
	}
	public void setQuesID(List<Integer> quesID) {
		this.quesID = quesID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumberOfQues() {
		return numberOfQues;
	}
	public void setNumberOfQues(int numberOfQues) {
		this.numberOfQues = numberOfQues;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	
	
}
