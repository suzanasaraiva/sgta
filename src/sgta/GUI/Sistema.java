package sgta.GUI;

import sgta.Sistema.ISgta;
import sgta.Sistema.InicializacaoSistemaException;
import sgta.Sistema.Sgta;

public class Sistema {
	
	ISgta sgta;
	
	public Sistema() throws InicializacaoSistemaException {
		this.sgta = new Sgta();
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}


}
