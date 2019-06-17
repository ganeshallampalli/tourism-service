package com.tourism.datamodel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tourism.datamodel.Feedback;

@Repository
public interface FeedbackRepostory extends CrudRepository<Feedback, Integer> {

	@SuppressWarnings("unchecked")
	Feedback save(Feedback feedback);
	
	List<Feedback> findAll();
}
