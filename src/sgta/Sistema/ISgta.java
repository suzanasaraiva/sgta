package sgta.Sistema;

public interface ISgta {

	void adicionarAluno(int id, String nome, String cpf, String senha, String email, String matricula);

	void adicionarPofessor(int id, String nome, String cpf, String senha, String email, String matricula);

	void adicionarAdministrador(int id, String nome, String cpf, String senha, String email, String matricula);

	int proximoId();
}
