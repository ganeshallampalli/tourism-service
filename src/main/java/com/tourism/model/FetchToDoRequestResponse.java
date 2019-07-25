package com.tourism.model;

import java.util.List;

import com.tourism.model.BaseRequestResponse.BaseResponse;

public interface FetchToDoRequestResponse {

	public class FetchToDoResponse extends BaseResponse {

		private List<ToDoResponse> toDoResponses;

		public List<ToDoResponse> getToDoResponses() {
			return toDoResponses;
		}

		public void setToDoResponses(List<ToDoResponse> toDoResponses) {
			this.toDoResponses = toDoResponses;
		}

	}

	public class ToDoResponse {

		private Integer id;

		private String title;

		private Boolean completed;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

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
			return "ToDoResponse [id=" + id + ", title=" + title + ", completed=" + completed + "]";
		}

	}
}
