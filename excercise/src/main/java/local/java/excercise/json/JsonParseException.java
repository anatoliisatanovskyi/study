package local.java.excercise.json;

public class JsonParseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JsonParseException(String message){
		super(message);
	}
	
	public JsonParseException(String message, Exception cause) {
		super(message, cause);
	}
	
	

}
