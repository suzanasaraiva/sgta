package sgta.Repositorio;

import java.io.File;

import sgta.Repositorio.Repositorio;
import sgta.Sistema.Arquivo;

public class TesteRepositorio {
	public static void main(String[] args) throws Exception {

		System.out.println("Test");
		try {
			Repositorio repo = new Repositorio("jdbc:mysql://localhost:3306/sgta", "root", "senha");

//			File f = new File("C:\\Users\\Suzana\\Desktop\\test.txt");
				
//			File f = new File("/Users/luizdaniel/Downloads/stanley.ec02.pdf");
			
//			Arquivo arq = new Arquivo(5,4, f);
			
//			repo.adicionarArquivo(arq);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
