package br.com.SGTA.negocio;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.com.SGTA.excecoes.RepositorioException;

public class Fachada implements IFachada {

	private static IFachada instance;
	
	private Fachada(){
		
	}

	public static IFachada getInstance() throws RepositorioException {
		if (Fachada.instance == null) {
			Fachada.instance =  new Fachada();
		}
		return Fachada.instance;
	}

	@Override
	public void adicionarArquivo(String caminho) throws Exception {
		Connection conexao =  DriverManager.getConnection("jdbc:mysql://localhost/teste", "root", "");
		File arq = new File(caminho);
		FileInputStream fis = new FileInputStream(arq);
		
		String sql = "INSERT INTO arquivo" + "(arq, Nome)" + "VALUES (?, ?)";
		
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		stmt.setBinaryStream(1, fis, (int)arq.length());
		stmt.setString(2, "Teste");
		stmt.execute();
		stmt.close();
		
		System.out.println("Inserindo com sucesso");
		
		conexao.close();
		
	}

	@Override
	public void recuperarArquivo(String num) throws Throwable {
		String arqv = "C:\\Users\\Alison\\Desktop\\volta.pdf";
		File arq = new File(arqv);
		FileOutputStream fos = new FileOutputStream(arq);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		Connection conexao =  DriverManager.getConnection("jdbc:mysql://localhost/teste", "root", "");
		String sql = "SELECT arq FROM arquivo WHERE id = " + num;
		java.sql.PreparedStatement ps = conexao.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		rs.first();
		
		InputStream input = rs.getBinaryStream(1);
		byte[] bytes = new byte[input.available()];
		input.read(bytes, 0, input.available());
		bos.write(bytes);
		bos.flush();
		bos.close();
		
		System.out.println("Download completo");
		
		conexao.close();
		
	}
	
	@Override
	public void ListarArquivo(DefaultTableModel modeloTable) throws Throwable {  
	    
		Connection conexao =  DriverManager.getConnection("jdbc:mysql://localhost/teste", "root", "");
		String sql = "SELECT * FROM arquivo";
		java.sql.PreparedStatement ps = conexao.prepareStatement(sql);
		try {  
		
		ResultSet result = ps.executeQuery();  
		  
		int posicao = 0;  

			while (result.next()) {
				modeloTable.insertRow(posicao, new Object[] { result.getString("ID"), result.getString("Nome")});
				posicao++;
			}
		  
		} catch (SQLException e) {  
		e.printStackTrace();  
		throw new Exception("Erro ao Listar CLientes");  
		}  
	}
}
