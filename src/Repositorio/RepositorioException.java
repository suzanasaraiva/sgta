package Repositorio;

public class RepositorioException extends Exception {

	/**
	 * Lan�ada quando h� um problema na conex�o com o banco de dados.
	 */
	private static final long serialVersionUID = 1L;

	public RepositorioException() {
		super("Problema ao se conectar com o BD");
	}
}
