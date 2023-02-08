package model;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Ticket {
	
	private Map<Article, Integer> articles;
	private final Date created;
	private final DecimalFormat df = new DecimalFormat("0.00€");
	private final DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy HH:mm:ss");
	
	@JsonCreator
	public Ticket() {
		articles = new HashMap<Article, Integer>();
		created = new Date();
	}
	
	@JsonGetter("articles")
	public Map<Article, Integer> getArticles() {
		return articles;
	}
	
	@JsonSetter("articles")
	public void setArticles(Map<Article, Integer> articles) {
		this.articles = articles;
	}
	
	@JsonGetter("created")
	public Date getCreated() {
		return created;
	}
	
	public void addArticle(Article article, Integer quantity) {
		articles.put(article, quantity);
	}

	public double getTotalPrice() {
		double totalPrice = 0;
		for (Map.Entry<Article, Integer> e : articles.entrySet()) {
			for (int i = 0; i < e.getValue(); i++)
				totalPrice += e.getKey().getPrice();
		}
		return totalPrice;
	}
	
	@Override
	public String toString() {
		String result = "Ticket del " + dateFormat.format(created) + "\n";
		result += "Productes: \n";
		for (Map.Entry<Article, Integer> e : articles.entrySet()) {
			result += e.getKey().toString() + " | Quantitat: " + e.getValue() + "\n";
		}
		result += "Preu total: " + df.format(getTotalPrice()) + "\n";
		return result;
	}
}
