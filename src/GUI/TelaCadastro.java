package GUI;

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
		
		JButton btnNewButton = new JButton("Aluno");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroAluno tela3 = new TelaCadastroAluno();
				tela3.setVisible(true);
				dispose();
		}
			
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Suzana\\Pictures\\Imagens projeto\\Aluno.png"));
		btnNewButton.setBounds(123, 71, 264, 309);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Professor");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					TelaCadastroProfessor tela4 = new TelaCadastroProfessor();
					tela4.setVisible(true);
					dispose();
			}
			
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Suzana\\Pictures\\Imagens projeto\\professor.png"));
		btnNewButton_1.setBounds(468, 74, 264, 303);
		contentPane.add(btnNewButton_1);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin volta  = new TelaLogin();
				volta.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(716, 470, 97, 25);
		contentPane.add(btnVoltar);
	}
}
