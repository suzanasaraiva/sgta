package sgta.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import sgta.Repositorio.RepositorioException;
import sgta.Sistema.Arquivo;
import sgta.Sistema.ISgta;
import sgta.Sistema.InicializacaoSistemaException;
import sgta.Sistema.Mensagem;
import sgta.Sistema.Sgta;
import sgta.Sistema.Trabalho;
import sgta.util.Message;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Button;

public class TelaSubmeterTrabalho extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnVoltar;
	private JLabel lblTitulo;
	private JLabel lblTema;
	private JLabel lblArquivo;
	private TextField textFieldPath;
	private TextField textFieldTitulo;
	private TextField textFieldTema;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSubmeterTrabalho frame = new TelaSubmeterTrabalho();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public TelaSubmeterTrabalho() {
		setTitle("Submeter Trabalho");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnResponder = new JButton("Submeter");
		btnResponder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = textFieldTitulo.getText();
				String area = textFieldTema.getText();
				int idUsuario = Sgta.usuario.getIdUsuario();
				
				ISgta sgta;
				try {
					sgta = Sgta.getInstance();
					Trabalho trabalho = new Trabalho(sgta.proximoTrabalhoId(), titulo, area, idUsuario);
					File file = new File(textFieldPath.getText());
					Arquivo arquivo = new Arquivo(sgta.proximoArquivoId(), idUsuario, file);
					
					sgta.adicionarTrabalho(trabalho);
					sgta.adicionarArquivo(arquivo, trabalho.getIdTrabalho());
					
					Message.infoBox("Trabalho submetido com sucesso", "Sucesso");
					
					TelaPrincipal tela = new TelaPrincipal();
					tela.setVisible(true);
					dispose();
				} catch (InicializacaoSistemaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RepositorioException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnResponder.setBounds(22, 231, 117, 29);
		contentPane.add(btnResponder);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tela = new TelaPrincipal();
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(305, 231, 117, 29);
		contentPane.add(btnVoltar);
		
		lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(22, 16, 55, 16);
		contentPane.add(lblTitulo);
		
		lblTema = new JLabel("Tema:");
		lblTema.setBounds(22, 60, 55, 16);
		contentPane.add(lblTema);
		
		textFieldTitulo = new TextField();
		textFieldTitulo.setBounds(88, 16, 334, 22);
		contentPane.add(textFieldTitulo);
		
		textFieldTema = new TextField();
		textFieldTema.setBounds(88, 60, 334, 22);
		contentPane.add(textFieldTema);
		
		lblArquivo = new JLabel("Arquivo:");
		lblArquivo.setBounds(22, 105, 55, 16);
		contentPane.add(lblArquivo);
		
		Button button = new Button("Selecionar Arquivo");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de PDF", "pdf");
				JFileChooser c = new JFileChooser();
				c.setFileFilter(filter);
				int rVal = c.showOpenDialog(TelaSubmeterTrabalho.this);
			    if (rVal == JFileChooser.APPROVE_OPTION) {
			    	String filePath = c.getCurrentDirectory().toString();
			    	String fileName = c.getSelectedFile().getName();
			    	if (fileName.toLowerCase().endsWith("pdf")) {
			    		textFieldPath.setText(filePath + "/" + fileName);
			    	} else {
			    		Message.infoBox("Por favor, escolha um arquivo PDF", "Erro");
			    	}
			      }
			}
		});
		button.setBounds(261, 139, 161, 29);
		contentPane.add(button);
		
		textFieldPath = new TextField();
		textFieldPath.setEditable(false);
		textFieldPath.setBounds(88, 105, 334, 22);
		contentPane.add(textFieldPath);
	}
}
