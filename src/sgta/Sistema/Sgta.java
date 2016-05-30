package sgta.Sistema;

import sgta.Repositorio.Repositorio;
import sgta.Repositorio.RepositorioException;
import sgta.Sistema.InicializacaoSistemaException;
import sgta.Sistema.ISgta;
 
 public abstract class Sgta implements ISgta{
	 private Repositorio repositorio;
	 private static ISgta instance;
	
		public void adicionarAluno(int id, String nome, String cpf, String senha, String email, String matricula){
			Aluno aluno = new Aluno( nome, cpf, senha, email, matricula);
			repositorio.adicionarAluno(aluno);
		}
	 public void adicionarProfessor( String nome, String cpf, String senha, String email, String matricula){
			Professor professor = new Professor( nome, cpf, senha, email, matricula);
			repositorio.adicionarProfessor(professor);
		}
		public void adicionarAdministrador( String nome, String cpf, String senha, String email, String matricula){
			Administrador administrador = new Administrador( nome, cpf, senha, email, matricula);
			repositorio.adicionarAdministrador(administrador);
		}
		public static void adicionarAluno() {
			// TODO Auto-generated method stub
			
		}
 
 }
 
 


 