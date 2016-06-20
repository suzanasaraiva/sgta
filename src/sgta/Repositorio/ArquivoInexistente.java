package sgta.Repositorio;

public class ArquivoInexistente extends Exception {

	private static final long serialVersionUID = 1L;

	public ArquivoInexistente() {
		super("Arquivo nao encontrado!");
	}
}