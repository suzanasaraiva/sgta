package sgta.Repositorio;

public class RepositorioException extends Exception {

	private static final long serialVersionUID = 1L;

	public RepositorioException() {
		super("Problema ao se conectar com o BD");
	}
}
