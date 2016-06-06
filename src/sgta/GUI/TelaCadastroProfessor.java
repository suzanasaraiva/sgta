package sgta.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sgta.Sistema.ISgta;
import sgta.Sistema.InicializacaoSistemaException;
import sgta.Sistema.Sgta;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class TelaCadastroProfessor extends JFrame {
	private JPasswordField password1;
	private JPasswordField password2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProfessor frame = new TelaCadastroProfessor();
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
	public TelaCadastroProfessor() {
		setTitle("Cadastro de Professor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 378, 410);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Nome");
		label.setBounds(63, 91, 94, 16);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(169, 88, 139, 22);
		getContentPane().add(textField);
		
		JLabel label_1 = new JLabel("Cpf");
		label_1.setBounds(63, 126, 94, 16);
		getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(169, 123, 139, 22);
		getContentPane().add(textField_1);
		
		JLabel label_2 = new JLabel("Email");
		label_2.setBounds(63, 164, 94, 16);
		getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(169, 158, 139, 22);
		getContentPane().add(textField_2);
		
		JLabel label_3 = new JLabel("Senha");
		label_3.setBounds(63, 196, 56, 16);
		getContentPane().add(label_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(169, 193, 139, 22);
		getContentPane().add(passwordField);
		
		JLabel label_4 = new JLabel("Confirma Senha");
		label_4.setBounds(58, 231, 94, 16);
		getContentPane().add(label_4);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(169, 228, 139, 22);
		getContentPane().add(passwordField_1);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textField.getText();
				String cpf = textField_1.getText();
				String email= textField_2.getText();
				String senha= passwordField.getText();
				String confirma= passwordField.getText();
					try {
						ISgta sgta = Sgta.getInstance();
						sgta.adicionarAluno(sgta.proximoId(), nome, cpf, senha, email, cpf);					} catch (InicializacaoSistemaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
				
					}
	
		});
		btnCadastrar.setBounds(65, 301, 105, 25);
		getContentPane().add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro tc1  = new TelaCadastro();
				tc1.setVisible(true);
				dispose();
			}
			
		});
		btnVoltar.setBounds(208, 301, 114, 25);
		getContentPane().add(btnVoltar);
		
		JLabel label_6 = new JLabel("Insira seus dados");
		label_6.setBounds(21, 41, 149, 16);
		getContentPane().add(label_6);
		
		JLabel label_5 = new JLabel("Confirma Senha");
		JPasswordField passwordFieldsenha;
		JPasswordField passwordFieldconfirma;
	}
}
