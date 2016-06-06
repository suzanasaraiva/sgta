package sgta.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import sgta.Repositorio.DuplicatedUserException;
import sgta.Repositorio.RepositorioException;
import sgta.Sistema.ISgta;
import sgta.Sistema.InicializacaoSistemaException;
import sgta.Sistema.Sgta;
import sgta.util.EmailValidator;
import sgta.util.Message;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class TelaCadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nameTextField;
	private JTextField cpfTextField;
	private JTextField emailTextField;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	private JRadioButton rdbtnAluno;
	private JRadioButton rdbtnProfessor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setTitle("Cadastro de Professor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 378, 410);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("Nome");
		label.setBounds(40, 91, 94, 16);
		getContentPane().add(label);

		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(169, 88, 139, 22);
		getContentPane().add(nameTextField);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(40, 126, 94, 16);
		getContentPane().add(lblCpf);
		
		MaskFormatter txtFormatCpf;
		try {
			txtFormatCpf = new MaskFormatter("###.###.###-##");
			cpfTextField = new JFormattedTextField(txtFormatCpf);
			cpfTextField.setColumns(10);
			cpfTextField.setBounds(169, 123, 139, 22);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um problema na formatacao.");
		}
		getContentPane().add(cpfTextField);
		

		JLabel label_2 = new JLabel("Email");
		label_2.setBounds(40, 161, 94, 16);
		getContentPane().add(label_2);

		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(169, 158, 139, 22);
		getContentPane().add(emailTextField);
	
		JLabel label_3 = new JLabel("Senha");
		label_3.setBounds(40, 196, 56, 16);
		getContentPane().add(label_3);

		passwordField = new JPasswordField();
		passwordField.setBounds(169, 193, 139, 22);
		getContentPane().add(passwordField);

		JLabel label_4 = new JLabel("Confirma Senha");
		label_4.setBounds(40, 231, 117, 16);
		getContentPane().add(label_4);

		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(169, 228, 139, 22);
		getContentPane().add(confirmPasswordField);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = nameTextField.getText();
				String cpf = cpfTextField.getText();
				String email = emailTextField.getText();
				String senha = String.valueOf(passwordField.getPassword());
				String confirma = String.valueOf(confirmPasswordField.getPassword());
				
				if (nome.isEmpty() || cpf.equals("   .   .   -  ") || email.isEmpty() || senha.isEmpty() || confirma.isEmpty()) {
					Message.infoBox("Todos os campos devem ser preenchidos!", "Formulário invalido");
				} else if (!EmailValidator.isValid(email)) {
					Message.infoBox("Email invalido!", "Formulário invalido");
				} else if (senha.length() < 6) {
					Message.infoBox("Sua senha deve conter no minimo 6 caracteres!", "Formulário invalido");
				} else if (!senha.equals(confirma)) {
					Message.infoBox("As senhas devem ser iguais!", "Formulário invalido");
				}
				try {
					ISgta sgta = Sgta.getInstance();
					if (rdbtnAluno.isSelected()) {
						sgta.adicionarAluno(sgta.proximoId(), nome, cpf, senha, email, cpf);
					} else {
						sgta.adicionarProfessor(sgta.proximoId(), nome, cpf, senha, email, cpf);
					}
					Message.infoBox("Usuario cadastrado com sucesso!", "Cadastro Completo");
					TelaLogin volta  = new TelaLogin();
					volta.setVisible(true);
					dispose();
				} catch (InicializacaoSistemaException e1) {
					Message.infoBox("Erro ao inicializar o sistema!", "Erro Sistema");
				} catch (DuplicatedUserException e1) {
					Message.infoBox("Ja existe um usuario com esse CPF!", "Erro Sistema");
				} catch (RepositorioException e1) {
					Message.infoBox("Erro ao se conectar com o servidor!", "Erro Sistema");
				} 
			}
		});

		btnCadastrar.setBounds(63, 318, 105, 25);
		getContentPane().add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin volta  = new TelaLogin();
				volta.setVisible(true);
				dispose();
			}

		});

		btnVoltar.setBounds(206, 318, 114, 25);
		getContentPane().add(btnVoltar);

		JLabel label_6 = new JLabel("Insira seus dados");
		label_6.setBounds(21, 41, 149, 16);
		getContentPane().add(label_6);
		
		rdbtnAluno = new JRadioButton("Aluno");
		rdbtnAluno.setBounds(40, 272, 141, 23);
		rdbtnAluno.setSelected(true);
		getContentPane().add(rdbtnAluno);
		
		rdbtnProfessor = new JRadioButton("Professor");
		rdbtnProfessor.setBounds(179, 272, 141, 23);
		getContentPane().add(rdbtnProfessor);
		
		ButtonGroup group = new ButtonGroup();
	    group.add(rdbtnAluno);
	    group.add(rdbtnProfessor);
	}
}
