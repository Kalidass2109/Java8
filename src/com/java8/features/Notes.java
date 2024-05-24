package com.java8.practice;

public class Notes {
	
	Integer tagId;
	String name;
	Integer price;

	public Notes(Integer tagId, String name, Integer price) {
		super();
		this.tagId = tagId;
		this.name = name;
		this.price = price;
	}
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

}
