package sgta.Repositorio;

import java.util.ArrayList;

import sgta.Sistema.Aluno;
import sgta.Sistema.Professor;
import sgta.Sistema.Trabalhos;
import sgta.Sistema.Usuario;

public interface IRepositorio {
	

	boolean adicionarAluno( Aluno Aluno);
	boolean adicionarProfessor( Professor Professor);
	boolean adicionarAdministrador();
	
	
	boolean remover(int id);
	
	boolean atualizar(int id, Usuario Usuario);
	
	ArrayList<Usuario> buscarNome(String nome);
	
	ArrayList<Usuario> buscarId(int id);
	
	
	boolean adicionarTrabalho(Trabalhos trabalho);
	
	boolean removerTrabalho(int id);
	
	ArrayList<Trabalhos> buscarTrabalhoTitulo(String titulo);
	
	ArrayList<Trabalhos> buscarTrabalhoAutor(String idUsuario);
	
	ArrayList<Trabalhos> buscarTrabalhoTema(String tema);
	
	ArrayList<Trabalhos> buscarTrabalho();
	
}
