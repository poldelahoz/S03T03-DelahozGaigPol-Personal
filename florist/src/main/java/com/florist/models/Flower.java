package com.florist.models;

import jakarta.persistence.Entity;

@Entity
public class Flower extends Article{
	
	private String color;
	
	public Flower() {
		super(0);
	}
	
	public Flower(float price, String color) {
		super(price);
		this.color = color;
	}

	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString() {
		return "Tipus: Flower | Color: " + color + " | Preu: " + this.df.format(this.getPrice());
	}
}
