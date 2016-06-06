package sgta.Repositorio;

public class DuplicatedUserException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public DuplicatedUserException() {
		super("Usuario existente!");
	}
}
