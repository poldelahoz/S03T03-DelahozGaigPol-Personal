package model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Decor")
public class Decor extends Article{
	
	private Material material;
	
	public enum Material{
		Fusta,
		Plastic
	}
	
	public Decor() {
		super(0);
	}
	
	@JsonCreator
	public Decor(@JsonProperty("price") float price, @JsonProperty("material") Material material) {
		super(price);
		this.material = material;
	}
	
	@JsonGetter("material")
	public Material getHeight() {
		return material;
	}
	
	@JsonSetter("material")
	public void setHeight(Material material) {
		this.material = material;
	}
	
	@Override
	public String toString() {
		return "Material: " + material + " | Preu: " + this.df.format(this.getPrice());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Decor other = (Decor) obj;
		return Objects.equals(material, other.material) && this.getPrice() == other.getPrice();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(material, super.getPrice());
	}
}
