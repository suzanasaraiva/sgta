package sgta.Sistema;

import sgta.Repositorio.DuplicatedUserException;
import sgta.Repositorio.RepositorioException;

public interface ISgta {

	void adicionarAluno(int id, String nome, String cpf, String senha, String email, String matricula) throws DuplicatedUserException, RepositorioException;

	void adicionarProfessor(int id, String nome, String cpf, String senha, String email, String matricula) throws DuplicatedUserException, RepositorioException;

	void adicionarAdministrador(int id, String nome, String cpf, String senha, String email, String matricula) throws DuplicatedUserException, RepositorioException;

	int proximoId();
}
