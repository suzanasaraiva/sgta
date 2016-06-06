package sgta.GUI;

import sgta.Sistema.Aluno;
import sgta.Sistema.Usuario;

public class TestClasses {

	public static void main(String[] args) {
		Usuario u = new Aluno(1, "Luiz", "09", "123", "luiz@gmail.com", "09");
		System.out.println(u.getClass().getSimpleName());
	}
}
