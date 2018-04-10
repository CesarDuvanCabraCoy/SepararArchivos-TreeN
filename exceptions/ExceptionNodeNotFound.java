package exceptions;

public class ExceptionNodeNotFound extends Exception{

	private static final long serialVersionUID = 1L;
	public static final String EXC_NODE_NOT_FOUND = "Nodo no encontrado";
	
	public ExceptionNodeNotFound() {
		super(EXC_NODE_NOT_FOUND);
	}
}
