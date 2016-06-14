package sgta.Repositorio;

public class NaoExisteMensagensException extends Exception {

	private static final long serialVersionUID = 1L;

	public NaoExisteMensagensException() {
		super("Nao existe mensagens!");
	}
}
