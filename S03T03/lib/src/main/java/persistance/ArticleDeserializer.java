package persistance;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import model.Article;
import model.Decor;
import model.Decor.Material;
import model.Flower;
import model.Tree;

public class ArticleDeserializer extends StdDeserializer<Article> {
	
	public ArticleDeserializer() {
        this(null);
    }

    public ArticleDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Article deserialize(JsonParser jp, DeserializationContext ctxt) 
      throws IOException, JsonProcessingException {
 
        JsonNode productNode = jp.getCodec().readTree(jp);
        if (productNode.get("type").textValue().equals("Tree")) {
        	Tree tree = new Tree();
        	tree.setPrice(Float.parseFloat(productNode.get("price").textValue()));
        	tree.setHeight(Float.parseFloat(productNode.get("height").textValue()));
        	return tree;
        }else if(productNode.get("type").textValue().equals("Tree")) {
        	Flower flower = new Flower();
        	flower.setPrice(Float.parseFloat(productNode.get("price").textValue()));
        	flower.setColor(productNode.get("color").textValue());
        	return flower;
        }else {
        	Decor decor = new Decor();
        	decor.setPrice(Float.parseFloat(productNode.get("price").textValue()));
        	decor.setMaterial(Material.valueOf(productNode.get("material").textValue()));
        	return decor;
        }        
    }
}
