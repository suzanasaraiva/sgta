package sgta.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Composite;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.util.List;
import java.util.Map;

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
import sgta.util.ImageHelper;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class TelaVisualizarTrabalho extends JFrame {

	private JPanel contentPane;
	private JLabel pageCounter;
	private PDFRenderer render;
	private int currentPage;
	private int numberPages;
	private JButton forward;
	private JButton backward;
	private JButton fastBackward;
	private JButton fastForward;

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
		
		this.currentPage = 0;
		
		Arquivo a = repo.buscarArquivoPorID(5);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 780);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		PDDocument inputPDF = PDDocument.load(a.getFile());

		
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
		
		this.updatePageCounter();
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
