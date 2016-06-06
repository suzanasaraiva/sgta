package sgta.Repositorio;

public class UsuarioInexistente extends Exception {

	private static final long serialVersionUID = 1L;

	public UsuarioInexistente() {
		super("Usuario nao encontrado!");
	}
}