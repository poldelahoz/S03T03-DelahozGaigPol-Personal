package view;

import controller.Entry;
import controller.FloristController;
import controller.MenuController;
import controller.MenuOptions;
import model.Florist;
import model.Menu;
import persistance.FilePersistance;

public class Main {

	public static void main(String[] args) {
		init();
	}
	
	private static void init() {
				
		// Initialize the Florist controller
		FloristController floristC = FloristController.getInstance();
		floristC.setView(new FloristView());
		Florist florist = FilePersistance.retrieve();
		if (florist != null) {
			floristC.setModel(florist);
		}
		// Descomentar si es vol afegir dades de prova
		floristC.addDemoData();
		
		Menu menu = Menu.getInstance();
		MenuView menuV = new MenuView();
		MenuController menuC = new MenuController(menu, menuV);
		
		String[] options = new String[] {
				"Crear floristeria.", // OK
				"Afegir arbre.", // OK
				"Afegir flor.", // OK
				"Afegir decoració.", // OK
				"Retirar arbre.", // OK
				"Retirar flor.", // OK
				"Retirar decoració.", // OK
				"Mostrar tot el stock sense quantitats.", // OK
				"Mostrar tot el stock amb quantitats.", // OK
				"Mostrar el valor total de la floristeria.", // OK
				"Crear ticket de compra.", // OK
				"Mostrar compres.", // OK
				"Mostrar total facturat." // OK
		};
		menuC.setOptions(options);
		
		int option;
        boolean exit = false;
		while (!exit){
        	menuC.printMenu();
        	option = Entry.readInt("", menuC.getOptionsLength());
            switch (option){
                case 1: MenuOptions.option1(); break;
                case 2: MenuOptions.option2(); break;
                case 3: MenuOptions.option3(); break;
                case 4: MenuOptions.option4(); break;
                case 5: MenuOptions.option5(); break;
                case 6: MenuOptions.option6(); break;
                case 7: MenuOptions.option7(); break;
                case 8: MenuOptions.option8(); break;
                case 9: MenuOptions.option9(); break;
                case 10: MenuOptions.option10(); break;
                case 11: MenuOptions.option11(); break;
                case 12: MenuOptions.option12(); break;
                case 13: MenuOptions.option13(); break;
                case 0: System.out.println("Fins aviat!"); exit = true; break;
                default: System.out.println("Només números entre 0 i " + menuC.getOptionsLength());
            }
		}
	}

}
