package model;

public class Menu {
	
	private static Menu instance;
	private String[] options;
	
	private Menu() {};
	
	public static Menu getInstance() {
		if (instance == null) {
			instance = new Menu();
		}
		return instance;
	}
	
	public void setOptions(String[] options) {
		this.options = options;
	}
	
	public String[] getOptions() {
		return options;
	}
	
}
