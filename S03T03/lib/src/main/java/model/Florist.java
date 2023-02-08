package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import persistance.ArticleStockDeserializer;

public class Florist {
	
	private String name;
	//private List<Article> articles;
	@JsonDeserialize(keyUsing = ArticleStockDeserializer.class)
	private Map<Article, Integer> articles;
	private List<Ticket> tickets;
	
	public Florist() {
		//this.articles = new ArrayList<Article>();
		articles = new HashMap<Article, Integer>();
		tickets = new ArrayList<Ticket>();
	}
	
	/*@JsonCreator
	public Florist(@JsonProperty("name") String name, @JsonProperty("articles") List<Article> articles, @JsonProperty("tickets") List<Ticket> tickets) {
		this.name = name;
		this.articles = articles;
		this.tickets = tickets;
	}*/
	
	@JsonCreator
	public Florist(@JsonProperty("name") String name, @JsonProperty("articles") Map<Article, Integer> articles, @JsonProperty("tickets") List<Ticket> tickets) {
		this.name = name;
		this.articles = articles;
		this.tickets = tickets;
	}
	
	@JsonGetter("name")
	public String getName() {
		return name;
	}
	
	@JsonSetter("name")
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonGetter("articles")
	public Map<Article, Integer> getArticles() {
		return articles;
	}
	
	@JsonSetter("articles")
	public void setArticles(Map<Article, Integer> articles) {
		this.articles = articles;
	}
	
	@JsonGetter("tickets")
	public List<Ticket> getTickets() {
		return tickets;
	}
	
	@JsonSetter("tickets")
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
}
