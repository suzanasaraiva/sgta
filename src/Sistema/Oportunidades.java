package Sistema;

import java.sql.Date;

public class Oportunidades {
	private static int numOportunidades = 0;

	public final int idOportunidade;
	public final int idProfessor;
	protected int num_vagas;
	protected int num_vagas_restantes;
	protected String descricao;
	protected String tipo_bolsa;
	protected int valor_bolsa;
	protected Date duração;
	protected String requisitos;
	
	public Oportunidades(int idOportunidade, int idOrientador, int num_vagas, int num_vagas_restantes, String descricao,
			String tipo_bolsa, int valor_bolsa, Date duração, String requisitos) {
		super();
		this.idOportunidade = idOportunidade;
		this.idProfessor = idOrientador;
		this.num_vagas = num_vagas;
		this.num_vagas_restantes = num_vagas_restantes;
		this.descricao = descricao;
		this.tipo_bolsa = tipo_bolsa;
		this.valor_bolsa = valor_bolsa;
		this.duração = duração;
		this.requisitos = requisitos;
	}
	public Oportunidades( int idOrientador, int num_vagas, int num_vagas_restantes, String descricao,
			String tipo_bolsa, int valor_bolsa, Date duração, String requisitos) {
		super();
		this.idOportunidade = Oportunidades.numOportunidades++;
		this.idProfessor = idOrientador;
		this.num_vagas = num_vagas;
		this.num_vagas_restantes = num_vagas_restantes;
		this.descricao = descricao;
		this.tipo_bolsa = tipo_bolsa;
		this.valor_bolsa = valor_bolsa;
		this.duração = duração;
		this.requisitos = requisitos;
	}
	
	
}
