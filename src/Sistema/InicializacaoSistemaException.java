package Sistema;

public class InicializacaoSistemaException extends Exception {
	private static final long serialVersionUID = 1L;

	public InicializacaoSistemaException() {
		super("Nao foi possivel inicializar o sistema");
	}
}
