package sgta.Sistema;

import sgta.Repositorio.DuplicatedUserException;
import sgta.Repositorio.RepositorioException;
import sgta.Repositorio.UsuarioInexistente;

public interface ISgta {

	void adicionarAluno(int id, String nome, String cpf, String senha, String email, String matricula) throws DuplicatedUserException, RepositorioException;

	void adicionarProfessor(int id, String nome, String cpf, String senha, String email, String matricula) throws DuplicatedUserException, RepositorioException;

	void adicionarAdministrador(int id, String nome, String cpf, String senha, String email, String matricula) throws DuplicatedUserException, RepositorioException;
	
	Usuario buscarUsuarioPorCPF(String cpf) throws RepositorioException, UsuarioInexistente;

	void adicionarMensagem(Mensagem mensagem) throws RepositorioException, DuplicatedUserException;
	
	
	
	int proximoId();
}
