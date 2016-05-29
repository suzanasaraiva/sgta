package sgta.Repositorio;

import java.sql.ResultSet;

import sgta.Repositorio.Repositorio;

	public class TesteRepositorio {
		public static void main(String[] args) throws Exception {
			Repositorio r = new Repositorio("jdbc:mysql://localhost:3306/sgta",
					"root", "");

			ResultSet rs = r.stm
					.executeQuery("SELECT * FROM pessoas ORDER BY id DESC");
			while (rs.next()) {
				System.out.println(rs.getInt("id"));
			}

		}
	}



