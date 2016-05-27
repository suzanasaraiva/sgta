package Sistema;

import java.util.Date;

public class Agenda {

	private static int numeroAgenda = 0;
	
	public final int idAgenda;
	public final int idUsuario;
	protected Date data;
	
	public Agenda(int idAgenda, int idUsuario, Date data) {
		super();
		this.idAgenda = idAgenda;
		this.idUsuario = idUsuario;
		this.data = data;
	}
	public Agenda( int idUsuario, Date data) {
	
		this.idAgenda = Agenda.numeroAgenda++ ;
		this.idUsuario = idUsuario;
		this.data = data;
	}
	

}
