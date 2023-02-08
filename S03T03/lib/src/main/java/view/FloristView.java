package view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import exception.NonExistantArticle;
import model.Article;
import model.Decor;
import model.Decor.Material;
import util.Entry;
import model.Flower;
import model.Ticket;
import model.Tree;

public class FloristView {
	
	public Tree getTree() {
		float price = Entry.readFloat("Introdueix el preu de l'arbre: ");
		float height = Entry.readFloat("Introdueix l'altura de l'arbre: ");
		return new Tree(price, height);
	}
	
	public Flower getFlower() {
		float price = Entry.readFloat("Introdueix el preu de la flor: ");
		String color = Entry.readString("Introdueix el color de la flor: ");
		return new Flower(price, color);
	}
	
	public Decor getDecor() {
		float price = Entry.readFloat("Introdueix el preu de la decoració: ");
		String materialS = Entry.readString("Introdueix el material de la decoració (Fusta/Plastic): ");
		while(!materialS.toLowerCase().equals("fusta") && !materialS.toLowerCase().equals("plastic")){
			System.out.println("Només pot ser de fusta o plàstic.");
			materialS = Entry.readString("Introdueix el material de la decoració (Fusta/Plastic): ");
		}
		Material material;
		if (materialS.toLowerCase().equals("fusta"))
			material = Material.Fusta;
		else
			material = Material.Plastic;
		return new Decor(price, material);
	}
	
	public void printStock(List<Article> articles) {
		List<Tree> trees = articles.stream()
	            .filter(c -> c instanceof Tree)
	            .map(c -> (Tree) c)
	            .collect(Collectors.toList());
		System.out.println("ARBRES:");
		trees.forEach(System.out::println);
		System.out.println();
		
		List<Flower> flowers = articles.stream()
	            .filter(c -> c instanceof Flower)
	            .map(c -> (Flower) c)
	            .collect(Collectors.toList());
		System.out.println("FLORS:");
		flowers.forEach(System.out::println);
		System.out.println();
		
		List<Decor> decors = articles.stream()
	            .filter(c -> c instanceof Decor)
	            .map(c -> (Decor) c)
	            .collect(Collectors.toList());
		System.out.println("DECORACIÓ:");
		decors.forEach(System.out::println);
		System.out.println();
	}
	
	public void printStockWithQuantities(Map<Article, Integer> articles) {
		Map<Article, Integer> trees = articles.entrySet()
		        .stream().filter(c -> c.getKey() instanceof Tree)
		        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println("ARBRES:");
		trees.forEach( (a,b) -> System.out.println(a.toString() + " | Stock: " + b));
		System.out.println();
		
		Map<Article, Integer> flowers = articles.entrySet()
		        .stream().filter(c -> c.getKey() instanceof Flower)
		        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println("FLORS:");
		flowers.forEach( (a,b) -> System.out.println(a.toString() + " | Stock: " + b));
		System.out.println();
		
		Map<Article, Integer> decors = articles.entrySet()
		        .stream().filter(c -> c.getKey() instanceof Decor)
		        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println("DECORACIÓ:");
		decors.forEach( (a,b) -> System.out.println(a.toString() + " | Stock: " + b));
		System.out.println();
	}
	
	public Ticket getTicket(List<Article> articles) {
		String[] options = new String[] {
				"Arbre.",
				"Flor.",
				"Decoració.",
		};
		int option;
		boolean askForMore;
		Ticket ticket = new Ticket();
		do {
			try {
				System.out.println();
				for (int i = 1; i <= options.length; i++) {
					System.out.println(i + ".- " + options[i-1]);
				}
				System.out.println();
		        option = Entry.readInt("Quin tipus d'article vols afegir al ticket?: ", 3);
		        Integer quantity;
		        switch (option){
			        case 1:
			        	Tree tree = getTree();
			        	if(articles.contains(tree)) {
			        		quantity = Entry.readInt("Introdueix la quantitat d'aquest article al ticket: ", 0);
					        ticket.addArticle(tree, quantity);
			    		}else {
			    			throw new NonExistantArticle("No s'ha pogut afegir l'article al ticket perquè no existeix en aquesta floristeria.");
			    		}
			        	break;
			        case 2: 
			        	Flower flower = getFlower();
			        	if(articles.contains(flower)) {
			        		quantity = Entry.readInt("Introdueix la quantitat d'aquest article al ticket: ", 0);
			        		ticket.addArticle(flower, quantity);
			    		}else {
			    			throw new NonExistantArticle("No s'ha pogut afegir l'article al ticket perquè no existeix en aquesta floristeria.");
			    		}
			        	break;
			        case 3: 
			        	Decor decor = getDecor();
			        	if(articles.contains(decor)) {
			        		quantity = Entry.readInt("Introdueix la quantitat d'aquest article al ticket: ", 0);
			        		ticket.addArticle(decor, quantity);
			    		}else {
			    			throw new NonExistantArticle("No s'ha pogut afegir l'article al ticket perquè no existeix en aquesta floristeria.");
			    		}
			        	break;
			        default: System.out.println("Només números entre 1 i 3");
			    }
			}catch(NonExistantArticle e) {
				System.out.println(e.getMessage());
			}
			askForMore = Entry.readSiNo("Vols afegir un altre producte al ticket? (S/N)");
		}while(askForMore);
		return ticket;
	}
	
	public void printTickets(List<Ticket> tickets) {
		tickets.forEach(System.out::println);
	}
	
}
