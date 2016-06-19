package sgta.Repositorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import sgta.Sistema.Arquivo;
import sgta.Sistema.Mensagem;
import sgta.Sistema.Oportunidades;
import sgta.Sistema.Trabalhos;
import sgta.Sistema.Usuario;

public interface IRepositorio {

	boolean adicionarUsuario(Usuario usuario) throws RepositorioException, DuplicatedUserException;

	boolean remover(int id);

	boolean atualizar(int id, Usuario Usuario);

	ArrayList<Usuario> buscarNome(String nome);

	Usuario buscarId(int id) throws RepositorioException, UsuarioInexistente;

	Usuario buscarCPF(String cpf) throws RepositorioException, UsuarioInexistente;
	
	Usuario buscarEmail(String email) throws RepositorioException, UsuarioInexistente;

	boolean adicionarTrabalho(Trabalhos trabalho);

	boolean removerTrabalho(int id);

	ArrayList<Trabalhos> buscarTrabalhoTitulo(String titulo);

	ArrayList<Trabalhos> buscarTrabalhoAutor(String idUsuario);

	ArrayList<Trabalhos> buscarTrabalhoTema(String tema);

	ArrayList<Trabalhos> buscarTrabalho();

	boolean adicionarMensagem(Mensagem mensagem) throws RepositorioException;

	public int proximoId() throws RepositorioException;
	
	public int proximoMensagemId() throws RepositorioException;
	
	ArrayList<Mensagem> buscarMensagensDestinatario(int idDestinatario) throws RepositorioException, NaoExisteMensagensException;

	ArrayList<Mensagem> buscarMensagensRemetente(int idRemetente) throws RepositorioException, NaoExisteMensagensException;
	
	boolean adicionarOportunidade(Oportunidades opor) throws Throwable;

	boolean removerOportunidades(int idOpor) throws Throwable;

	int proximoOportunidadeId() throws RepositorioException;
	
	int recuperarId(String id) throws Throwable;

	boolean adicionarArquivo(Arquivo arquivo) throws FileNotFoundException, SQLException;

	Arquivo buscarArquivoPorID(int id) throws RepositorioException, IOException;

	boolean marcarLido(int id) throws RepositorioException;	
}
