package com.valtech.training.questionservice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.valtech.training.questionservice.entities.Question;
import com.valtech.training.questionservice.vos.QuestionVO;


@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {

	List<Question> findAllByTopic(String topic);

	
	@Query(value = "SELECT * FROM question WHERE topic = :topic ORDER BY RANDOM() LIMIT :number", nativeQuery = true)
	List<Question> findRandomQuestionsByTopic(@Param("topic") String topic, @Param("number") int number);

}
