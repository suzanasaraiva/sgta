package sgta.Sistema;

public class Mensagem {
	
	protected final int idMenasagem;
	protected final int idRementente;
	protected final int idDestinatario;
	protected String assunto;
	protected String mensagem;
	protected boolean isRead;
	
	public Mensagem(int idMenasagem, int idRementente, int idDestinatario, String assunto, String mensagem, boolean isRead) {
		super();
		this.idMenasagem = idMenasagem;
		this.idRementente = idRementente;
		this.idDestinatario = idDestinatario;
		this.assunto = assunto;
		this.mensagem = mensagem;
		this.isRead = isRead;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
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
