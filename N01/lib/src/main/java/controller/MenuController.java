package controller;

import model.Menu;
import view.MenuView;

public class MenuController {
	
	private Menu model;
	private MenuView view;
	
	public MenuController(Menu model, MenuView view) {
		this.model = model;
		this.view = view;
	}
	
	public Menu getModel() {
		return model;
	}

	public void setModel(Menu model) {
		this.model = model;
	}
	
	public MenuView getView() {
		return view;
	}

	public void setView(MenuView view) {
		this.view = view;
	}
	
	public void setOptions(String[] options) {
		model.setOptions(options);
	}
	
	public String[] getOptions() {
		return model.getOptions();
	}
	
	public Integer getOptionsLength() {
		return model.getOptions().length;
	}
	
	public void printMenu() {
		view.printMenu(getOptions());
	}
	
}
