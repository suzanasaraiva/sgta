package Repositorio;

public class RepositorioException extends Exception {

	/**
	 * Lançada quando há um problema na conexão com o banco de dados.
	 */
	private static final long serialVersionUID = 1L;

	public RepositorioException() {
		super("Problema ao se conectar com o BD");
	}
}
