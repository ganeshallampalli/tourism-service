package com.tourism.model;

import com.tourism.model.BaseRequestResponse.BaseRequest;
import com.tourism.model.BaseRequestResponse.BaseResponse;

public interface CreateCuisineRequestResponse {

	public class CreateCuisineRequest extends BaseRequest {

		private Integer id;

		private String name;

		private String description;

		private String encodedImage;

		private Double cost;

		private String additionalLink;

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

		public String getEncodedImage() {
			return encodedImage;
		}

		public void setEncodedImage(String encodedImage) {
			this.encodedImage = encodedImage;
		}

		public Double getCost() {
			return cost;
		}

		public void setCost(Double cost) {
			this.cost = cost;
		}

		public String getAdditionalLink() {
			return additionalLink;
		}

		public void setAdditionalLink(String additionalLink) {
			this.additionalLink = additionalLink;
		}

		@Override
		public String toString() {
			return "CreateCuisineRequest [id=" + id + ", name=" + name + ", description=" + description
					+ ", encodedImage=" + encodedImage + ", cost=" + cost + ", additionalLink=" + additionalLink + "]";
		}

	}

	public class CreateCuisineResponse extends BaseResponse {
	}

}
