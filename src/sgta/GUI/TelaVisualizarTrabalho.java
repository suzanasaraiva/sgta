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
	 */
	public TelaVisualizarTrabalho() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		File PDF_Path = new File("/Users/luizdaniel/Downloads/stanley.ec02.pdf");
		
		PDDocument inputPDF = PDDocument.load(PDF_Path);

		PDPageTree pdf = inputPDF.getPages();
		
		PDPage page = pdf.get(0);
		
		PDFPageable a = new PDFPageable(inputPDF);
		
		PDFBox box ;
		
		PDFRenderer render = new PDFRenderer(inputPDF);
		
//		PDFParser parser = new PDFStreamParser(inputPDF);
//		PDPage testPage = (PDPage)allPages.get(0);
//		
//		
//		JFrame testFrame = new JFrame();
//		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		PDFPagePanel pdfPanel = new PDFPagePanel();
//		contentPane.setPage(testPage);
//		contentPane.add(pdfPanel);
//		contentPane.setBounds(40, 40, pdfPanel.getWidth(), pdfPanel.getHeight());
//		contentPane.setVisible(true);
//		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(6, 85, 758, 449);
		lblNewLabel.setIcon(new ImageIcon(render.renderImage(0)));
		contentPane.add(lblNewLabel);
		
	}
}
