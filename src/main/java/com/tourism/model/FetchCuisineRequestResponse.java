package com.tourism.model;

import java.util.List;

import com.tourism.model.BaseRequestResponse.BaseResponse;

public interface FetchCuisineRequestResponse {

	public class FetchCuisineResponse extends BaseResponse {

		private List<CuisineRespone> cuisines;

		public List<CuisineRespone> getCuisines() {
			return cuisines;
		}

		public void setCuisines(List<CuisineRespone> cuisines) {
			this.cuisines = cuisines;
		}

		@Override
		public String toString() {
			return "FetchCuisineResponse [cuisines=" + cuisines + "]";
		}
	}

	public class CuisineRespone {

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
			return "CuisineRespone [id=" + id + ", name=" + name + ", description=" + description + ", encodedImage="
					+ encodedImage + ", cost=" + cost + ", additionalLink=" + additionalLink + "]";
		}

	}
}
