package sgta.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sgta.Sistema.Aluno;
import sgta.Sistema.Usuario;
import sgta.Sistema.sgta;
import sgta.Repositorio.Repositorio;
import sgta.Repositorio.IRepositorio;


import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class TelaCadastroAluno extends JFrame {
	private JPanel contentPane;
	private JTextField jtfId;
	private JTextField jtfSenha;
	private JTextField jtfCpf;
	private JLabel lblId;
	private JLabel lblNome;
	private JLabel lblNewLabel;
	private JTextField jtfNome;
	private JLabel lblSenha;
	private JLabel lblNewLabel_1;
	private JTextField jtfEmail;
	private JLabel lblInsiraOsDados;
	private JButton btnCadastrar;
	private JButton btnSair;
	private JLabel label;
	private JTextField jtfMatricula;

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
		
		jtfId = new JTextField();
		jtfId.setBounds(147, 69, 139, 22);
		contentPane.add(jtfId);
		jtfId.setColumns(10);
		
		jtfSenha = new JTextField();
		jtfSenha.setBounds(147, 107, 139, 22);
		contentPane.add(jtfSenha);
		jtfSenha.setColumns(10);
		
		jtfCpf = new JTextField();
		jtfCpf.setBounds(147, 177, 139, 22);
		contentPane.add(jtfCpf);
		jtfCpf.setColumns(10);
		
		lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(52, 60, 94, 39);
		contentPane.add(lblId);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(52, 145, 94, 16);
		contentPane.add(lblNome);
		
		lblNewLabel = new JLabel("Cpf");
		lblNewLabel.setBounds(52, 180, 94, 16);
		contentPane.add(lblNewLabel);
		
		jtfNome = new JTextField();
		jtfNome.setBounds(147, 142, 139, 22);
		contentPane.add(jtfNome);
		jtfNome.setColumns(10);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(52, 110, 114, 16);
		contentPane.add(lblSenha);
		
		lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(52, 215, 94, 16);
		contentPane.add(lblNewLabel_1);
		
		jtfEmail = new JTextField();
		jtfEmail.setBounds(147, 212, 139, 22);
		contentPane.add(jtfEmail);
		jtfEmail.setColumns(10);
		
		lblInsiraOsDados = new JLabel("Insira seus dados");
		lblInsiraOsDados.setBounds(17, 31, 149, 16);
		contentPane.add(lblInsiraOsDados);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String  id= jtfId.getText();
				String nome = jtfNome.getText();
				String cpf = jtfCpf.getText();
				String senha= jtfSenha.getText();
				String email= jtfEmail.getText();
				String matricula= jtfMatricula.getText();
					sgta.adicionarAluno();
			
				
					}
		});
		btnCadastrar.setBounds(52, 295, 114, 30);
		contentPane.add(btnCadastrar);
		
		btnSair = new JButton("Voltar");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro tc  = new TelaCadastro();
				tc.setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(205, 295, 114, 30);
		contentPane.add(btnSair);
		
		label = new JLabel("Matr\u00EDcula");
		label.setBounds(52, 251, 94, 16);
		contentPane.add(label);
		
		jtfMatricula = new JTextField();
		jtfMatricula.setColumns(10);
		jtfMatricula.setBounds(147, 249, 139, 22);
		contentPane.add(jtfMatricula);
	}
}
