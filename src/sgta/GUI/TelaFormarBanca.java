package sgta.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class TelaFormarBanca extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaFormarBanca frame = new TelaFormarBanca();
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
	public TelaFormarBanca() {
		setTitle("Montar Banca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(36, 149, 558, 188);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(118, 63, 476, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(118, 97, 476, 22);
		contentPane.add(textField_2);
		
		JLabel lblDestinatarios = new JLabel("Destinatarios:");
		lblDestinatarios.setBounds(33, 63, 79, 16);
		contentPane.add(lblDestinatarios);
		
		JLabel label_1 = new JLabel("Assunto:");
		label_1.setBounds(33, 100, 77, 16);
		contentPane.add(label_1);
		
		JButton button = new JButton("Enviar ");
		button.setBounds(82, 384, 121, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setBounds(406, 384, 121, 25);
		contentPane.add(button_1);
	}
}
