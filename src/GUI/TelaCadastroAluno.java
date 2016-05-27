package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroAluno extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblId;
	private JLabel lblNome;
	private JLabel lblNewLabel;
	private JTextField textField_3;
	private JLabel lblSenha;
	private JLabel lblNewLabel_1;
	private JTextField textField_4;
	private JLabel lblInsiraOsDados;
	private JButton btnCadastrar;
	private JButton btnSair;

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
		setBounds(100, 100, 378, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(147, 70, 139, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 108, 139, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(147, 178, 139, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(52, 61, 94, 39);
		contentPane.add(lblId);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(52, 146, 94, 16);
		contentPane.add(lblNome);
		
		lblNewLabel = new JLabel("Cpf");
		lblNewLabel.setBounds(52, 181, 94, 16);
		contentPane.add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(147, 143, 139, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(52, 111, 114, 16);
		contentPane.add(lblSenha);
		
		lblNewLabel_1 = new JLabel("Matr\u00EDcula");
		lblNewLabel_1.setBounds(52, 216, 94, 16);
		contentPane.add(lblNewLabel_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(147, 213, 139, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		lblInsiraOsDados = new JLabel("Insira os dados do Aluno");
		lblInsiraOsDados.setBounds(12, 13, 149, 16);
		contentPane.add(lblInsiraOsDados);
		
		btnCadastrar = new JButton("Cadastrar");
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
	}

}
