package sgta.Sistema;

public class Usuario {
	/**
	 * Contador de instâncias
	 */
	private static int numeroUsuario = 0;

	public int idUsuario;
	protected String nome;
	protected String cpf;
	protected String senha;
	protected String email;
	protected String matricula;
	


	public Usuario(int id, String nome, String cpf, String senha, String email,String matricula) {
		this.idUsuario = Usuario.numeroUsuario++;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.senha = senha;
		this.email = email;
		this.matricula= matricula;
		
		
	}
	

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}