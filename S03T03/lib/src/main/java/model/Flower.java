package model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Flower")
public class Flower extends Article{
	
	private String color;
	
	public Flower() {
		super(0);
	}
	
	@JsonCreator
	public Flower(@JsonProperty("price") float price, @JsonProperty("color") String color) {
		super(price);
		this.color = color;
	}

	@JsonGetter("color")
	public String getColor() {
		return color;
	}
	
	@JsonSetter("color")
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Tipus: Flower | Color: " + color + " | Preu: " + this.df.format(this.getPrice());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flower other = (Flower) obj;
		return Objects.equals(color, other.color) && this.getPrice() == other.getPrice();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(color, super.getPrice());
	}
}
