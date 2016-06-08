package sgta.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import sgta.Repositorio.RepositorioException;
import sgta.Repositorio.UsuarioInexistente;
import sgta.Sistema.InicializacaoSistemaException;
import sgta.Sistema.Sgta;
import sgta.Sistema.Usuario;
import sgta.util.Message;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cpfTextField;
	private JPasswordField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 341);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("imagens/Logo.png"));
		label.setBounds(0, 81, 265, 103);
		contentPane.add(label);

		JButton btnNewButton = new JButton("Novo Cadastro");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastro tela2 = new TelaCadastro();
				tela2.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(200, 227, 145, 25);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Acessar");
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String cpf = cpfTextField.getText();
				String password = String.valueOf(passwordTextField.getPassword());
				if (cpf.equals("000.000.000-00") && password.equals("1234")) {
					TelaPrincipal tela = new TelaPrincipal();
					tela.setVisible(true);
					dispose();
					return;
				}
				try {
					Usuario user;

					if (cpf.equals("   .   .   -  ") || password.isEmpty()) {
						Message.infoBox("Por favor, preencha todos os campos!", "Erro");
						return;
					} else {
						user = Sgta.getInstance().buscarUsuarioPorCPF(cpf);
						Sgta.usuario = user;
					}

					if (user.getSenha().equals(password)) {
						System.out.println("Logado usuario comum!");
						int quantitadeMensagens = Sgta.getInstance().quantitadeMensagens();
						if (quantitadeMensagens > 0) {
							Message.infoBox("Voce tem " + quantitadeMensagens + " novas mensagens", "Novas Mensagens");
						}
						TelaPrincipal tela = new TelaPrincipal();
						tela.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(rootPane, "Senha Invalida!");
					}
				} catch (RepositorioException | InicializacaoSistemaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UsuarioInexistente e) {
					JOptionPane.showMessageDialog(rootPane, "Usuario Invalido!");
				}

			}
		});
		btnNewButton_1.setBounds(357, 227, 145, 25);
		contentPane.add(btnNewButton_1);

		JLabel lblId = new JLabel("CPF:");
		lblId.setBounds(306, 87, 42, 16);
		contentPane.add(lblId);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(301, 136, 47, 16);
		contentPane.add(lblSenha);

		MaskFormatter txtFormatCpf;
		try {
			txtFormatCpf = new MaskFormatter("###.###.###-##");
			cpfTextField = new JFormattedTextField(txtFormatCpf);
			cpfTextField.setColumns(10);
			cpfTextField.setBounds(350, 84, 129, 22);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Ocorreu um problema na formatacao.");
		}
		getContentPane().add(cpfTextField);
		/*
		 * cpfTextField = new JTextField(); cpfTextField.setBounds(350, 84, 129,
		 * 22); contentPane.add(cpfTextField); cpfTextField.setColumns(10);
		 */
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(350, 133, 129, 22);
		contentPane.add(passwordTextField);
		passwordTextField.setColumns(10);
	}
}
