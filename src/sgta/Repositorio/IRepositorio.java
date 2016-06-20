package sgta.Repositorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import sgta.Sistema.Arquivo;
import sgta.Sistema.Mensagem;
import sgta.Sistema.Oportunidades;
import sgta.Sistema.Trabalho;
import sgta.Sistema.Usuario;

public interface IRepositorio {

	boolean adicionarUsuario(Usuario usuario) throws RepositorioException, DuplicatedUserException;

	boolean remover(int id);

	boolean atualizar(int id, Usuario Usuario);

	Usuario buscarId(int id) throws RepositorioException, UsuarioInexistente;

	Usuario buscarCPF(String cpf) throws RepositorioException, UsuarioInexistente;
	
	Usuario buscarEmail(String email) throws RepositorioException, UsuarioInexistente;
	
	ArrayList<Usuario> buscarNome(String nome) throws RepositorioException, UsuarioInexistente;
	
	boolean adicionarTrabalho(Trabalho trabalho) throws RepositorioException;

	boolean removerTrabalho(int id);

	ArrayList<Trabalho> buscarTrabalhoTitulo(String titulo) throws RepositorioException, NaoExisteTrabalhoException;

	ArrayList<Trabalho> buscarTrabalhoAutor(int idUsuario) throws RepositorioException, NaoExisteTrabalhoException;

	ArrayList<Trabalho> buscarTrabalhoTema(String tema) throws RepositorioException, NaoExisteTrabalhoException;

	ArrayList<Trabalho> buscarTrabalho();

	boolean adicionarMensagem(Mensagem mensagem) throws RepositorioException;

	public int proximoId() throws RepositorioException;
	
	public int proximoMensagemId() throws RepositorioException;
	
	public int proximoTrabalhoId() throws RepositorioException;
	
	public int proximoArquivoId() throws RepositorioException, IOException;
	
	ArrayList<Mensagem> buscarMensagensDestinatario(int idDestinatario) throws RepositorioException, NaoExisteMensagensException;

	ArrayList<Mensagem> buscarMensagensRemetente(int idRemetente) throws RepositorioException, NaoExisteMensagensException;
	
	boolean adicionarOportunidade(Oportunidades opor) throws Throwable;

	boolean removerOportunidades(int idOpor) throws Throwable;

	int proximoOportunidadeId() throws RepositorioException;
	
	int recuperarId(String id) throws Throwable;

	boolean adicionarArquivo(Arquivo arquivo, int idTrabalho) throws FileNotFoundException, RepositorioException;
	
	Arquivo buscarArquivoPorID(int id) throws RepositorioException, IOException, ArquivoInexistente;
	
	ArrayList<Arquivo> buscarArquivosPorIDTrabalho(int id) throws RepositorioException, IOException, ArquivoInexistente;

	boolean marcarLido(int id) throws RepositorioException;	
}
