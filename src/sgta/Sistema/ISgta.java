package sgta.Sistema;



public interface ISgta {
	
	void adicionar(int id, String nome,  String cpf, String senha, String email, String  matricula) ;
	void adicionarAluno(int id, String nome, String cpf, String senha, String email, String matricula);
	void adicionarPofessor(int id, String nome, String cpf, String senha, String email, String matricula);
	void adicionarAdministrador(int id, String nome, String cpf, String senha, String email, String matricula);

}
