package model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

public class Florist {
	
	private String name;
	private List<Article> articles;
	private List<Ticket> tickets;
	
	public Florist() {
		this.articles = new ArrayList<Article>();
		this.tickets = new ArrayList<Ticket>();
	}
	
	@JsonCreator
	public Florist(@JsonProperty("name") String name, @JsonProperty("articles") List<Article> articles, @JsonProperty("tickets") List<Ticket> tickets) {
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
	public List<Article> getArticles() {
		return articles;
	}
	
	@JsonSetter("articles")
	public void setArticles(List<Article> articles) {
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
