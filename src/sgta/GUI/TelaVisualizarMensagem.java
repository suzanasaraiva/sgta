package sgta.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sgta.Sistema.Mensagem;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class TelaVisualizarMensagem extends JFrame {

	private JPanel contentPane;
	private Mensagem msg;
	private JLabel lblDestinatario;
	private JLabel lblSubject;
	private JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVisualizarMensagem frame = new TelaVisualizarMensagem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setMsg(Mensagem msg) {
		this.msg = msg;
		this.lblDestinatario.setText(msg.getIdRementente() +"");
		this.lblSubject.setText(msg.getAssunto());
		this.textArea.setText(msg.getMensagem());
	}

	/**
	 * Create the frame.
	 */
	public TelaVisualizarMensagem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 lblDestinatario = new JLabel("New label");
		lblDestinatario.setBounds(22, 13, 373, 36);
		contentPane.add(lblDestinatario);
		
		 lblSubject = new JLabel("New label");
		lblSubject.setBounds(22, 55, 373, 26);
		contentPane.add(lblSubject);
		
		 textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(22, 94, 381, 146);
		contentPane.add(textArea);
	}

}
