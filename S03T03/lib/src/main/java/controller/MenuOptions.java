package controller;

import java.text.DecimalFormat;

import model.Florist;
import persistance.FilePersistance;
import view.FloristView;

public class MenuOptions {
	
	private static FloristController floristC;
	private final DecimalFormat df = new DecimalFormat("0.00€");
	
	public MenuOptions() {
		floristC = FloristController.getInstance();
		floristC.setView(new FloristView());
		Florist florist = FilePersistance.retrieve();
		if (florist != null) {
			floristC.setModel(florist);
		}
	};
	
	public void option1() {
		if (floristC.getModel() == null) {
			// TODO: throw new custom exception FloristAlreadyExists
			System.out.println("Ja existeix una floristeria.");
		}else {
			Florist florist = new Florist();
			floristC.setModel(florist);
			String name = Entry.readString("Introdueix el nom de la floristeria: ");
			floristC.setFloristName(name);
			System.out.println("Floristeria afegida correctament.");
		}
	}
	
	public void option2() {
		floristC.addTree();
	}
	
	public void option3() {
		floristC.addFlower();
	}
	
	public void option4() {
		floristC.addDecor();
	}
	
	public void option5() {
		floristC.removeTree();
	}
	
	public void option6() {
		floristC.removeFlower();
	}
	
	public void option7() {
		floristC.removeDecor();
	}
	
	public void option8() {
		floristC.printStock();
	}
	
	public void option10() {
		System.out.println("Valor total de la floristeria: " + df.format(floristC.getFloristValue()));
	}
	
	public void option11() {
		boolean askForMore;
		do {
			floristC.addTicket();
			askForMore = Entry.readSiNo("Vols afegir un altre ticket? (S/N)");
		}while(askForMore);
	}
	
	public void option12() {
		floristC.printTickets();
	}
	
	public void option13() {
		System.out.println("Valor total facturat: " + df.format(floristC.getTotalBilled()));
	}
	
	public void fillWithDemoData() {
		floristC.addDemoData();		
	}
	
}
