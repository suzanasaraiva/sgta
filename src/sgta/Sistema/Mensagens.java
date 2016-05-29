package sgta.Sistema;

public class Mensagens {

	private static int numeroMensagens = 0;
	
	public final int idMenasagem;
	public final int idRementente;
	public final int idDestinatario;
	
	public Mensagens(int idMenasagem, int idRementente, int idDestinatario) {
		super();
		this.idMenasagem = idMenasagem;
		this.idRementente = idRementente;
		this.idDestinatario = idDestinatario;
	}
	
	
	public Mensagens (int idRementente, int idDestinatario) {
		this.idMenasagem = Mensagens.numeroMensagens++;
		this.idRementente = idRementente;
		this.idDestinatario = idDestinatario;
	}
	


}
