package sgta.Repositorio;
import sgta.Sistema.Usuario;

import sgta.Sistema.Aluno;
import sgta.Sistema.Professor;
import sgta.Sistema.Administrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;


public class Repositorio {
	Connection conn;
	Statement stm;
	ResultSet rs;

	public Repositorio(String host, String pass, String user) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(host, user, pass);
			stm = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Usuario> buscarSQL(String query) {
		ArrayList<Usuario> res = new ArrayList<Usuario>();
		try {
			rs = stm.executeQuery(query);
			String tipo = rs.getString("tipo");
			while (rs.next()) {
				if (tipo.equals("Aluno")) {
					res.add(new Aluno(rs.getInt("id"),rs.getString("nome"),rs.getString("cpf"),
							rs.getString("senha"),rs.getString("email"), rs.getString("matricula")));
					
				
					
				} else if (tipo.equals("Professor")) {
					res.add(new Professor(rs.getInt("id"),rs.getString("nome"),rs.getString("cpf"),
							rs.getString("senha"),rs.getString("email"), rs.getString("matricula")));
					
				} else if (tipo.equals("Administrador")) {
					res.add(new Administrador(rs.getInt("id"),rs.getString("nome"),rs.getString("cpf"),
							rs.getString("senha"),rs.getString("email"), rs.getString("matricula")));
					
				
				}
			}
			return res;
		} catch (SQLException e) {
			return null;
		}
}

	
	public boolean adicionarAluno(Aluno aluno) {
		try {
			stm.executeUpdate("INSERT INTO Usuarios (id, nome, cpf, senha,  email, matricula) VALUES"
					+ "('"
					+ aluno.getIdUsuario()
					+ "', '"
					+ aluno.getNome()
					+ "', '"
					+ aluno.getCpf()
					+ "', '"
					+ aluno.getSenha()
					+ "', '"
					+ aluno.getEmail()
					+ "', '"
					+ aluno.getMatricula()
					+ "', '"
					+ aluno.getClass().getSimpleName() + "')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}public boolean adicionarProfessor(Professor professor) {
		try {
			stm.executeUpdate("INSERT INTO Usuarios (id, nome, cpf, senha,  email, matricula) VALUES"
					+ "('"
					+ professor.getIdUsuario()
					+ "', '"
					+ professor.getNome()
					+ "', '"
					+ professor.getCpf()
					+ "', '"
					+ professor.getSenha()
					+ "', '"
					+ professor.getEmail()
					+ "', '"
					+ professor.getMatricula()
					+ "', '"
					+ professor.getClass().getSimpleName() + "')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}public boolean adicionarAdministrador(Administrador administrador) {
		try {
			stm.executeUpdate("INSERT INTO Usuarios (id, nome, cpf, senha,  email, matricula) VALUES"
					+ "('"
					+ administrador.getIdUsuario()
					+ "', '"
					+ administrador.getNome()
					+ "', '"
					+ administrador.getCpf()
					+ "', '"
					+ administrador.getSenha()
					+ "', '"
					+ administrador.getEmail()
					+ "', '"
					+ administrador.getMatricula()
					+ "', '"
					+ administrador.getClass().getSimpleName() + "')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean remover(int id) {
		try {
			stm.executeUpdate("REMOVE * FROM usuario WHERE id Like '" + id
					+ "'");
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}
	
}
