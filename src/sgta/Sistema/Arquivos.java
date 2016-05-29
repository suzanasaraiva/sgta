package sgta.Sistema;

public class Arquivos {
	
private static int numeroArquivos = 0;
	
	public final int idArquivos;
	public final int idAluno;
	
	public Arquivos(int idArquivos, int idAluno) {
		super();
		this.idArquivos = idArquivos;
		this.idAluno = idAluno;
	}
	
	public Arquivos( int idAluno) {
	
		this.idArquivos = Arquivos.numeroArquivos++;
		this.idAluno = idAluno;
	}	
}
