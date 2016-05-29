package sgta.Sistema;

import java.sql.Date;

public class Banca {

private static int numeroBanca = 0;
	
	public final int idBanca;
	public final int idTrabalho;
	public final int idProfessor;
	public final int idAluno;
	protected Date data;
	
	public Banca(int idBanca, int idTrabalho, int idOrientador, int idAluno, Date data) {
		super();
		this.idBanca = idBanca;
		this.idTrabalho = idTrabalho;
		this.idProfessor = idOrientador;
		this.idAluno = idAluno;
		this.data = data;
	}
	
	public Banca( int idTrabalho, int idOrientador, int idAluno, Date data) {
		super();
		this.idBanca = Banca.numeroBanca++;
		this.idTrabalho = idTrabalho;
		this.idProfessor = idOrientador;
		this.idAluno = idAluno;
		this.data = data;
	}
	
}
