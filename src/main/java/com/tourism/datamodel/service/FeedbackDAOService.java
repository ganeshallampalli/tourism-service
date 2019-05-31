package com.tourism.datamodel.service;

import com.tourism.model.FeedBackResponse;
import com.tourism.model.FeedBackRequest;

public interface FeedbackDAOService {

	FeedBackResponse submitFeedback(FeedBackRequest feedBackRequest);
}
