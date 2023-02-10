package model;

import java.text.DecimalFormat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ 
	  @Type(value = Tree.class, name = "Tree"), 
	  @Type(value = Flower.class, name = "Flower"),
	  @Type(value = Decor.class, name = "Decor")
	})
public abstract class Article{

	private float price;
	protected final DecimalFormat df = new DecimalFormat("0.00 €");
	
	@JsonCreator
	protected Article(float price) {
		this.price = price;
	}
	
	@JsonGetter("price")
	public double getPrice() {
		return price;
	}

	@JsonSetter("price")
	public void setPrice(float price) {
		this.price = price;
	}
	
}
