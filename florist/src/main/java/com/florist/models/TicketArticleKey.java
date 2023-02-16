package com.florist.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TicketArticleKey implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "ticketId")
    Integer ticketId;

    @Column(name = "articleId")
    Integer articleId;
    
    public Integer getTicketId() {
		return ticketId;
	}
	
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	
	public Integer getArticleId() {
		return articleId;
	}
	
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
    
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketArticleKey other = (TicketArticleKey) obj;
		return Objects.equals(ticketId, other.ticketId) && Objects.equals(articleId, other.articleId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ticketId, articleId);
	}
}
