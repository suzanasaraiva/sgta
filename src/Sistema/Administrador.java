package Sistema;

public class Administrador extends Usuario implements IAdministrador {
	public boolean root;
	
	public Administrador(int id, String nome, String cpf, String senha, String email) {
		super(id, nome, cpf, senha, email);
		
	}
	@Override
	public boolean isRoot() {
		return root;
	}
}
