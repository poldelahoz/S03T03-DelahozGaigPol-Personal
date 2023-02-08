package view;

import controller.Entry;
import controller.MenuController;
import controller.MenuOptions;
import model.Menu;

public class Main {

	public static void main(String[] args) {
		
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
				"Mostrar tot el stock amb quantitats.",
				"Mostrar el valor total de la floristeria.", // OK
				"Crear ticket de compra.", // OK
				"Mostrar compres.", // OK
				"Mostrar total facturat." // OK
		};
		
		menuC.setOptions(options);
		
		int option;
        boolean exit = false;
        MenuOptions menuOptions = new MenuOptions();
        menuOptions.fillWithDemoData();
		while (!exit){
        	menuC.printMenu();
        	option = Entry.readInt("", menuC.getOptionsLength());
            switch (option){
                case 1: menuOptions.option1(); break;
                case 2: menuOptions.option2(); break;
                case 3: menuOptions.option3(); break;
                case 4: menuOptions.option4(); break;
                case 5: menuOptions.option5(); break;
                case 6: menuOptions.option6(); break;
                case 7: menuOptions.option7(); break;
                case 8: menuOptions.option8(); break;
                case 10: menuOptions.option10(); break;
                case 11: menuOptions.option11(); break;
                case 12: menuOptions.option12(); break;
                case 13: menuOptions.option13(); break;
                case 0: System.out.println("Fins aviat!"); exit = true; break;
                default: System.out.println("Només números entre 0 i " + menuC.getOptionsLength());
            }
		}
	}

}
