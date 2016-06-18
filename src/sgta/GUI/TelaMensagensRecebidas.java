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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMensagensRecebidas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JList listMsg;
	private ArrayList<Mensagem> mensagens;
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
		
		listMsg = new JList();
		scrollPane.setViewportView(listMsg);
		
		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = listMsg.getSelectedIndex();
				TelaVisualizarMensagem tela = new TelaVisualizarMensagem();
				tela.setMsg(mensagens.get(index));
				tela.setVisible(true);
				dispose();
			}
		});
		btnAbrir.setBounds(19, 225, 117, 29);
		contentPane.add(btnAbrir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tela = new TelaPrincipal();
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(313, 225, 117, 29);
		contentPane.add(btnVoltar);
		
		carregarList();
	}
	
	private void carregarList() {
		
		try {
			mensagens = Sgta.getInstance().buscarMensagensDestinatario();
			String[] mensagensText = new String[mensagens.size()];
			for (int i = 0; i < mensagens.size(); i++) {
				mensagensText[i] = mensagens.get(i).getAssunto();
			}
			listMsg.setListData(mensagensText);
		} catch (Exception e) {
			Message.infoBox("Erro ao se conectar com o servidor!", "Erro");
		}
	}
}
