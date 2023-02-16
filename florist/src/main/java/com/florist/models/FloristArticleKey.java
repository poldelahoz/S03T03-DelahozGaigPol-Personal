package com.florist.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class FloristArticleKey implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "floristId")
    Integer floristId;

    @Column(name = "articleId")
    Integer articleId;
    
    public Integer getFloristId() {
		return floristId;
	}
	
	public void setFloristId(Integer floristId) {
		this.floristId = floristId;
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
		FloristArticleKey other = (FloristArticleKey) obj;
		return Objects.equals(floristId, other.floristId) && Objects.equals(articleId, other.articleId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(floristId, articleId);
	}
}
