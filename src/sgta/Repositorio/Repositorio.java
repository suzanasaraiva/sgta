package sgta.Repositorio;
import sgta.Sistema.Trabalhos;
import sgta.Sistema.Usuario;
import sgta.Sistema.Aluno;
import sgta.Sistema.Mensagem;
import sgta.Sistema.Professor;
import sgta.Sistema.Trabalhos;
import sgta.Sistema.Administrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class Repositorio implements IRepositorio {
	Connection conn;
	Statement stm;
	ResultSet rs;

	public Repositorio(String host, String user, String pass) throws RepositorioException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(host);
			conn = DriverManager.getConnection(host, user, pass);
			stm = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositorioException();
		}
	}

	@Override
	public int proximoId() throws RepositorioException {
		ArrayList<Usuario> re = buscarSQL("SELECT * FROM  usuarios ORDER BY id DESC");
		if (re.size() == 0) {
			return 0;
		} else {
			return re.get(0).getIdUsuario() + 1;
		}
	}

	private ArrayList<Usuario> buscarSQL(String query) throws RepositorioException {
		ArrayList<Usuario> res = new ArrayList<Usuario>();
		try {
			rs = stm.executeQuery(query);
			while (rs.next()) {
				String tipo = rs.getString("tipo");
				if (tipo.equals("Aluno")) {
					res.add(new Aluno(rs.getInt("id"), rs.getString("Nome"), rs.getString("CPF"), rs.getString("Senha"),
							rs.getString("email"), rs.getString("Matricula")));
				} else if (tipo.equals("Professor")) {
					res.add(new Professor(rs.getInt("id"), rs.getString("Nome"), rs.getString("CPF"),
							rs.getString("Senha"), rs.getString("email"), rs.getString("Matricula")));
				} else if (tipo.equals("Administrador")) {
					res.add(new Administrador(rs.getInt("id"), rs.getString("Nome"), rs.getString("CPF"),
							rs.getString("Senha"), rs.getString("email"), rs.getString("Matricula")));
				}
			}
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RepositorioException();
		}
	}

	@Override
	public boolean adicionarUsuario(Usuario usuario) throws DuplicatedUserException, RepositorioException {
		try {
			stm.executeUpdate("INSERT INTO Usuarios (id, Nome, CPF, Senha,  email, Matricula, tipo) VALUES" + "('"
					+ usuario.getIdUsuario() + "', '" + usuario.getNome() + "', '" + usuario.getCpf() + "', '"
					+ usuario.getSenha() + "', '" + usuario.getEmail() + "', '" + usuario.getMatricula() + "', '"
					+ usuario.getClass().getSimpleName() + "')");
		} catch (SQLIntegrityConstraintViolationException e2) {
			throw new DuplicatedUserException();
		} catch (SQLException e) {
			e.printStackTrace();
			if (e.getErrorCode() == 2601) {
				throw new DuplicatedUserException();
			} else {
				throw new RepositorioException();
			}
		}

		return true;
	}
	

	public boolean remover(int id) {
		try {
			stm.executeUpdate("REMOVE * FROM usuario WHERE id Like '" + id + "'");
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	@Override
	public boolean atualizar(int id, Usuario Usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Usuario> buscarNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Usuario> buscarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean adicionarTrabalho(Trabalhos trabalho) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerTrabalho(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Trabalhos> buscarTrabalhoTitulo(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Trabalhos> buscarTrabalhoAutor(String idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Trabalhos> buscarTrabalhoTema(String tema) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Trabalhos> buscarTrabalho() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscarCPF(String cpf) throws RepositorioException, UsuarioInexistente {
		ArrayList<Usuario> results = buscarSQL("SELECT * FROM  usuarios WHERE CPF Like '" + cpf + "'");
		if (results.size() < 1) { 
			throw new UsuarioInexistente();
		}
		
		return results.get(0);
	}

	@Override
	public boolean adicionarMensagem(Mensagem mensagem) throws RepositorioException, DuplicatedUserException {
		try {
			stm.executeUpdate("INSERT INTO Mensagens (id_Mensagens, id_Remetente, id_Destinatario, Assunto) VALUES" + "('"
					+ mensagem.getIdMenasagem() + "', '" + mensagem.getIdRementente() + "', '" + mensagem.getIdDestinatario() 
					+ "', '" + mensagem.getAssunto() + "')");
		} catch (SQLIntegrityConstraintViolationException e2) {
			throw new DuplicatedUserException();
		} catch (SQLException e) {
			e.printStackTrace();
			if (e.getErrorCode() == 2601) {
				throw new DuplicatedUserException();
			} else {
				throw new RepositorioException();
			}
		}

		return true;
	}


}
