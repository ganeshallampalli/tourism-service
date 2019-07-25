package com.tourism.model;

import com.tourism.model.BaseRequestResponse.BaseRequest;
import com.tourism.model.BaseRequestResponse.BaseResponse;

public interface CreateToDoRequestResponse {

	public class CreateToDoRequest extends BaseRequest {

		private String title;

		private Boolean completed;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Boolean getCompleted() {
			return completed;
		}

		public void setCompleted(Boolean completed) {
			this.completed = completed;
		}

		@Override
		public String toString() {
			return "CreateToDoRequest [title=" + title + ", completed=" + completed + "]";
		}

	}

	public class CreateToDoResponse extends BaseResponse {
	}

}
