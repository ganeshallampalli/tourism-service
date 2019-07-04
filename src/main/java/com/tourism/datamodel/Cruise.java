package com.tourism.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cruise", schema = "public")
public class Cruise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String description;

	private String image;

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAdditionalLink() {
		return additionalLink;
	}

	public void setAdditionalLink(String additionalLink) {
		this.additionalLink = additionalLink;
	}

	@Override
	public String toString() {
		return "Cruise [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image
				+ ", additionalLink=" + additionalLink + "]";
	}

}
