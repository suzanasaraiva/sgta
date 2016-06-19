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
import javax.swing.JTable;

public class TelaVisualizarMensagem extends JFrame {

	private JPanel contentPane;
	private Mensagem msg;
	private JLabel lblEmailTxt;
	private JLabel lblSubject;
	private JTextArea txtMessage;
	private JButton btnVoltar;
	private JLabel lblEmail;
	private JLabel lblAssunto;
	private boolean recebida;
	private String remetente;
	private String destinatario;
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
	
	public void setMsg(Mensagem msg, boolean recebida) {
		this.recebida = recebida;
		this.msg = msg;
		try {
			this.remetente = Sgta.getInstance().buscarUsuarioPorID(msg.getIdRementente()).getEmail();
			this.destinatario = Sgta.getInstance().buscarUsuarioPorID(msg.getIdDestinatario()).getEmail();
			if (recebida) {
				
				this.lblEmailTxt.setText(this.remetente);
			} else {
				this.lblEmailTxt.setText(this.destinatario);
				this.lblEmail.setText("Destinatario:");
			}
			this.lblSubject.setText(msg.getAssunto());
			this.txtMessage.setText(msg.getMensagem());
			
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
		
		lblEmailTxt = new JLabel("New label");
		lblEmailTxt.setBounds(132, 6, 290, 36);
		contentPane.add(lblEmailTxt);
		
		lblSubject = new JLabel("New label");
		lblSubject.setBounds(132, 55, 263, 26);
		contentPane.add(lblSubject);
		
		txtMessage = new JTextArea();
		txtMessage.setWrapStyleWord(true);
		txtMessage.setLineWrap(true);
		txtMessage.setEditable(false);
		txtMessage.setBounds(22, 94, 400, 115);
		contentPane.add(txtMessage);
		
		JButton btnResponder = new JButton("Responder");
		btnResponder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEnviarMensagens tela = new TelaEnviarMensagens();
				if (recebida) {
					tela.setFields(remetente, "RE: " + lblSubject.getText());
				} else {
					tela.setFields(destinatario, "RE: " + lblSubject.getText());
				}
				tela.setVisible(true);
				dispose();
			}
		});
		btnResponder.setBounds(22, 231, 117, 29);
		contentPane.add(btnResponder);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame tela;
				if (recebida) {
					tela = new TelaMensagensRecebidas();
				} else {
					tela = new TelaMensagensEnviadas();	
				}
				
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(305, 231, 117, 29);
		contentPane.add(btnVoltar);
		
		lblEmail = new JLabel("Remetente:");
		lblEmail.setBounds(22, 16, 98, 16);
		contentPane.add(lblEmail);
		
		lblAssunto = new JLabel("Assunto:");
		lblAssunto.setBounds(22, 60, 98, 16);
		contentPane.add(lblAssunto);
	}
}
