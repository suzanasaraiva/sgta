package sgta.Sistema;

import java.sql.Date;

public class Oportunidades {
	private static int numOportunidades = 0;

	public final int idOportunidade;
	public final int idProfessor;
	protected String num_vagas;
	protected int num_vagas_restantes;
	protected String descricao;
	protected String tipo_bolsa;
	protected int valor_bolsa;
	protected String duracao;
	protected String requisitos;
	
	public Oportunidades(int idOportunidade, int idOrientador, String num_vagas, String descricao, String tipo_bolsa,
			int valor_bolsa, String duracao, String requisitos) {
		super();
		this.idOportunidade = Oportunidades.numOportunidades++;
		this.idProfessor = idOrientador;
		this.num_vagas = num_vagas;
		this.num_vagas_restantes = num_vagas_restantes;
		this.descricao = descricao;
		this.tipo_bolsa = tipo_bolsa;
		this.valor_bolsa = valor_bolsa;
		this.duracao = duracao;
		this.requisitos = requisitos;
	}
	
	public String getIdOportunidade() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getTipo_bolsa() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getNum_vagas() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getDuracao() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getRequisitos() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getIdOrientador() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getDescricao() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
