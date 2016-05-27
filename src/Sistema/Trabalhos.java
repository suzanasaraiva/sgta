package Sistema;

public class Trabalhos {
	
private static int numeroTrabalhos = 0;
	
	public final int idTrabalho;
	protected String titulo;
	protected String area;
	public final int idUsuario;
	
	public Trabalhos(int idTrabalho, String titulo, String area, int idUsuario) {
		super();
		this.idTrabalho = idTrabalho;
		this.titulo = titulo;
		this.area = area;
		this.idUsuario = idUsuario;
	}
	
	public Trabalhos (String titulo, String area, int idUsuario) {
		this.idTrabalho = Trabalhos.numeroTrabalhos++;
		this.titulo = titulo;
		this.area = area;
		this.idUsuario = idUsuario;
	}
	
	
}
