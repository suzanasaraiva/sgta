package sgta.GUI;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import sgta.Sistema.ISgta;
import sgta.Sistema.Mensagem;
import sgta.Sistema.Sgta;
import sgta.Sistema.Usuario;
import sgta.util.Message;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class TelaMensagensEnviadas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private ArrayList<Mensagem> mensagens;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMensagensEnviadas frame = new TelaMensagensEnviadas();
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
	public TelaMensagensEnviadas() {
		setTitle("Mensagens Enviadas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = table.getSelectedRow();
				if (index != -1) {
					TelaVisualizarMensagem tela = new TelaVisualizarMensagem();
					tela.setMsg(mensagens.get(index), false);
					tela.setVisible(true);
					dispose();
				} else {
					Message.infoBox("Nenhuma mensagem selecionada", "Error");
				}
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 18, 407, 195);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel() {
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		        //all cells false
		        return false;
		    }
		};
		
		table.setModel(model);
		model.addColumn("Destinatario");
		model.addColumn("Assunto");
	
		scrollPane.setViewportView(table);
		
		carregarList();
	}
	
	private void carregarList() {
		
		try {
			mensagens = Sgta.getInstance().buscarMensagensRemetetne();
			ISgta sgta = Sgta.getInstance();
			for (int i = 0; i < mensagens.size(); i++) {
				
				Usuario user = sgta.buscarUsuarioPorID(mensagens.get(i).getIdDestinatario());
				String email = user.getEmail();
				String assunto = mensagens.get(i).getAssunto();
				 
				model.addRow(new Object[] { email , assunto });
			}
		} catch (Exception e) {
			Message.infoBox("Erro ao se conectar com o servidor!", "Erro");
		}
	}
}
