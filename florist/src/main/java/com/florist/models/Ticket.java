package com.florist.models;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ticketId;
	
	@Column(nullable=false)
	private final Date created;
	
	@OneToMany(mappedBy = "ticket")
    Set<TicketArticle> articles;
	
	private final DecimalFormat df = new DecimalFormat("0.00€");
	private final DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy HH:mm:ss");
	
	public Ticket() {
		created = new Date();
	}
	
	public Date getCreated() {
		return created;
	}
}
