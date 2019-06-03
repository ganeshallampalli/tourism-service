package com.tourism.model;

import java.util.List;

import com.tourism.model.BaseRequestResponse.BaseRequest;
import com.tourism.model.BaseRequestResponse.BaseResponse;

public interface CreateCruiseRequestResponse {

	public class CreateCruiseRequest extends BaseRequest {

		private String name;

		private String description;

		private List<String> encodedImages;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public List<String> getEncodedImages() {
			return encodedImages;
		}

		public void setEncodedImages(List<String> encodedImages) {
			this.encodedImages = encodedImages;
		}

		@Override
		public String toString() {
			return "CreateCruiseRequest [name=" + name + ", description=" + description + ", encodedImages="
					+ encodedImages + "]";
		}
	}

	public class CreateCruiseResponse extends BaseResponse {

		private Integer id;

		private String name;

		private String description;

		private List<String> encodedImages;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public List<String> getEncodedImages() {
			return encodedImages;
		}

		public void setEncodedImages(List<String> encodedImages) {
			this.encodedImages = encodedImages;
		}
	}

}
