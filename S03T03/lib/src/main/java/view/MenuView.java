package view;

public class MenuView {
	
	public void printMenu(String[] options) {
    	System.out.println();
		System.out.println("--------------------------- MENÚ ---------------------------");
		for (int i = 1; i <= options.length; i++) {
			System.out.println(i + ".- " + options[i-1]);
		}
		System.out.println("0.- Sortir");
		System.out.println();
        System.out.print("Tria una opció: ");
	}
	
}
