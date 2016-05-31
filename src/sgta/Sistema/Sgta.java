package sgta.Sistema;

import sgta.Repositorio.Repositorio;
import sgta.Repositorio.RepositorioException;
import sgta.Sistema.InicializacaoSistemaException;
import sgta.Sistema.ISgta;

public class Sgta implements ISgta {
	private Repositorio repositorio;
	
	private static ISgta instance;
	
	public Sgta() throws InicializacaoSistemaException {
		try {
			this.repositorio = new Repositorio( 
					"jdbc:mysql://localhost:3306/sgta", "root", "senha");
			System.out.println(this.proximoId());
		} catch (RepositorioException e) {
			throw new InicializacaoSistemaException();
		}
	}
	
	
	public static void main(String[] args) {
		try {
			ISgta i = Sgta.getInstance();
		} catch (InicializacaoSistemaException e) {
			// TODO Auto-generated catch block
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
	
	public int proximoId(){
		try {
			return repositorio.proximoId();
		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public void adicionarAluno(int id, String nome, String cpf, String senha, String email, String matricula) {
		Aluno aluno = new Aluno(id, nome, cpf, senha, email, matricula);
		repositorio.adicionarAluno(aluno);
	}

	public void adicionarProfessor(String nome, String cpf, String senha, String email, String matricula) {
		Professor professor = new Professor(nome, cpf, senha, email, matricula);
		repositorio.adicionarProfessor(professor);
	}

	public void adicionarAdministrador(String nome, String cpf, String senha, String email, String matricula) {
		Administrador administrador = new Administrador(nome, cpf, senha, email, matricula);
		repositorio.adicionarAdministrador(administrador);
	}

	public static void adicionarAluno() {
		// TODO Auto-generated method stub

	}


	@Override
	public void adicionarPofessor(int id, String nome, String cpf, String senha, String email, String matricula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adicionarAdministrador(int id, String nome, String cpf, String senha, String email, String matricula) {
		// TODO Auto-generated method stub
		
	}

}