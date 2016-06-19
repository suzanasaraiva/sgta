package sgta.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdfparser.PDFStreamParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.printing.PDFPageable;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.PDFBox;

import sgta.Repositorio.IRepositorio;
import sgta.Repositorio.Repositorio;
import sgta.Repositorio.RepositorioException;
import sgta.Sistema.Arquivo;
import sgta.Sistema.Sgta;

import javax.swing.JTextArea;
import javax.swing.JLabel;

public class TelaVisualizarTrabalho extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVisualizarTrabalho frame = new TelaVisualizarTrabalho();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws RepositorioException 
	 */
	public TelaVisualizarTrabalho() throws IOException, RepositorioException {
		
		IRepositorio repo = new Repositorio("jdbc:mysql://localhost:3306/sgta", "root", "senha");
		
		Arquivo a = repo.buscarArquivoPorID(0);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
//		File PDF_Path = new File("/Users/luizdaniel/Downloads/stanley.ec02.pdf");
		
//		PDDocument inputPDF = PDDocument.load(PDF_Path);
		
		PDDocument inputPDF = PDDocument.load(a.getFile());
		
		PDFRenderer render = new PDFRenderer(inputPDF);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(6, 85, 758, 449);
		lblNewLabel.setIcon(new ImageIcon(render.renderImage(0)));
		contentPane.add(lblNewLabel);
	}
}
