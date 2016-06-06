package sgta.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sgta.Sistema.Aluno;
import sgta.Sistema.ISgta;
import sgta.Sistema.InicializacaoSistemaException;
import sgta.Sistema.Usuario;
import sgta.Sistema.Sgta;
import sgta.Repositorio.Repositorio;
import sgta.Repositorio.IRepositorio;


import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;



public class TelaCadastroAluno extends JFrame {
	private JPanel contentPane;
	private JTextField jtfnome;
	private JTextField jtfcpf;
	private JLabel lblNome;
	private JLabel lblNewLabel;
	private JTextField jtfemail;
	private JLabel lblNewLabel_1;
	private JLabel lblInsiraOsDados;
	private JButton btnCadastrar;
	private JButton btnSair;
	private JPasswordField passwordFieldsenha;
	private JPasswordField passwordFieldconfirma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroAluno frame = new TelaCadastroAluno();
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
	public TelaCadastroAluno() {
		setTitle("Cadastro de Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jtfnome = new JTextField();
		jtfnome.setBounds(163, 82, 139, 22);
		contentPane.add(jtfnome);
		jtfnome.setColumns(10);
		
		jtfcpf = new JTextField();
		jtfcpf.setBounds(163, 117, 139, 22);
		contentPane.add(jtfcpf);
		jtfcpf.setColumns(10);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(57, 85, 94, 16);
		contentPane.add(lblNome);
		
		lblNewLabel = new JLabel("Cpf");
		lblNewLabel.setBounds(57, 120, 94, 16);
		contentPane.add(lblNewLabel);
		
		jtfemail = new JTextField();
		jtfemail.setBounds(163, 152, 139, 22);
		contentPane.add(jtfemail);
		jtfemail.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(57, 158, 94, 16);
		contentPane.add(lblNewLabel_1);
		
		lblInsiraOsDados = new JLabel("Insira seus dados");
		lblInsiraOsDados.setBounds(17, 31, 149, 16);
		contentPane.add(lblInsiraOsDados);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = jtfnome.getText();
				String cpf = jtfcpf.getText();
				String email= jtfemail.getText();
				String senha= passwordFieldsenha.getText();
				String confirma= passwordFieldconfirma.getText();
					try {
						ISgta sgta = Sgta.getInstance();
						sgta.adicionarAluno(sgta.proximoId(), nome, cpf, senha, email, cpf);
					} catch (InicializacaoSistemaException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
				
					}
		});
		btnCadastrar.setBounds(41, 279, 114, 30);
		contentPane.add(btnCadastrar);
		
		btnSair = new JButton("Voltar");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro tc  = new TelaCadastro();
				tc.setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(204, 279, 114, 30);
		contentPane.add(btnSair);
		
		passwordFieldsenha = new JPasswordField();
		passwordFieldsenha.setBounds(163, 187, 139, 22);
		contentPane.add(passwordFieldsenha);
		
		passwordFieldconfirma = new JPasswordField();
		passwordFieldconfirma.setBounds(163, 222, 139, 22);
		contentPane.add(passwordFieldconfirma);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(57, 190, 56, 16);
		contentPane.add(lblSenha);
		
		JLabel lblConfirmaSenha = new JLabel("Confirma Senha");
		lblConfirmaSenha.setBounds(52, 225, 94, 16);
		contentPane.add(lblConfirmaSenha);
	}
}
