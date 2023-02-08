package controller;

import java.util.List;

import model.Article;
import model.Decor;
import model.Decor.Material;
import model.Florist;
import model.Flower;
import model.Ticket;
import model.Tree;
import persistance.FilePersistance;
import view.FloristView;

public class FloristController {
	
	private static FloristController instance;
	private FloristView view;
	private Florist model;
	
	private FloristController() {};
	
	public static FloristController getInstance() {
		if (instance == null) {
			instance = new FloristController();
		}
		return instance;
	}
	
	public static FloristController getInstance(Florist model, FloristView view) {
		if (instance == null) {
			instance = new FloristController();
			instance.setModel(model);
			instance.setView(view);
		}
		return instance;
	}
	
	public void setModel(Florist model){
		this.model = model;     
	}
	
	public void setView(FloristView view){
		this.view = view;     
	}
	
	public Florist getModel(){
		return model;     
	}
	
	public void setFloristName(String name) {
		model.setName(name);
		FilePersistance.update(model);
	}

	public String getFloristName(){
	   return model.getName();       
	}
	
	public List<Ticket> getTickets(){
	   return model.getTickets();       
	}
	
	public void addTree() {
		Tree tree = view.getTree();
		addArticle(tree);
	}
	
	public void addFlower() {
		Flower flower = view.getFlower();
		addArticle(flower);
	}
	
	public void addDecor() {
		Decor decor = view.getDecor();
		addArticle(decor);
	}
	
	private void addArticle(Article article) {
		List<Article> articles = model.getArticles();
		articles.add(article);
		model.setArticles(articles);
		System.out.println("Article afegit correctament.");
		FilePersistance.update(model);
	}
	
	public void removeTree() {
		Tree tree = view.getTree();
		removeArticle(tree);
	}
	
	public void removeFlower() {
		Flower flower = view.getFlower();
		removeArticle(flower);
	}
	
	public void removeDecor() {
		Decor decor = view.getDecor();
		removeArticle(decor);
	}
	
	private void removeArticle(Article article) {
		List<Article> articles = model.getArticles();
		if(articles.remove(article)) {
			model.setArticles(articles);
			System.out.println("Article eliminat correctament.");
			FilePersistance.update(model);
		}else {
			System.err.println("No s'ha pogut eliminar l'article perquè no existeix en aquesta floristeria.");
		}
	}
	
	public void printStock() {
		view.printStock(model.getArticles());
	}
	
	public double getFloristValue() {
		double value = 0;
		List<Article> articles = model.getArticles();
		for(Article article : articles)
			value += article.getPrice();
		return value;
	}
	
	public void addTicket() {
		Ticket ticket = view.getTicket(model.getArticles());
		List<Ticket> tickets = model.getTickets();
		tickets.add(ticket);
		model.setTickets(tickets);
		FilePersistance.update(model);
	}
	
	public void printTickets() {
		view.printTickets(model.getTickets());
	}
	
	public double getTotalBilled() {
		double value = 0;
		List<Ticket> tickets = model.getTickets();
		for(Ticket ticket : tickets)
			value += ticket.getTotalPrice();
		return value;
	}
	
	public void addDemoData() {
		Florist florist = new Florist();
		setModel(florist);
		String name = "Test";
		setFloristName(name);
		
		List<Article> articles = model.getArticles();
		Tree tree = new Tree(12.50f, 1.50f);
		articles.add(tree);
		Flower flower = new Flower(2.50f, "Vermell");
		articles.add(flower);
		Decor decor = new Decor(42.50f, Material.Fusta);
		articles.add(decor);
		model.setArticles(articles);
		
		Ticket ticket = new Ticket();
		ticket.addArticle(tree, 2);
		ticket.addArticle(flower, 1);
		List<Ticket> tickets = model.getTickets();
		tickets.add(ticket);
		model.setTickets(tickets);
		
		FilePersistance.update(model);
	}
}
