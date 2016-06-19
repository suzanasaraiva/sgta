package sgta.Repositorio;

import sgta.Sistema.Trabalhos;
import sgta.Sistema.Usuario;
import sgta.Sistema.Aluno;
import sgta.Sistema.Arquivo;
import sgta.Sistema.Mensagem;
import sgta.Sistema.Oportunidades;
import sgta.Sistema.Professor;
import sgta.Sistema.Administrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.pdfbox.io.IOUtils;

import com.mysql.jdbc.PreparedStatement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
		ArrayList<Usuario> re = buscarSQL("SELECT * FROM usuarios ORDER BY id DESC");
		if (re.size() == 0) {
			return 0;
		} else {
			return re.get(0).getIdUsuario() + 1;
		}
	}
	
	@Override
	public int proximoMensagemId() throws RepositorioException {
		ArrayList<Mensagem> re = buscarSQLMensagem("SELECT * FROM  mensagens ORDER BY id_Mensagens DESC");
		if (re.size() == 0) {
			return 0;
		} else {
			return re.get(0).getIdMenasagem() + 1;
		}
	}

	@Override
	public int proximoOportunidadeId() throws RepositorioException {
		ArrayList<Usuario> re = buscarSQL("SELECT * FROM  oportunidades ORDER BY id DESC");
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
	
	private ArrayList<Mensagem> buscarSQLMensagem(String query) throws RepositorioException {
		ArrayList<Mensagem> res = new ArrayList<Mensagem>();
		try {
			rs = stm.executeQuery(query);
			while (rs.next()) {
				res.add(new Mensagem(rs.getInt("id_Mensagens"), rs.getInt("id_Remetente"), rs.getInt("id_Destinatario"),
						rs.getString("assunto"), rs.getString("mensagem"), rs.getInt("isRead") == 1));
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
	

	@Override
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
	public Usuario buscarId(int id) throws RepositorioException, UsuarioInexistente {
		ArrayList<Usuario> results = buscarSQL("SELECT * FROM  usuarios WHERE id Like '" + id + "'");
		if (results.size() < 1) { 
			throw new UsuarioInexistente();
		}
		
		return results.get(0);
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
	public Usuario buscarEmail(String email) throws RepositorioException, UsuarioInexistente {
		ArrayList<Usuario> results = buscarSQL("SELECT * FROM  usuarios WHERE email Like '" + email + "'");
		if (results.size() < 1) { 
			throw new UsuarioInexistente();
		}
		
		return results.get(0);
	}

	@Override
	public boolean adicionarMensagem(Mensagem mensagem) throws RepositorioException {
		try {
			stm.executeUpdate("INSERT INTO Mensagens (id_Mensagens, id_Remetente, id_Destinatario, assunto, mensagem, isRead) VALUES" + "('"
					+ mensagem.getIdMenasagem() + "', '" + mensagem.getIdRementente() + "', '" + mensagem.getIdDestinatario() 
					+ "', '" + mensagem.getAssunto() + "', '" + mensagem.getMensagem() + "', '" + (mensagem.isRead() ? 1 : 0) + "')");
		}  catch (SQLException e) {
			e.printStackTrace();
			throw new RepositorioException();
		}

		return true;
	}

	@Override
	public ArrayList<Mensagem> buscarMensagensDestinatario(int idDestinatario)
			throws RepositorioException, NaoExisteMensagensException {
		ArrayList<Mensagem> results = buscarSQLMensagem("SELECT * FROM mensagens WHERE id_Destinatario Like '" + idDestinatario + "'");
		if (results.size() < 1) { 
			throw new NaoExisteMensagensException();
		}
		
		return results;
	}

	

	public boolean adicionarOportunidade(Oportunidades opor) throws Throwable {
		stm.executeUpdate("INSERT INTO Oportunidade (idOportunidade, idOrientador, num_vagas, num_vagas_restantes, descricao, tipo_bolsa, valor_bolsa, duracao, requisitos) VALUES" +
				"(" + opor.getIdOportunidade() + ", " + opor.getIdOrientador() + ", " + opor.getNum_vagas() + ", " + opor.getNum_vagas() + ", '" + opor.getDescricao() + "', '"
				+  opor.getTipo_bolsa() + "', " + opor.getTipo_bolsa() + ", " + opor.getDuracao() + ", '" + opor.getRequisitos() + "')");
		return true;
	}
	@Override
	public boolean removerOportunidades(int idOpor) throws Throwable {
		stm.executeUpdate("DELETE FROM oportunidades WHERE id = " + idOpor);
		return true;
	}

	@Override
	public int recuperarId(String cpf) throws Throwable {
		int id = -1;
		stm.execute("SELECT id FROM usuarios where cpf = '" + cpf + "' AND Tipo = 'Professor'");
		
		while(rs.next()){
			id = rs.getInt(0);
		}
		return id;
	}
	
	public boolean adicionarArquivo(Arquivo arquivo) throws FileNotFoundException, SQLException {
		
		File file = arquivo.getFile();
		
		FileInputStream fis = new FileInputStream(file);
		
		String query = "INSERT INTO arquivos (id_arquivo, id_aluno, file)" + "VALUES (?, ?, ?)";
		
		PreparedStatement pstm = (PreparedStatement) this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		pstm.setInt(1, arquivo.idArquivos);
		pstm.setInt(2, arquivo.idAluno);
		pstm.setBinaryStream(3, fis, (int)file.length());
		pstm.execute();
		pstm.close();
		
		return true;
	}

	@Override
	public Arquivo buscarArquivoPorID(int id) throws RepositorioException, IOException {
		Arquivo res = null;
		try {
			
			rs = stm.executeQuery("SELECT * FROM arquivos WHERE id_arquivo Like '" + id + "'");
			while(rs.next()) {
				int id_aluno = rs.getInt("id_aluno");
				
				InputStream binaryStream = rs.getBinaryStream("file");
				
				File tempFile = File.createTempFile("pdfFile", "pdf");
			    tempFile.deleteOnExit();
				FileOutputStream out = new FileOutputStream(tempFile);
				IOUtils.copy(binaryStream, out);
				   
				res = new Arquivo(id, id_aluno, tempFile);
			}
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RepositorioException();
		}
	}

	@Override
	public boolean marcarLido(int id) throws RepositorioException {
		try {
			stm.executeUpdate("UPDATE Mensagens SET isRead=" + 1 + " WHERE id_Mensagens Like '" + id + "'");
		}  catch (SQLException e) {
			e.printStackTrace();
			throw new RepositorioException();
		}
		return true;
	}

	@Override
	public ArrayList<Mensagem> buscarMensagensRemetente(int idRemetente)
			throws RepositorioException, NaoExisteMensagensException {
		ArrayList<Mensagem> results = buscarSQLMensagem("SELECT * FROM mensagens WHERE id_Remetente Like '" + idRemetente + "'");
		if (results.size() < 1) { 
			throw new NaoExisteMensagensException();
		}
		
		return results;
	}	
}