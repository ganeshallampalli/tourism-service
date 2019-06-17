package com.tourism.model;

import java.util.List;

import com.tourism.model.BaseRequestResponse.BaseResponse;

public interface FetchFeedBackRequestResponse {

	public class FetchFeedBackResponse extends BaseResponse {

		private List<FeedbackResponse> feedbackResponses;

		public List<FeedbackResponse> getFeedbackResponses() {
			return feedbackResponses;
		}

		public void setFeedbackResponses(List<FeedbackResponse> feedbackResponses) {
			this.feedbackResponses = feedbackResponses;
		}

		@Override
		public String toString() {
			return "FetchFeedBackResponse [feedbackResponses=" + feedbackResponses + "]";
		}
	}

	public class FeedbackResponse {

		private Integer id;

		private String fullName;

		private String email;

		private String subject;

		private String message;

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return "FeedbackResponse [fullName=" + fullName + ", email=" + email + ", subject=" + subject + ", message="
					+ message + ", id=" + id + "]";
		}
	}
}
