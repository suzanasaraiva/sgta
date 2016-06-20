package sgta.Repositorio;

public class NaoExisteTrabalhoException extends Exception {

	private static final long serialVersionUID = 1L;

	public NaoExisteTrabalhoException() {
		super("Nao existe trabalhos!");
	}
}
