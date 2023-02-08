package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import exception.EmptyFloristException;
import exception.NonExistantArticle;
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
	
	public void addTree() throws EmptyFloristException {
		if (model != null) {
			Tree tree = view.getTree();
			addArticle(tree);
		}else {
			throw new EmptyFloristException("No s'ha creat cap Floristeria. Primer de tot, afegeix-ne una.");
		}
	}
	
	public void addFlower() throws EmptyFloristException {
		if (model != null) {
			Flower flower = view.getFlower();
			addArticle(flower);
		}else {
			throw new EmptyFloristException("No s'ha creat cap Floristeria. Primer de tot, afegeix-ne una.");
		}
	}
	
	public void addDecor() throws EmptyFloristException {
		if (model != null) {
			Decor decor = view.getDecor();
			addArticle(decor);
		}else {
			throw new EmptyFloristException("No s'ha creat cap Floristeria. Primer de tot, afegeix-ne una.");
		}
	}
	
	private void addArticle(Article article) {
		Map<Article, Integer> articles = model.getArticles();
		Integer sotck = articles.putIfAbsent(article, 1);
		if(sotck != null) {
			sotck++;
			articles.put(article, sotck);
		}
		model.setArticles(articles);
		System.out.println("Article afegit correctament.");
		FilePersistance.update(model);
	}
	
	public void removeTree() throws EmptyFloristException, NonExistantArticle {
		if (model != null) {
			Tree tree = view.getTree();
			removeArticle(tree);
		}else {
			throw new EmptyFloristException("No s'ha creat cap Floristeria. Primer de tot, afegeix-ne una.");
		}
	}
	
	public void removeFlower() throws EmptyFloristException, NonExistantArticle {
		if (model != null) {
			Flower flower = view.getFlower();
			removeArticle(flower);
		}else {
			throw new EmptyFloristException("No s'ha creat cap Floristeria. Primer de tot, afegeix-ne una.");
		}
	}
	
	public void removeDecor() throws EmptyFloristException, NonExistantArticle {
		if (model != null) {
			Decor decor = view.getDecor();
			removeArticle(decor);
		}else {
			throw new EmptyFloristException("No s'ha creat cap Floristeria. Primer de tot, afegeix-ne una.");
		}
	}
	
	private void removeArticle(Article article) throws NonExistantArticle {
		Map<Article, Integer> articles = model.getArticles();
		Integer stock = articles.get(article);
		if(stock != null) {
			stock--;
			if (stock > 0) {
				articles.put(article, stock);
			}else {
				articles.remove(article);
			}
			model.setArticles(articles);
			System.out.println("Article eliminat correctament.");
			FilePersistance.update(model);
		}else {
			throw new NonExistantArticle("No s'ha pogut eliminar l'article perquè no existeix en aquesta floristeria.");
		}
	}
	
	public void printStock() {
		List<Article> articlesWoStock = model.getArticles().keySet().stream().collect(Collectors.toCollection(ArrayList::new));
		view.printStock(articlesWoStock);
	}
	
	public void printStockWithQuantities() {
		Map<Article, Integer> articles = model.getArticles();
		view.printStockWithQuantities(articles);
	}
	
	public double getFloristValue() throws EmptyFloristException {
		if (model != null) {
			double value = 0;
			Map<Article, Integer> articles = model.getArticles();
			for (Map.Entry<Article, Integer> e : articles.entrySet()) {
				value += e.getKey().getPrice()*e.getValue();
			}
			return value;
		}else {
			throw new EmptyFloristException("No s'ha creat cap Floristeria. Primer de tot, afegeix-ne una.");
		}
	}
	
	public void addTicket() throws EmptyFloristException {
		if (model != null) {
			List<Article> articlesWoStock = model.getArticles().keySet().stream().collect(Collectors.toCollection(ArrayList::new));
			Ticket ticket = view.getTicket(articlesWoStock);
			List<Ticket> tickets = model.getTickets();
			tickets.add(ticket);
			model.setTickets(tickets);
			FilePersistance.update(model);
		}else {
			throw new EmptyFloristException("No s'ha creat cap Floristeria. Primer de tot, afegeix-ne una.");
		}
	}
	
	public void printTickets() {
		view.printTickets(model.getTickets());
	}
	
	public double getTotalBilled() throws EmptyFloristException {
		if (model != null) {
			double value = 0;
			List<Ticket> tickets = model.getTickets();
			for(Ticket ticket : tickets)
				value += ticket.getTotalPrice();
			return value;
		}else {
			throw new EmptyFloristException("No s'ha creat cap Floristeria. Primer de tot, afegeix-ne una.");
		}
	}
	
	public void addDemoData() {
		Florist florist = new Florist();
		setModel(florist);
		String name = "Test";
		setFloristName(name);
		
		Map<Article, Integer> articles = model.getArticles();
		Tree tree = new Tree(10.00f, 1.50f);
		articles.put(tree, 1);
		Flower flower = new Flower(2.00f, "Vermell");
		articles.put(flower, 2);
		Decor decor = new Decor(40.00f, Material.Fusta);
		articles.put(decor, 3);
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
