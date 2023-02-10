package exception;

public class EmptyFloristException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public EmptyFloristException(String errorMessage) {
		super(errorMessage);
	}
	
}
