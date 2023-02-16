package com.florist.models;

import jakarta.persistence.Entity;

@Entity
public class Tree extends Article{
	
	private float height;
	
	public Tree() {
		super(0);
	}
	
	public Tree(float price, float height) {
		super(price);
		this.height = height;
	}
	
	public float getHeight() {
		return height;
	}
	
	public void setHeight(float height) {
		this.height = height;
	}

	public String toString() {
		return "Tipus: Tree | Altura: " + height + " | Preu: " + this.df.format(this.getPrice());
	}
	
}
