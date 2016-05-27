package Sistema;

import java.sql.Date;

public class Publicacoes {

private static int numeroPublicacoes = 0;
	
	public final int idPublicacao;
	protected String nome;
	protected String descricao;
	protected String categoria;
	protected String requisitos;
	protected String qualis;
	protected Date data_submissao;
	protected Date data_Evento;
	
	public Publicacoes(int idPublicacao, String nome, String descricao, String categoria, String requisitos,
			String qualis, Date data_submissao, Date data_Evento) {
		super();
		this.idPublicacao = idPublicacao;
		this.nome = nome;
		this.descricao = descricao;
		this.categoria = categoria;
		this.requisitos = requisitos;
		this.qualis = qualis;
		this.data_submissao = data_submissao;
		this.data_Evento = data_Evento;
	}

	
	public Publicacoes(String nome, String descricao, String categoria, String requisitos,
			String qualis, Date data_submissao, Date data_Evento) {
		this.idPublicacao = Publicacoes.numeroPublicacoes++;
		this.nome = nome;
		this.descricao = descricao;
		this.categoria = categoria;
		this.requisitos = requisitos;
		this.qualis = qualis;
		this.data_submissao = data_submissao;
		this.data_Evento = data_Evento;
	}
	
}
