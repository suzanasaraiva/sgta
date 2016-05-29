package sgta.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;

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
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 567);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin volta  = new TelaLogin();
				volta.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(716, 470, 97, 25);
		contentPane.add(btnVoltar);
		
		JButton btnNewButton = new JButton("Aluno");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroAluno tela1= new TelaCadastroAluno();
					tela1.setVisible(true);
					dispose();
				
			}
		});
		btnNewButton.setBounds(106, 309, 82, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Professor");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProfessor tela2= new TelaCadastroProfessor();
				tela2.setVisible(true);
				dispose();
			
				
			}
		});
		btnNewButton_1.setBounds(364, 383, 113, 34);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Admnistrador");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroAdministrador tela3= new TelaCadastroAdministrador();
				tela3.setVisible(true);
				dispose();
			
			}
		});
		btnNewButton_2.setBounds(619, 295, 113, 34);
		contentPane.add(btnNewButton_2);
		
		JLabel lblProfessor = new JLabel("PROFESSOR");
		lblProfessor.setIcon(new ImageIcon("C:\\Users\\Suzana\\Pictures\\Imagens projeto\\professor.png"));
		lblProfessor.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblProfessor.setBounds(295, 114, 274, 256);
		contentPane.add(lblProfessor);
		
		JLabel lblAdministrador = new JLabel("ADMINISTRADOR");
		lblAdministrador.setIcon(new ImageIcon("C:\\Users\\Suzana\\Pictures\\Imagens projeto\\Usu\u00E1rio.png"));
		lblAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAdministrador.setBounds(557, -3, 263, 301);
		contentPane.add(lblAdministrador);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Suzana\\Pictures\\Imagens projeto\\Aluno.png"));
		lblNewLabel.setBounds(23, 49, 271, 263);
		contentPane.add(lblNewLabel);
	}
}
