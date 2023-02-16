package com.florist.models;

import jakarta.persistence.Entity;

@Entity
public class Decor extends Article{
	
	private Material material;
	
	public enum Material{
		Fusta,
		Plastic
	}
	
	public Decor() {
		super(0);
	}
	
	public Decor(float price, Material material) {
		super(price);
		this.material = material;
	}
	
	public Material getMaterial() {
		return material;
	}
	
	public void setMaterial(Material material) {
		this.material = material;
	}
	
	@Override
	public String toString() {
		return "Tipus: Decor | Material: " + material + " | Preu: " + this.df.format(this.getPrice());
	}
}
