package com.florist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.florist.models.Florist;
import com.florist.repositories.FloristRepository;

@Controller
public class MainController {
	
	@Autowired
	private FloristRepository floristRepository;
	
	public void addNewFlorist(String name) {
	  	Florist florist = new Florist();
		florist.setName(name);
	    floristRepository.save(florist);
	}
	
	public Florist getFlorist() {
		List<Florist> florists = floristRepository.findAll();
	    return florists.get(0);
	}
}
