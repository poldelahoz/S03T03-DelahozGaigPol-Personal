package com.florist.models;

import java.text.DecimalFormat;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Article {
	
	@Id
    private Integer articleId;
	
	@Column(nullable=false)
	private float price;
	
	@OneToMany(mappedBy = "article")
    Set<FloristArticle> stock;
	
	@OneToMany(mappedBy = "article")
    Set<TicketArticle> tickets;
	
	protected final DecimalFormat df = new DecimalFormat("0.00 €");
	
	public Article(float price) {
		this.price = price;
	}
	
	public Integer getId() {
	    return articleId;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
}
