package persistance;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.module.SimpleModule;

import model.Article;
import model.Decor;
import model.Florist;
import model.Flower;
import model.Tree;

public class FilePersistance {
	
	private final static String rootPath = System.getProperty("user.dir") + "\\";
	private final static String filePath = rootPath + "floristeria.txt";
	
	public static Florist retrieve() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			/*SimpleModule module = new SimpleModule();
		    module.addDeserializer(Article.class, new ArticleDeserializer());
		    mapper.registerModule(module);*/
			File file = new File(filePath);
			if(!file.createNewFile()) {
				return mapper.readValue(new File(filePath), Florist.class);
			}
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void update(Florist florist) {
		try {
			ObjectMapper mapper = new ObjectMapper();
		    String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(florist);
			writeFile(jsonStr);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
	private static void writeFile(String data) {
		try {
			File file = new File(filePath);
			file.createNewFile();
			FileWriter fw = new FileWriter(filePath);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(data);		
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
