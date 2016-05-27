package Sistema;

public class AutenticacaoException extends Exception {
	/**
	 * Lan�ada quando algum usu�rio tenta executar a��es para as quais n�o
	 * possui privil�gio suficiente para executar
	 */
	private static final long serialVersionUID = 1L;

	public AutenticacaoException() {
		super("Erro ao autenticar o sistema");
	}
}
