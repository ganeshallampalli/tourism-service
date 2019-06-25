package com.tourism.model;

import java.util.List;

import com.tourism.model.BaseRequestResponse.BaseResponse;

public interface FetchThingsToDoRequestResponse {

	public class FetchThingsToDoResponse extends BaseResponse {

		private List<ThingsToDoResponse> thingsToDo;

		public List<ThingsToDoResponse> getThingsToDo() {
			return thingsToDo;
		}

		public void setThingsToDo(List<ThingsToDoResponse> thingsToDo) {
			this.thingsToDo = thingsToDo;
		}

		@Override
		public String toString() {
			return "FetchThingsToDoResponse [thingsToDo=" + thingsToDo + "]";
		}

	}

	public class ThingsToDoResponse {

		private Integer id;

		private String name;

		private String description;

		private String encodedImage;

		private Double avgTimeSpent;

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

		public Double getAvgTimeSpent() {
			return avgTimeSpent;
		}

		public void setAvgTimeSpent(Double avgTimeSpent) {
			this.avgTimeSpent = avgTimeSpent;
		}

		public String getAdditionalLink() {
			return additionalLink;
		}

		public void setAdditionalLink(String additionalLink) {
			this.additionalLink = additionalLink;
		}

		@Override
		public String toString() {
			return "ThingsToDoResponse [id=" + id + ", name=" + name + ", description=" + description
					+ ", encodedImage=" + encodedImage + ", avgTimeSpent=" + avgTimeSpent + ", additionalLink="
					+ additionalLink + "]";
		}

	}
}
