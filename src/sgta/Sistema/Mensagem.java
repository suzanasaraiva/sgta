package sgta.Sistema;

public class Mensagem {

	private static int numeroMensagens = 0;
	
	public final int idMenasagem;
	public final int idRementente;
	public final int idDestinatario;
	protected String assunto;
	
	boolean isRead() {
		return false;
	}
	
	public Mensagem(int idMenasagem, int idRementente, int idDestinatario,String Assunto) {
		super();
		this.idMenasagem = idMenasagem;
		this.idRementente = idRementente;
		this.idDestinatario = idDestinatario;
		this.assunto = assunto;
	}
	
	
	public Mensagem (int idRementente, int idDestinatario) {
		this.idMenasagem = Mensagem.numeroMensagens++;
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
