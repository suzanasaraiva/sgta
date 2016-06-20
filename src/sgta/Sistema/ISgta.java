package sgta.Sistema;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import sgta.Repositorio.ArquivoInexistente;
import sgta.Repositorio.DuplicatedUserException;
import sgta.Repositorio.NaoExisteMensagensException;
import sgta.Repositorio.NaoExisteTrabalhoException;
import sgta.Repositorio.RepositorioException;
import sgta.Repositorio.UsuarioInexistente;

public interface ISgta {

	void adicionarAluno(int id, String nome, String cpf, String senha, String email, String matricula) throws DuplicatedUserException, RepositorioException;

	void adicionarProfessor(int id, String nome, String cpf, String senha, String email, String matricula) throws DuplicatedUserException, RepositorioException;

	void adicionarAdministrador(int id, String nome, String cpf, String senha, String email, String matricula) throws DuplicatedUserException, RepositorioException;
	
	ArrayList<Usuario> buscarUsuariosPorNome(String nome) throws RepositorioException, UsuarioInexistente;
	
	Usuario buscarUsuarioPorID(int id) throws RepositorioException, UsuarioInexistente;
	
	Usuario buscarUsuarioPorCPF(String cpf) throws RepositorioException, UsuarioInexistente;
	
	Usuario buscarUsuarioPorEmail(String email) throws RepositorioException, UsuarioInexistente;

	void adicionarMensagem(Mensagem mensagem) throws RepositorioException;
	
	int proximoId() throws RepositorioException;
	
	int proximoMensagemId() throws RepositorioException;
	
	int proximoTrabalhoId() throws RepositorioException;
	
	int proximoArquivoId() throws RepositorioException, IOException;
	
	int quantitadeMensagens() throws RepositorioException;
	
	ArrayList<Mensagem> buscarMensagensDestinatario() throws RepositorioException;
	
	ArrayList<Mensagem> buscarMensagensRemetetne() throws RepositorioException;

	void removerOportunidades(int idOpor) throws Throwable;

	int proximoOportunidadeId() throws RepositorioException;

	void adicionarOportunidades(int idOportunidade, int idOrientador, String num_vagas, String descricao, String tipo_bolsa,
			int valor_bolsa, String duracao, String requisitos) throws Throwable;
	
	void recuperarId(String cpf) throws Throwable;
	
	void marcarLido(int id) throws RepositorioException;
	
	boolean adicionarTrabalho(Trabalho trabalho) throws RepositorioException;
	
	ArrayList<Trabalho> buscarTrabalhoTitulo(String titulo) throws RepositorioException, NaoExisteTrabalhoException;

	ArrayList<Trabalho> buscarTrabalhoAutor(int idUsuario) throws RepositorioException, NaoExisteTrabalhoException;

	ArrayList<Trabalho> buscarTrabalhoTema(String tema) throws RepositorioException, NaoExisteTrabalhoException;
	
	boolean adicionarArquivo(Arquivo arquivo, int idTrabalho) throws FileNotFoundException, RepositorioException;
	
	ArrayList<Arquivo> buscarArquivosPorIDTrabalho(int id) throws RepositorioException, IOException, ArquivoInexistente;
}
