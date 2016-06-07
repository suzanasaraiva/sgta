package sgta.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setTitle("SGTA MENU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 403);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		
		JMenu mnPerfil = new JMenu("Perfil");
		menuBar.add(mnPerfil);
		
		JMenuItem mntmAluno = new JMenuItem("Aluno");
		mnPerfil.add(mntmAluno);
		
		JMenuItem mntmProfessor = new JMenuItem("Professor");
		mnPerfil.add(mntmProfessor);
		
		JMenuItem mntmAdmininstrador = new JMenuItem("Admininstrador");
		mnPerfil.add(mntmAdmininstrador);
		
		JMenu mnMensagens = new JMenu("Mensagens");
		menuBar.add(mnMensagens);
		
		JMenuItem mntmEnviar = new JMenuItem("Enviar");
		mntmEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaEnviarMensagens telamensagens = new TelaEnviarMensagens();
				telamensagens.setVisible(true);
				dispose();
			
			}
		});
		mnMensagens.add(mntmEnviar);
		
		JMenuItem mntmRecebidas = new JMenuItem("Recebidas");
		mnMensagens.add(mntmRecebidas);
		
		JMenuItem mntmEnviadas = new JMenuItem("Enviadas");
		mnMensagens.add(mntmEnviadas);
		
		JMenu mnTrabalhos = new JMenu("Trabalhos");
		menuBar.add(mnTrabalhos);
		
		JMenuItem mntmSubmeter = new JMenuItem("Submeter");
		mnTrabalhos.add(mntmSubmeter);
		
		JMenuItem mntmGerenciar = new JMenuItem("Gerenciar");
		mnTrabalhos.add(mntmGerenciar);
		
		JMenuItem mntmBuscar = new JMenuItem("Buscar");
		mnTrabalhos.add(mntmBuscar);
		
		JMenu mnPublicar = new JMenu("Publicar");
		menuBar.add(mnPublicar);
		
		JMenuItem mntmBuscarLocais = new JMenuItem("Buscar Locais");
		mnPublicar.add(mntmBuscarLocais);
		
		JMenuItem mntmPublicarTrabalho = new JMenuItem("Publicar Trabalho");
		mnPublicar.add(mntmPublicarTrabalho);
		
		JMenu mnOportunidades = new JMenu("Oportunidades");
		menuBar.add(mnOportunidades);
		
		JMenuItem mntmBuscarOportunidades = new JMenuItem("Buscar Oportunidades");
		mnOportunidades.add(mntmBuscarOportunidades);
		
		JMenuItem mntmCandidatarseOportunidades = new JMenuItem("Candidatar-se \u00E0 Oportunidades");
		mnOportunidades.add(mntmCandidatarseOportunidades);
		
		JMenu mnBanca = new JMenu("Banca");
		menuBar.add(mnBanca);
		
		JMenuItem mntmFormarBanca = new JMenuItem("Formar Banca");
		mnBanca.add(mntmFormarBanca);
		
		JMenuItem mntmAvaliarTrabalhos = new JMenuItem("Avaliar Trabalhos");
		mnBanca.add(mntmAvaliarTrabalhos);
		
		JMenu mnSair = new JMenu("Sair");
		menuBar.add(mnSair);
		
		JMenuItem mntmLogoff = new JMenuItem("Logoff");
		mnSair.add(mntmLogoff);
	}
}
