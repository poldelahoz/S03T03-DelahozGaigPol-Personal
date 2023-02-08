package model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Tree")
public class Tree extends Article{

	private float height;
	
	public Tree() {
		super(0);
	}
	
	@JsonCreator
	public Tree(@JsonProperty("price") float price, @JsonProperty("height") float height) {
		super(price);
		this.height = height;
	}
	
	@JsonGetter("height")
	public float getHeight() {
		return height;
	}
	
	@JsonSetter("height")
	public void setHeight(float height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Type: Tree | Altura: " + height + " | Preu: " + this.df.format(this.getPrice());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tree other = (Tree) obj;
		return Objects.equals(height, other.height) && this.getPrice() == other.getPrice();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(height, super.getPrice());
	}
}
