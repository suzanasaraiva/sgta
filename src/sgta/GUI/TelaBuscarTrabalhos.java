package sgta.GUI;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import sgta.Repositorio.ArquivoInexistente;
import sgta.Repositorio.NaoExisteTrabalhoException;
import sgta.Repositorio.RepositorioException;
import sgta.Repositorio.UsuarioInexistente;
import sgta.Sistema.ISgta;
import sgta.Sistema.InicializacaoSistemaException;
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
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaBuscarTrabalhos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private ArrayList<Trabalho> trabalhos;
	private JTable table;
	private JScrollPane scrollPane;
	private JComboBox comboBox;
	private DefaultTableModel model;
	private Label labelBuscar;
	private TextField textFieldQuery;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscarTrabalhos frame = new TelaBuscarTrabalhos();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TelaBuscarTrabalhos() {
		setTitle("Buscar Trabalhos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = table.getSelectedRow();
				if (index != -1) {
					TelaArquivosTrabalho tela = new TelaArquivosTrabalho();
					tela.setTrabalho(trabalhos.get(index));
					tela.carregarList();
					tela.setVisible(true);
					dispose();
				} else {
					Message.infoBox("Nenhum trabalho selecionado", "Error");
				}
			}
		});
		btnAbrir.setBounds(188, 273, 117, 29);
		contentPane.add(btnAbrir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tela = new TelaPrincipal();
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(19, 273, 117, 29);
		contentPane.add(btnVoltar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 59, 454, 200);
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
		model.addColumn("Autor");
		model.addColumn("Titulo");
		model.addColumn("Tema");
	
		scrollPane.setViewportView(table);
		
		labelBuscar = new Label("Buscar");
		labelBuscar.setBounds(19, 24, 61, 16);
		contentPane.add(labelBuscar);
		
		textFieldQuery = new TextField();
		textFieldQuery.setBounds(86, 24, 290, 22);
		contentPane.add(textFieldQuery);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Titulo", "Tema"}));
		comboBox.setBounds(382, 24, 91, 27);
		contentPane.add(comboBox);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = textFieldQuery.getText();
				if (query.isEmpty() || query.replaceAll("\\s+","").length() == 0) {
					Message.infoBox("Por favor, digite algo na barra de pesquisa", "Erro");
				} else {
					String key = comboBox.getSelectedItem().toString();
					
					try {
						ISgta sgta = Sgta.getInstance();
						switch (key) {
						case "Titulo":
							trabalhos = sgta.buscarTrabalhoTitulo(query);
							break;
						case "Tema":
							trabalhos = sgta.buscarTrabalhoTema(query);
							break;
						case "Autor":
							searchByAuthor(query, sgta);
							break;
						default:
							break;
						}
						carregarList();
					} catch (InicializacaoSistemaException e1) {
						Message.infoBox("Erro no sistema", "Erro");
					} catch (RepositorioException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NaoExisteTrabalhoException e1) {
						Message.infoBox("Nao existe nenhum trabalho para essa pesquisa", "Erro");
					} catch (UsuarioInexistente e1) {
						Message.infoBox("Nao existe nenhum trabalho para essa pesquisa", "Erro");
					} 
				}
			}
		});
		btnPesquisar.setBounds(356, 273, 117, 29);
		contentPane.add(btnPesquisar);
		
	}
	
	private void searchByAuthor(String query, ISgta sgta) throws RepositorioException, UsuarioInexistente {
		ArrayList<Usuario> usuarios = sgta.buscarUsuariosPorNome(query);
		for (Usuario usuario : usuarios) {
			try {
				ArrayList<Trabalho> temp = sgta.buscarTrabalhoAutor(usuario.getIdUsuario());
				if (temp != null) {
					trabalhos.addAll(temp);
				}
			} catch (RepositorioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NaoExisteTrabalhoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void carregarList() {
		
		try {
			ISgta sgta = Sgta.getInstance();
			for (int i = 0; i < trabalhos.size(); i++) {
				
				Usuario user = sgta.buscarUsuarioPorID(trabalhos.get(i).getIdUsuario());
				String email = user.getEmail();
				String titulo = trabalhos.get(i).getTitulo();
				String assunto = trabalhos.get(i).getArea();
				 
				model.addRow(new Object[] { titulo, email, assunto });
			}
		} catch (Exception e) {
			Message.infoBox("Erro ao se conectar com o servidor!", "Erro");
		}
	}
}
