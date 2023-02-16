package com.florist.models;


import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "user")
@Entity
public class Florist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer floristId;
	
	@Column(nullable=false)
	private String name;
	
	@OneToMany(mappedBy = "florist")
    Set<FloristArticle> articles;
	
	public Florist() {
	}
	
	public Integer getId() {
	    return floristId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
