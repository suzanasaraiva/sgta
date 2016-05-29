package sgta.Sistema;

import sgta.Repositorio.Repositorio;
import sgta.Repositorio.RepositorioException;
import sgta.Sistema.InicializacaoSistemaException;
import sgta.Sistema.ISgta;
 
 public abstract class sgta implements ISgta{
	 private Repositorio repositorio;
	 private static ISgta instance;
	
		public void adicionarAluno(int id, String nome, String cpf, String senha, String email, String matricula){
			Aluno aluno = new Aluno(id, nome, cpf, senha, email, matricula);
			repositorio.adicionarAluno(aluno);
		}
	 public void adicionarProfessor(int id, String nome, String cpf, String senha, String email, String matricula){
			Professor professor = new Professor(id, nome, cpf, senha, email, matricula);
			repositorio.adicionarProfessor(professor);
		}
		public void adicionarAdministrador(int id, String nome, String cpf, String senha, String email, String matricula){
			Administrador administrador = new Administrador(id, nome, cpf, senha, email, matricula);
			repositorio.adicionarAdministrador(administrador);
		}
		public static void adicionarAluno() {
			// TODO Auto-generated method stub
			
		}
 
 }
 
 


 