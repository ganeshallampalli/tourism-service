package com.tourism.datamodel.repository;

import com.tourism.datamodel.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepostory extends CrudRepository<Feedback, Integer> {

	@SuppressWarnings("unchecked")
	Feedback save(Feedback feedback);
}
