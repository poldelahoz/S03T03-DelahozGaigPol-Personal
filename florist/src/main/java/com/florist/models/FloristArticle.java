package com.florist.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class FloristArticle {
	
	@EmbeddedId
	FloristArticleKey FloristArticleId;
	
	@ManyToOne
    @MapsId("floristId")
    @JoinColumn(name = "floristId")
    Florist florist;

    @ManyToOne
    @MapsId("articleId")
    @JoinColumn(name = "articleId")
    Article article;

    int stock;
}
