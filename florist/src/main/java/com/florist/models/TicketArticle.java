package com.florist.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class TicketArticle {
	
	@EmbeddedId
	TicketArticleKey TicketArticleId;
	
	@ManyToOne
    @MapsId("ticketId")
    @JoinColumn(name = "ticketId")
    Ticket ticket;

    @ManyToOne
    @MapsId("articleId")
    @JoinColumn(name = "articleId")
    Article article;

    int quantity;
}
