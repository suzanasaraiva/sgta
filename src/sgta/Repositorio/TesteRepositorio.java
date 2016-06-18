package sgta.Repositorio;

import java.io.File;

import sgta.Repositorio.Repositorio;
import sgta.Sistema.Arquivo;

public class TesteRepositorio {
	public static void main(String[] args) throws Exception {

		System.out.println("Test");
		try {
			Repositorio repo = new Repositorio("jdbc:mysql://localhost:3306/sgta", "root", "");

			File f = new File("C:\\Users\\Suzana\\Desktop\\test.txt");
			
			Arquivo arq = new Arquivo(4,3, f);
			
			repo.adicionarArquivo(arq);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
