package sgta.Sistema;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import sgta.Repositorio.DuplicatedUserException;
import sgta.Repositorio.IRepositorio;
import sgta.Repositorio.NaoExisteMensagensException;
import sgta.Repositorio.Repositorio;
import sgta.Repositorio.RepositorioException;
import sgta.Repositorio.UsuarioInexistente;
import sgta.Sistema.InicializacaoSistemaException;
import sgta.util.Message;
import sgta.Sistema.ISgta;

public class Sgta implements ISgta {

	private IRepositorio repositorio;

	private static ISgta instance;

	public static Usuario usuario;

	public Sgta() throws InicializacaoSistemaException {
		try {
			this.repositorio = new Repositorio("jdbc:mysql://localhost:3306/sgta", "root", "senha");
			System.out.println(this.proximoId());
		} catch (RepositorioException e) {
			throw new InicializacaoSistemaException();
		}
	}

	public static ISgta getInstance() throws InicializacaoSistemaException {
		if (Sgta.instance == null) {
			try {
				Sgta.instance = new Sgta();
			} catch (Exception e) {
				e.printStackTrace();
				throw new InicializacaoSistemaException();
			}
		}
		return Sgta.instance;
	}

	@Override
	public int proximoId() throws RepositorioException {
		return repositorio.proximoId();
	}

	@Override
	public int proximoMensagemId() throws RepositorioException {
		return repositorio.proximoMensagemId();
	}
	
	@Override
	public int proximoTrabalhoId() throws RepositorioException {
		return repositorio.proximoTrabalhoId();
	}
	
	@Override
	public int proximoArquivoId() throws RepositorioException, IOException {
		return repositorio.proximoArquivoId();
	}

	@Override
	public int proximoOportunidadeId() throws RepositorioException {
		return repositorio.proximoOportunidadeId();
	}

	@Override
	public void adicionarAluno(int id, String nome, String cpf, String senha, String email, String matricula)
			throws DuplicatedUserException, RepositorioException {
		Aluno aluno = new Aluno(id, nome, cpf, senha, email, matricula);
		repositorio.adicionarUsuario(aluno);
	}

	@Override
	public void adicionarProfessor(int id, String nome, String cpf, String senha, String email, String matricula)
			throws DuplicatedUserException, RepositorioException {
		Professor professor = new Professor(id, nome, cpf, senha, email, matricula);
		repositorio.adicionarUsuario(professor);
	}

	@Override
	public void adicionarAdministrador(int id, String nome, String cpf, String senha, String email, String matricula)
			throws DuplicatedUserException, RepositorioException {
		Administrador administrador = new Administrador(id, nome, cpf, senha, email, matricula);
		repositorio.adicionarUsuario(administrador);
	}

	@Override
	public Usuario buscarUsuarioPorCPF(String cpf) throws RepositorioException, UsuarioInexistente {
		return repositorio.buscarCPF(cpf);
	}

	@Override
	public Usuario buscarUsuarioPorEmail(String email) throws RepositorioException, UsuarioInexistente {
		return repositorio.buscarEmail(email);
	}

	@Override
	public void adicionarMensagem(Mensagem mensagem) throws RepositorioException {
		repositorio.adicionarMensagem(mensagem);

	}

	@Override
	public int quantitadeMensagens() throws RepositorioException {
		try {
			int total = 0;
			ArrayList<Mensagem> mensagens = this.repositorio.buscarMensagensDestinatario(Sgta.usuario.idUsuario);
			for (Mensagem mensagem : mensagens) {
				if (!mensagem.isRead()) {
					total++;
				}
			}
			return total;
		} catch (NaoExisteMensagensException e) {
			return 0;
		}
	}

	@Override
	public ArrayList<Mensagem> buscarMensagensDestinatario() throws RepositorioException {
		ArrayList<Mensagem> resultado;
		try {
			resultado = repositorio.buscarMensagensDestinatario(Sgta.usuario.getIdUsuario());
		} catch (NaoExisteMensagensException e) {
			resultado = new ArrayList<Mensagem>();
			Message.infoBox("Nao existe mensagens para voce", "Erro");
		}
		return resultado;
	}

	@Override
	public void adicionarOportunidades(int idOportunidade, int idOrientador, String num_vagas, String descricao,
			String tipo_bolsa, int valor_bolsa, String duracao, String requisitos) throws Throwable {
		Oportunidades opor = new Oportunidades(idOportunidade, idOrientador, num_vagas, descricao, tipo_bolsa,
				valor_bolsa, duracao, requisitos);
		repositorio.adicionarOportunidade(opor);
	}

	@Override
	public void removerOportunidades(int idOpor) throws Throwable {
		repositorio.removerOportunidades(idOpor);

	}

	@Override
	public void recuperarId(String cpf) throws Throwable {
		repositorio.recuperarId(cpf);		
	}

	@Override
	public Usuario buscarUsuarioPorID(int id) throws RepositorioException, UsuarioInexistente {
		return repositorio.buscarId(id);
	}

	@Override
	public void marcarLido(int id) throws RepositorioException {
		repositorio.marcarLido(id);
	}

	@Override
	public ArrayList<Mensagem> buscarMensagensRemetetne() throws RepositorioException {
		ArrayList<Mensagem> resultado;
		try {
			resultado = repositorio.buscarMensagensRemetente(Sgta.usuario.getIdUsuario());
		} catch (NaoExisteMensagensException e) {
			resultado = new ArrayList<Mensagem>();
			Message.infoBox("Voce nao envior nenhuma mensagem", "Erro");
		}
		return resultado;
	}

	@Override
	public boolean adicionarArquivo(Arquivo arquivo, int idTrabalho) throws FileNotFoundException, RepositorioException {
		repositorio.adicionarArquivo(arquivo, idTrabalho);
		return true;
	}

	@Override
	public boolean adicionarTrabalho(Trabalho trabalho) throws RepositorioException {
		repositorio.adicionarTrabalho(trabalho);
		return true;
	}

}
