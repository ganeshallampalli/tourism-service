package com.tourism.datamodel.service;

import com.tourism.model.FeedBackRequestResponse.FeedBackRequest;
import com.tourism.model.FeedBackRequestResponse.FeedBackResponse;

public interface FeedbackDAOService {

	FeedBackResponse submitFeedback(FeedBackRequest feedBackRequest);
}
