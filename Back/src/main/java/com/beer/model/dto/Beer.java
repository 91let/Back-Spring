package com.beer.model.dto;

public class Beer {
	private int beerId;
	private String beerName;
	private String imgUrl;
	private String brewer;
	private String category;
	private String nation;
	private String alcohol;
	private String description;
	
	Beer(){}

	public int getBeerId() {
		return beerId;
	}

	public void setBeerId(int beerId) {
		this.beerId = beerId;
	}

	public String getBeerName() {
		return beerName;
	}

	public void setBeerName(String beerName) {
		this.beerName = beerName;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getBrewer() {
		return brewer;
	}

	public void setBrewer(String brewer) {
		this.brewer = brewer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Beer [beerId=" + beerId + ", beerName=" + beerName + ", imgUrl=" + imgUrl + ", brewer=" + brewer
				+ ", category=" + category + ", nation=" + nation + ", alcohol=" + alcohol + ", description="
				+ description + "]";
	}
	
}
