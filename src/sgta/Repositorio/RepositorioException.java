package sgta.Repositorio;

public class RepositorioException extends Exception {

	/**
	 * Lancada quando ha um problema na conexao com o banco de dados.
	 */
	private static final long serialVersionUID = 1L;

	public RepositorioException() {
		super("Problema ao se conectar com o BD");
	}
}
