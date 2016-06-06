package sgta.Repositorio;

import sgta.Repositorio.Repositorio;
import sgta.Sistema.Aluno;

public class TesteRepositorio {
	public static void main(String[] args) throws Exception {

		System.out.println("Test");
		try {
			Repositorio repo = new Repositorio("jdbc:mysql://localhost:3306/sgta", "root", "senha");
/*
			Aluno a1 = new Aluno(repo.proximoId(), "Luiz", "082.323.434-78", "senhamassa", "luiz@gmail.com",
					"082.323.434-78");
			Aluno a2 = new Aluno(repo.proximoId(), "Luiz", "082.323.434-78", "senhamassa", "luiz@gmail.com",
					"082.323.434-78");

			repo.adicionarUsuario(a1);
			repo.adicionarUsuario(a2);
			*/
			
			repo.buscarCPF("082.323.434-78");
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * Connection conn; Statement stm; ResultSet rs;
		 * 
		 * Class.forName("com.mysql.jdbc.Driver"); conn =
		 * DriverManager.getConnection("jdbc:mysql://localhost:3306/sgta",
		 * "root", "senha"); stm = conn.createStatement();
		 * 
		 * int id = 1; String name = "Luiz"; String cpf = "082.323.434-78";
		 * String email = "luiz@gmail.com"; String senha = "senhamassa"; String
		 * nomeClasse = "Aluno";
		 * 
		 * for (int i = 0; i < 5; i++) { stm.executeUpdate(
		 * "INSERT INTO Usuarios (id, Nome, CPF, Senha,  email, Matricula, tipo) VALUES"
		 * + "('" + i + "', '" + name + "', '" + cpf + "', '" + senha + "', '" +
		 * email + "', '" + cpf + "', '" + nomeClasse + "')"); }
		 * 
		 * rs = stm.executeQuery("SELECT * FROM usuarios ORDER BY id DESC");
		 * while (rs.next()) { System.out.println( "ID: " + rs.getInt("id") +
		 * " Nome: " + rs.getString("Nome") + " CPF: " + rs.getString("CPF")); }
		 */
	}
}
