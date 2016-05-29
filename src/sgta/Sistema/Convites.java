package sgta.Sistema;

public class Convites {
	
	private static int numeroConvites = 0;
	
	public final int idConvite;
	public final int idConvidante;
	public final int idConvidado;
	protected String tipo_convite;
	public final int idtrabalho;
	

	public Convites(int idConvite, int idConvidante, int idConvidado, String tipo_convite, int idtrabalho) {
		super();
		this.idConvite = idConvite;
		this.idConvidante = idConvidante;
		this.idConvidado = idConvidado;
		this.tipo_convite = tipo_convite;
		this.idtrabalho = idtrabalho;
		
		
	}		
	public Convites(int idConvidante, int idConvidado, String tipo_convite, int idtrabalho) {
		super();
		this.idConvite = Convites.numeroConvites++;
		this.idConvidante = idConvidante;
		this.idConvidado = idConvidado;
		this.tipo_convite = tipo_convite;
		this.idtrabalho = idtrabalho;
	}
}