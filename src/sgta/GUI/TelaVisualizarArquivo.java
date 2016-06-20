package sgta.GUI;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import sgta.Repositorio.ArquivoInexistente;
import sgta.Repositorio.IRepositorio;
import sgta.Repositorio.Repositorio;
import sgta.Repositorio.RepositorioException;
import sgta.Sistema.Arquivo;
import sgta.Sistema.Trabalho;
import sgta.util.ImageHelper;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class TelaVisualizarArquivo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel pageCounter;
	private PDFRenderer render;
	private int currentPage;
	private int numberPages;
	private JButton forward;
	private JButton backward;
	private JButton fastBackward;
	private JButton fastForward;
	private JButton btnVoltar;
	private Trabalho trabalho;

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws RepositorioException 
	 * @throws ArquivoInexistente 
	 */
	public TelaVisualizarArquivo(Arquivo arquivo) throws IOException, RepositorioException, ArquivoInexistente {

		this.currentPage = 0;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 780);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		PDDocument inputPDF = PDDocument.load(arquivo.getFile());

		
		this.numberPages = inputPDF.getNumberOfPages();
		
		render = new PDFRenderer(inputPDF);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel pdfImage = new JLabel("");
		pdfImage.setBounds(20, 42, 610, 659);
		pdfImage.setIcon(new ImageIcon(ImageHelper.scaleImage(render.renderImage(0))));
		contentPane.add(pdfImage);
		
		backward = new JButton("<");
		backward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPage--;
				try {
					pdfImage.setIcon(new ImageIcon(ImageHelper.scaleImage(render.renderImage(currentPage))));
					updatePageCounter();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		backward.setBounds(190, 713, 56, 29);
		contentPane.add(backward);
		
		forward = new JButton(">");
		forward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPage++;
				try {
					pdfImage.setIcon(new ImageIcon(ImageHelper.scaleImage(render.renderImage(currentPage))));
					updatePageCounter();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		forward.setBounds(390, 713, 56, 29);
		contentPane.add(forward);
		
		pageCounter = new JLabel("1/1");
		pageCounter.setHorizontalAlignment(SwingConstants.CENTER);
		pageCounter.setBounds(258, 718, 120, 16);
		contentPane.add(pageCounter);
		
		fastBackward = new JButton("<<");
		fastBackward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPage = 0;
				try {
					pdfImage.setIcon(new ImageIcon(ImageHelper.scaleImage(render.renderImage(currentPage))));
					updatePageCounter();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		fastBackward.setBounds(122, 713, 56, 29);
		contentPane.add(fastBackward);
		
		fastForward = new JButton(">>");
		fastForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPage = numberPages - 1;
				try {

				
//					BufferedImage page = render.renderImage(currentPage);
					
					pdfImage.setIcon(new ImageIcon(ImageHelper.scaleImage(render.renderImage(currentPage))));
					updatePageCounter();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		fastForward.setBounds(458, 713, 56, 29);
		contentPane.add(fastForward);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaArquivosTrabalho tela = new TelaArquivosTrabalho();
				tela.setTrabalho(trabalho);
				tela.carregarList();
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(526, 713, 117, 29);
		contentPane.add(btnVoltar);
		
		this.updatePageCounter();
	}
	
	public void setTrabalho(Trabalho trabalho) {
		this.trabalho = trabalho;
	}

	private void updatePageCounter() {
		pageCounter.setText((this.currentPage + 1) + "/" + this.numberPages);
		if (this.currentPage + 1 == this.numberPages) {
			this.forward.setEnabled(false);
			this.fastForward.setEnabled(false);
		} else {
			this.forward.setEnabled(true);
			this.fastForward.setEnabled(true);
		}
		
		if (this.currentPage == 0) {
			this.backward.setEnabled(false);
			this.fastBackward.setEnabled(false);
		} else {
			this.backward.setEnabled(true);
			this.fastBackward.setEnabled(true);
		}
	}
}
