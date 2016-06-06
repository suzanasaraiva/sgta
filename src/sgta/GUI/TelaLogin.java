package sgta.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastro tela2 = new TelaCadastro();
				tela2.setVisible(true);
				dispose();
		}
		});
		btnNewButton.setBounds(203, 210, 145, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Acessar");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("admin")&& textField_1.getText().equals("1234")){
					TelaPrincipal tela = new TelaPrincipal();
					tela.setVisible(true);
					dispose();
			}else
				JOptionPane.showMessageDialog(rootPane, "Senha ou Usuario Invalido!");
			}
		});
		btnNewButton_1.setBounds(356, 210, 145, 25);
		contentPane.add(btnNewButton_1);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(301, 87, 42, 16);
		contentPane.add(lblId);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(301, 136, 47, 16);
		contentPane.add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(350, 84, 129, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(350, 133, 129, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
