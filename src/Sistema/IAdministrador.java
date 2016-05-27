package Sistema;

public interface IAdministrador {
	/**
	 * Retorna se é o administrador principal do sistema
	 * 
	 * @return true caso seja o administrador de nível mais alto no sistema,
	 *         false caso não
	 */
	boolean isRoot();
}
