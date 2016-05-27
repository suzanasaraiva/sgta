package Sistema;

public interface IAdministrador {
	/**
	 * Retorna se � o administrador principal do sistema
	 * 
	 * @return true caso seja o administrador de n�vel mais alto no sistema,
	 *         false caso n�o
	 */
	boolean isRoot();
}
