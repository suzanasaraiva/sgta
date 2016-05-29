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

public class TelaCadastroProfessor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		setBounds(100, 100, 370, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Id");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(48, 73, 94, 39);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Senha");
		label_1.setBounds(48, 123, 114, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Nome");
		label_2.setBounds(48, 158, 94, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Cpf");
		label_3.setBounds(48, 193, 94, 16);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Matr\u00EDcula");
		label_4.setBounds(48, 228, 94, 16);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(132, 81, 139, 22);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(132, 119, 139, 22);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(132, 154, 139, 22);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(132, 189, 139, 22);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(132, 224, 139, 22);
		contentPane.add(textField_4);
		
		JButton button = new JButton("Cadastrar");
		button.setBounds(35, 287, 114, 30);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Voltar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro tc2  = new TelaCadastro();
				tc2.setVisible(true);
				dispose();
			}
		});
		button_1.setBounds(183, 287, 114, 30);
		contentPane.add(button_1);
		
		JLabel lblInsiraOsDados = new JLabel("Insira os dados do Professor");
		lblInsiraOsDados.setBounds(24, 32, 174, 16);
		contentPane.add(lblInsiraOsDados);
	}

}
