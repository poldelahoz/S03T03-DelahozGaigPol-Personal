package persistance;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

import model.Article;
import model.Decor;
import model.Flower;
import model.Tree;
import model.Decor.Material;

public class ArticleStockDeserializer extends KeyDeserializer {

	@Override
	public Article deserializeKey(String key, DeserializationContext ctxt) throws IOException {
		String[] values = key.split(" ");
		String type = values[1];
		Float price = Float.parseFloat(values[7].replace(',', '.'));
		if (type.equals("Tree")) {
			Tree tree = new Tree();
			tree.setPrice(price);
			tree.setHeight(Float.parseFloat(values[4]));
			return tree;
		}else if(type.equals("Flower")) {
			Flower flower = new Flower();
			flower.setPrice(price);
			flower.setColor(values[4].trim());
			return flower;
		}else {
			Decor decor = new Decor();
			decor.setPrice(price);
			decor.setMaterial(Material.valueOf(values[4]));
			return decor;
		}
	}
	
}
