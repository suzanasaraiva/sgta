package Sistema;

public class Aluno {

private int id;
	private String senha;
	private String nomeAluno;
	private String cpfAluno;
	private String matriculaAluno;

	public Aluno(int id,String senha,String nomeAluno,String cpfAluno,String matriculaAluno){
		this.id=id;
		this.senha=senha;
		this.nomeAluno=nomeAluno;
		this.cpfAluno=cpfAluno;
		this.matriculaAluno=matriculaAluno;
	}
}