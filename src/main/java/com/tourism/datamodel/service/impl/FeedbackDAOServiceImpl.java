package com.tourism.datamodel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.datamodel.Feedback;
import com.tourism.datamodel.repository.FeedbackRepostory;
import com.tourism.datamodel.service.FeedbackDAOService;
import com.tourism.model.FeedBackRequestResponse.FeedBackRequest;
import com.tourism.model.FeedBackRequestResponse.FeedBackResponse;
import com.tourism.model.FetchFeedBackRequestResponse.FeedbackResponse;
import com.tourism.model.FetchFeedBackRequestResponse.FetchFeedBackResponse;

@Service
public class FeedbackDAOServiceImpl implements FeedbackDAOService {

	@Autowired
	private FeedbackRepostory feedbackRepostory;

	@Override
	public FeedBackResponse submitFeedback(FeedBackRequest feedBackRequest) {
		FeedBackResponse feedBackResponse = new FeedBackResponse();

		Feedback feedback = new Feedback();
		feedback.setFullName(feedBackRequest.getFullName());
		feedback.setEmail(feedBackRequest.getEmail());
		feedback.setSubject(feedBackRequest.getSubject());
		feedback.setMessage(feedBackRequest.getMessage());

		try {
			feedback = feedbackRepostory.save(feedback);
			if (null == feedback) {
				feedBackResponse.setCode("1005");
				feedBackResponse.setMessage("Unexpected Error Occurred, Please try again");
			} else {
				feedBackResponse.setCode("200");
				feedBackResponse.setMessage("Thanks for your valuable feed back");
			}
		} catch (Exception e) {
			feedBackResponse.setCode("1006");
			feedBackResponse
					.setMessage("It seems that there is an issue while submitting the feedback. Please try again");
		}
		return feedBackResponse;
	}

	@Override
	public FetchFeedBackResponse getAllFeedbacks() {
		FetchFeedBackResponse fetchFeedBackResponse = new FetchFeedBackResponse();
		List<FeedbackResponse> feedbackResponses = new ArrayList<>();
		try {
			List<Feedback> feedbacks = feedbackRepostory.findAll();
			feedbacks.stream().forEach(feedback -> {
				FeedbackResponse feedbackResponse = new FeedbackResponse();
				feedbackResponse.setId(feedback.getId());
				feedbackResponse.setFullName(feedback.getFullName());
				feedbackResponse.setEmail(feedback.getEmail());
				feedbackResponse.setMessage(feedback.getMessage());
				feedbackResponse.setSubject(feedback.getSubject());
				feedbackResponses.add(feedbackResponse);
			});
			fetchFeedBackResponse.setFeedbackResponses(feedbackResponses);
			fetchFeedBackResponse.setCode("200");
			fetchFeedBackResponse.setMessage("Fetched successfully");
		} catch (Exception e) {
			fetchFeedBackResponse.setCode("2010");
			fetchFeedBackResponse
					.setMessage("It seems that there is an issue while fetching the data. Please try again");
		}
		return fetchFeedBackResponse;
	}
}
