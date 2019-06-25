package com.tourism.model;

import java.util.List;

import com.tourism.model.BaseRequestResponse.BaseResponse;

public interface FetchCruiseRequestResponse {

	public class FetchCruiseResponse extends BaseResponse {

		private List<CruiseResponse> cruises;

		public List<CruiseResponse> getCruises() {
			return cruises;
		}

		public void setCruises(List<CruiseResponse> cruises) {
			this.cruises = cruises;
		}

		@Override
		public String toString() {
			return "CruiseResponse [cruises=" + cruises + "]";
		}
	}

	public class CruiseResponse {

		private Integer id;

		private String name;

		private String description;

		private String encodedImage;

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

		public String getAdditionalLink() {
			return additionalLink;
		}

		public void setAdditionalLink(String additionalLink) {
			this.additionalLink = additionalLink;
		}

		@Override
		public String toString() {
			return "CruiseResponse [id=" + id + ", name=" + name + ", description=" + description + ", encodedImage="
					+ encodedImage + ", additionalLink=" + additionalLink + "]";
		}

	}
}
