package Sistema;

public class AutenticacaoException extends Exception {
	/**
	 * Lançada quando algum usuário tenta executar ações para as quais não
	 * possui privilégio suficiente para executar
	 */
	private static final long serialVersionUID = 1L;

	public AutenticacaoException() {
		super("Erro ao autenticar o sistema");
	}
}
