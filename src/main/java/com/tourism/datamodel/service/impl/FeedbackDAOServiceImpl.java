package com.tourism.datamodel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.datamodel.Feedback;
import com.tourism.datamodel.repository.FeedbackRepostory;
import com.tourism.datamodel.service.FeedbackDAOService;
import com.tourism.model.FeedBackRequestResponse.FeedBackRequest;
import com.tourism.model.FeedBackRequestResponse.FeedBackResponse;

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
				feedBackResponse.setMessage("Saved Successfully");
			}
		} catch (Exception e) {
			feedBackResponse.setCode("1006");
			feedBackResponse
					.setMessage("It seems that there is an issue while submitting the feedback. Please try again");
		}
		return feedBackResponse;
	}
}
