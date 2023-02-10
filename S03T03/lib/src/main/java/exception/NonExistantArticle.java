package exception;

public class NonExistantArticle extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NonExistantArticle(String errorMessage) {
		super(errorMessage);
	}
}
