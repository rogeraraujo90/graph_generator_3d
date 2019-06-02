package rogeraraujo.d_graph_generator.exceptions;

/**
 * Exception related with the limitation of dimension of this library.
 * In this current version is just accepted the 3D universe; 
 * 
 * @author Róger Araújo
 */
public class DimensionLimitException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String message = "Graph is designed to have 3 dimension only";

	public DimensionLimitException(String message) {
		super();
		this.message = message;
	}
	
	public DimensionLimitException() {}

	public String getMessage() {
		return message;
	}
}
