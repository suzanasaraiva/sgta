package sgta.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sgta.Repositorio.RepositorioException;
import sgta.Repositorio.UsuarioInexistente;
import sgta.Sistema.InicializacaoSistemaException;
import sgta.Sistema.Mensagem;
import sgta.Sistema.Sgta;
import sgta.Sistema.Usuario;
import sgta.util.Message;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaVisualizarMensagem extends JFrame {

	private JPanel contentPane;
	private Mensagem msg;
	private JLabel lblRemetente;
	private JLabel lblSubject;
	private JTextArea textArea;
	private JButton btnVoltar;
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
		try {
			Usuario remetente = Sgta.getInstance().buscarUsuarioPorID(msg.getIdRementente());
			this.lblRemetente.setText(remetente.getEmail());
			this.lblSubject.setText(msg.getAssunto());
			this.textArea.setText(msg.getMensagem());
		} catch (RepositorioException e) {
			Message.infoBox("Error", "O sistema nao pode se conectar com o servidor!");
			e.printStackTrace();
		} catch (UsuarioInexistente e) {
			Message.infoBox("Error", "O usuario nao existe!");
			e.printStackTrace();
		} catch (InicializacaoSistemaException e) {
			Message.infoBox("Error", "Um erro ocorreu no sistema!");
			e.printStackTrace();
		}
		
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
		
		lblRemetente = new JLabel("New label");
		lblRemetente.setBounds(22, 13, 373, 36);
		contentPane.add(lblRemetente);
		
		lblSubject = new JLabel("New label");
		lblSubject.setBounds(22, 55, 373, 26);
		contentPane.add(lblSubject);
		
		 textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(22, 94, 400, 115);
		contentPane.add(textArea);
		
		JButton btnResponder = new JButton("Responder");
		btnResponder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEnviarMensagens tela = new TelaEnviarMensagens();
				tela.setFields(lblRemetente.getText(), "RE: " + lblSubject.getText());
				tela.setVisible(true);
				dispose();
			}
		});
		btnResponder.setBounds(22, 231, 117, 29);
		contentPane.add(btnResponder);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMensagensRecebidas tela = new TelaMensagensRecebidas();
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(305, 231, 117, 29);
		contentPane.add(btnVoltar);
	}
}
