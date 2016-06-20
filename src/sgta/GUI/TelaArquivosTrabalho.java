package sgta.GUI;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import sgta.Repositorio.ArquivoInexistente;
import sgta.Repositorio.RepositorioException;
import sgta.Sistema.Arquivo;
import sgta.Sistema.ISgta;
import sgta.Sistema.Mensagem;
import sgta.Sistema.Sgta;
import sgta.Sistema.Trabalho;
import sgta.Sistema.Usuario;
import sgta.util.Message;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class TelaArquivosTrabalho extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private Trabalho trabalho;
	private ArrayList<Arquivo> arquivos;
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
					TelaArquivosTrabalho frame = new TelaArquivosTrabalho();
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
	public TelaArquivosTrabalho() {
		setTitle("Mensagens Recebidas");
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
					TelaVisualizarArquivo tela;
					try {
						tela = new TelaVisualizarArquivo(arquivos.get(index));
						tela.setTrabalho(trabalho);
						tela.setVisible(true);
						dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (RepositorioException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ArquivoInexistente e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					Message.infoBox("Nenhuma arquivo selecionado", "Error");
				}
			}
		});
		btnAbrir.setBounds(19, 225, 117, 29);
		contentPane.add(btnAbrir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBuscarTrabalhos tela = new TelaBuscarTrabalhos();
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
		model.addColumn("Nome");
	
		scrollPane.setViewportView(table);
	}
	
	public void setTrabalho(Trabalho trabalho) {
		this.trabalho = trabalho;
	}

	public void carregarList() {
		
		try {
			ISgta sgta = Sgta.getInstance();
			arquivos = sgta.buscarArquivosPorIDTrabalho(trabalho.idTrabalho);
			
			for (int i = 0; i < arquivos.size(); i++) {
				
				String nome = arquivos.get(i).getFileName();
				model.addRow(new Object[] { nome });
			}
		} catch (Exception e) {
			e.printStackTrace();
			Message.infoBox("Erro ao se conectar com o servidor!", "Erro");
		}
	}
}
