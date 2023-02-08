package controller;

import java.text.DecimalFormat;

import exception.EmptyFloristException;
import exception.NonExistantArticle;
import model.Florist;

public class MenuOptions {
	
	private static FloristController floristC = FloristController.getInstance();
	private static final DecimalFormat df = new DecimalFormat("0.00€");
	
	public static void option1() {
		if (floristC.getModel() != null) {
			boolean changeName = Entry.readSiNo("Ja existeix una floristeria. Vols canviar-li el nom? (S/N)");
			if(changeName) {
				String name = Entry.readString("Introdueix el nom de la floristeria: ");
				floristC.setFloristName(name);
				System.out.println("Nom de la floristeria canviat correctament.");
			}
		}else {
			Florist florist = new Florist();
			floristC.setModel(florist);
			String name = Entry.readString("Introdueix el nom de la floristeria: ");
			floristC.setFloristName(name);
			System.out.println("Floristeria afegida correctament.");
		}
	}
	
	public static void option2(){
		try {
			floristC.addTree();
		} catch (EmptyFloristException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void option3() {
		try {
			floristC.addFlower();
		} catch (EmptyFloristException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void option4() {
		try {
			floristC.addDecor();
		} catch (EmptyFloristException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void option5() {
		try {
			floristC.removeTree();
		} catch (EmptyFloristException | NonExistantArticle e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void option6() {
		try {
			floristC.removeFlower();
		} catch (EmptyFloristException | NonExistantArticle e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void option7() {
		try {
			floristC.removeDecor();
		} catch (EmptyFloristException | NonExistantArticle e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void option8() {
		floristC.printStock();
	}
	
	public static void option9() {
		floristC.printStockWithQuantities();
	}
	
	public static void option10() {
		try {
			System.out.println("Valor total de la floristeria: " + df.format(floristC.getFloristValue()));
		} catch (EmptyFloristException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void option11() {
		try {
			boolean askForMore;
			do {
				floristC.addTicket();
				askForMore = Entry.readSiNo("Vols afegir un altre ticket? (S/N)");
			}while(askForMore);
		} catch (EmptyFloristException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void option12() {
		floristC.printTickets();
	}
	
	public static void option13() {
		try {
			System.out.println("Valor total facturat: " + df.format(floristC.getTotalBilled()));
		} catch (EmptyFloristException e) {
			System.out.println(e.getMessage());
		}
	}
}
