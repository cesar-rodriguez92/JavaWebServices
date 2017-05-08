package com.crodriguezt.inout3;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "food")
public class FoodBean {

	private String name;
	private String price;
	private String description;
	private String calories;
	
	
	public FoodBean(){}
	
	public FoodBean(String name, String price, String description, String calories){
		this.name=name;
		this.price=price;
		this.description=description;
		this.calories=calories;
	}

	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}
	@XmlElement
	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	public String getCalories() {
		return calories;
	}
	@XmlElement
	public void setCalories(String calories) {
		this.calories = calories;
	}

}
