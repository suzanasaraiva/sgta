package sgta.Sistema;

import java.util.ArrayList;

import sgta.Repositorio.DuplicatedUserException;
import sgta.Repositorio.NaoExisteMensagensException;
import sgta.Repositorio.RepositorioException;
import sgta.Repositorio.UsuarioInexistente;

public interface ISgta {

	void adicionarAluno(int id, String nome, String cpf, String senha, String email, String matricula) throws DuplicatedUserException, RepositorioException;

	void adicionarProfessor(int id, String nome, String cpf, String senha, String email, String matricula) throws DuplicatedUserException, RepositorioException;

	void adicionarAdministrador(int id, String nome, String cpf, String senha, String email, String matricula) throws DuplicatedUserException, RepositorioException;
	
	Usuario buscarUsuarioPorCPF(String cpf) throws RepositorioException, UsuarioInexistente;
	
	Usuario buscarUsuarioPorEmail(String email) throws RepositorioException, UsuarioInexistente;

	void adicionarMensagem(Mensagem mensagem) throws RepositorioException;
	
	int proximoId() throws RepositorioException;
	
	int proximoMensagemId() throws RepositorioException;
	
	int quantitadeMensagens() throws RepositorioException;
	
	ArrayList<Mensagem> buscarMensagensDestinatario() throws RepositorioException;
}
