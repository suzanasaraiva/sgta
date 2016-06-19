package sgta.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sgta.Repositorio.RepositorioException;
import sgta.Repositorio.UsuarioInexistente;
import sgta.Sistema.ISgta;
import sgta.Sistema.InicializacaoSistemaException;
import sgta.Sistema.Mensagem;
import sgta.Sistema.Sgta;
import sgta.util.Message;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class TelaEnviarMensagens extends JFrame {

	private JPanel contentPane;
	private JTextArea mensagemTextField;
	private JTextField destTextField;
	private JTextField assuntoTextField;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaEnviarMensagens frame = new TelaEnviarMensagens();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setFields(String dest, String assunto) {
		this.destTextField.setText(dest);
		this.assuntoTextField.setText(assunto);
	}

	/**
	 * Create the frame.
	 */
	public TelaEnviarMensagens() {
		setTitle("Mensagens");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEnviarMensagem = new JButton("Enviar ");
		btnEnviarMensagem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String email = destTextField.getText();
				String assunto = assuntoTextField.getText();
				String mensagem = mensagemTextField.getText();
				
				if (email.isEmpty() || assunto.isEmpty() || mensagem.isEmpty()) {
					Message.infoBox("Por favor, preencha todos os campos!", "Erro");
					return;
				}
				
				try {
					ISgta sgta = Sgta.getInstance();
					int idDestinatario = sgta.buscarUsuarioPorEmail(email).getIdUsuario();
					
					sgta.adicionarMensagem(new Mensagem(sgta.proximoMensagemId(), Sgta.usuario.getIdUsuario(), idDestinatario, assunto, mensagem, false));
					Message.infoBox("Mensagem enviada com sucesso!", "Mensagem Sucesso");
					TelaPrincipal tela = new TelaPrincipal();
					tela.setVisible(true);
					dispose();
				} catch (RepositorioException e1) {
					Message.infoBox("Erro ao se conectar com o servidor", "Erro");
				} catch (UsuarioInexistente e1) {
					Message.infoBox("Destinatario nao existe", "Erro");
			  } catch (InicializacaoSistemaException e1) {
					Message.infoBox("Erro", "Erro");
				}
			}
		});
		btnEnviarMensagem.setBounds(94, 333, 121, 25);
		contentPane.add(btnEnviarMensagem);
		
		mensagemTextField = new JTextArea();
		mensagemTextField.setBounds(25, 114, 571, 206);
		contentPane.add(mensagemTextField);
		mensagemTextField.setColumns(10);
		
		destTextField = new JTextField();
		destTextField.setBounds(132, 45, 464, 22);
		contentPane.add(destTextField);
		destTextField.setColumns(10);
		
		assuntoTextField = new JTextField();
		assuntoTextField.setBounds(132, 79, 464, 22);
		contentPane.add(assuntoTextField);
		assuntoTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Destinatario:");
		lblNewLabel.setBounds(43, 48, 77, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Assunto:");
		lblNewLabel_1.setBounds(43, 85, 77, 16);
		contentPane.add(lblNewLabel_1);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tela = new TelaPrincipal();
				tela.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(418, 333, 121, 25);
		contentPane.add(btnCancelar);
	}
}
