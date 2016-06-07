package sgta.Sistema;

public class Mensagens {

	private static int numeroMensagens = 0;
	
	public final int idMenasagem;
	public final int idRementente;
	public final int idDestinatario;
	protected String assunto;
	
	boolean isRead() {
		return false;
	}
	
	public Mensagens(int idMenasagem, int idRementente, int idDestinatario,String Assunto) {
		super();
		this.idMenasagem = idMenasagem;
		this.idRementente = idRementente;
		this.idDestinatario = idDestinatario;
		this.assunto = assunto;
	}
	
	
	public Mensagens (int idRementente, int idDestinatario) {
		this.idMenasagem = Mensagens.numeroMensagens++;
		this.idRementente = idRementente;
		this.idDestinatario = idDestinatario;
		this.assunto = assunto;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public int getIdMenasagem() {
		return idMenasagem;
	}

	public int getIdRementente() {
		return idRementente;
	}

	public int getIdDestinatario() {
		return idDestinatario;
	}
	
	


}
