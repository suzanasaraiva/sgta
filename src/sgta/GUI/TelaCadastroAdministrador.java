package sgta.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroAdministrador extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroAdministrador frame = new TelaCadastroAdministrador();
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
	public TelaCadastroAdministrador() {
		setTitle("Cadastro do Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Id");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(55, 56, 94, 39);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(150, 65, 139, 22);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("Senha");
		label_1.setBounds(55, 106, 114, 16);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(150, 103, 139, 22);
		contentPane.add(textField_1);
		
		JLabel label_2 = new JLabel("Nome");
		label_2.setBounds(55, 141, 94, 16);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(150, 138, 139, 22);
		contentPane.add(textField_2);
		
		JLabel label_3 = new JLabel("Cpf");
		label_3.setBounds(55, 176, 94, 16);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(150, 173, 139, 22);
		contentPane.add(textField_3);
		
		JLabel label_4 = new JLabel("Email");
		label_4.setBounds(55, 211, 94, 16);
		contentPane.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(150, 208, 139, 22);
		contentPane.add(textField_4);
		
		JLabel label_5 = new JLabel("Matr\u00EDcula");
		label_5.setBounds(55, 247, 94, 16);
		contentPane.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(150, 245, 139, 22);
		contentPane.add(textField_5);
		
		JLabel lblInsiraSeusDados = new JLabel("Insira seus dados");
		lblInsiraSeusDados.setBounds(12, 27, 149, 16);
		contentPane.add(lblInsiraSeusDados);
		
		JButton button = new JButton("Cadastrar");
		button.setBounds(43, 298, 114, 30);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Voltar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro tc  = new TelaCadastro();
			tc.setVisible(true);
			dispose();
		}
			
		});
		button_1.setBounds(196, 298, 114, 30);
		contentPane.add(button_1);
	}
}
