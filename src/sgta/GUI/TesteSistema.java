package sgta.GUI;

import sgta.Sistema.InicializacaoSistemaException;

public class TesteSistema {

	public static void main(String[] args) throws InicializacaoSistemaException {
		Sistema system = new Sistema();
		
		system.run();
	}

}
