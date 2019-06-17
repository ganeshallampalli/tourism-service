package com.tourism.datamodel.service;

import com.tourism.model.FeedBackRequestResponse.FeedBackRequest;
import com.tourism.model.FeedBackRequestResponse.FeedBackResponse;
import com.tourism.model.FetchFeedBackRequestResponse.FetchFeedBackResponse;

public interface FeedbackDAOService {

	FeedBackResponse submitFeedback(FeedBackRequest feedBackRequest);

	FetchFeedBackResponse getAllFeedbacks();
}
