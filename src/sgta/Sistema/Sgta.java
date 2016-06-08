package sgta.Sistema;

import java.io.File;

import sgta.Repositorio.DuplicatedUserException;
import sgta.Repositorio.IRepositorio;
import sgta.Repositorio.Repositorio;
import sgta.Repositorio.RepositorioException;
import sgta.Repositorio.UsuarioInexistente;
import sgta.Sistema.InicializacaoSistemaException;
import sgta.Sistema.ISgta;

public class Sgta implements ISgta {
	private IRepositorio repositorio;
	
	private static ISgta instance;
	
	public Sgta() throws InicializacaoSistemaException {
		try {
			this.repositorio = new Repositorio( 
					"jdbc:mysql://localhost:3306/sgta", "root", "");
			System.out.println(this.proximoId());
		} catch (RepositorioException e) {
			throw new InicializacaoSistemaException();
		}
	}
	
	
	public static void main(String[] args) {
		try {
			ISgta i = Sgta.getInstance();
		} catch (InicializacaoSistemaException e) {
			e.printStackTrace();
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
	public int proximoId(){
		try {
			return repositorio.proximoId();
		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void adicionarAluno(int id, String nome, String cpf, String senha, String email, String matricula) throws DuplicatedUserException, RepositorioException {
		Aluno aluno = new Aluno(id, nome, cpf, senha, email, matricula);
		repositorio.adicionarUsuario(aluno);
	}

	@Override
	public void adicionarProfessor(int id, String nome, String cpf, String senha, String email, String matricula) throws DuplicatedUserException, RepositorioException {
		Professor professor = new Professor(id, nome, cpf, senha, email, matricula);
		repositorio.adicionarUsuario(professor);
	}

	@Override
	public void adicionarAdministrador(int id, String nome, String cpf, String senha, String email, String matricula) throws DuplicatedUserException, RepositorioException {
		Administrador administrador = new Administrador(id, nome, cpf, senha, email, matricula);
		repositorio.adicionarUsuario(administrador);
	}


	@Override
	public Usuario buscarUsuarioPorCPF(String cpf) throws RepositorioException, UsuarioInexistente {
		return repositorio.buscarCPF(cpf);
	}
	

	}

