package sgta.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sgta.Repositorio.RepositorioException;
import sgta.Sistema.InicializacaoSistemaException;
import sgta.Sistema.Mensagem;
import sgta.Sistema.Sgta;
import sgta.util.Message;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

public class TelaMensagensRecebidas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JList list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMensagensRecebidas frame = new TelaMensagensRecebidas();
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
	public TelaMensagensRecebidas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 18, 411, 195);
		contentPane.add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.setBounds(19, 225, 117, 29);
		contentPane.add(btnAbrir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(313, 225, 117, 29);
		contentPane.add(btnVoltar);
		
		carregarList();
	}
	
	private void carregarList() {
		ArrayList<Mensagem> mensagens;
		try {
			mensagens = Sgta.getInstance().buscarMensagensDestinatario();
			String[] mensagensText = new String[mensagens.size()];
			for (int i = 0; i < mensagens.size(); i++) {
				mensagensText[i] = mensagens.get(i).getAssunto();
			}
			list.setListData(mensagensText);
		} catch (Exception e) {
			Message.infoBox("Erro ao se conectar com o servidor!", "Erro");
		}
	}
}
