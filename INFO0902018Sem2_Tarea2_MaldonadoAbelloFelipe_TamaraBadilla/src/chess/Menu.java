package chess;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class Menu extends JFrame{
	
	JButton bStart = null;
	JButton bOptions = null;
	JButton bBack = null;
	JButton bQuit = null;
	JToggleButton b800x800 = null;
	JToggleButton b1000x1000 = null;
	JToggleButton bSetDefault = null;
	
	ButtonGroup sizes = null;
	
	private int tamX;
	private int tamY;
	boolean start = false;
	
	Dimension dimension;
	
	public Menu(int tamX,int tamY) throws IOException {

		super("Menu");

		this.tamX =tamX;
		this.tamY =tamY;
		
		dimension = new Dimension(600,600);
		//setUndecorated(true);
		setContentPane(new JLabel(new ImageIcon("./data/menuPics/chess.jpg")));
		
		ImageIcon iStartGame = new ImageIcon("./data/menuPics/startGame2.jpg");
		ImageIcon i1000x1000U = new ImageIcon("./data/menuPics/1000x1000.jpg");
		ImageIcon i800x800U = new ImageIcon("./data/menuPics/800x800.jpg");
		ImageIcon iDefaultSizeU = new ImageIcon("./data/menuPics/defaultSizeButton.jpg");
		ImageIcon ioptionsButton = new ImageIcon("./data/menuPics/optionsButton.jpg");
		ImageIcon iQuitButton = new ImageIcon("./data/menuPics/quitButton.jpg");
		
		ImageIcon i1000x1000P = new ImageIcon("./data/menuPics/pressed1000x1000.jpg");
		ImageIcon i800x800P = new ImageIcon("./data/menuPics/pressed800x800.jpg");
		ImageIcon iDefaultSizeP = new ImageIcon("./data/menuPics/presseddefaultSizeButton.jpg");
		
		
	    bStart = new JButton(iStartGame);
		bOptions = new JButton(ioptionsButton);
		
		setSize(tamX,tamY);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon iBack = new ImageIcon("./data/menuPics/backButton.png");
		
		b800x800 = new JToggleButton();		
		b1000x1000 = new JToggleButton();
		bSetDefault = new JToggleButton();
		
		bSetDefault.setIcon(iDefaultSizeP);
				
		sizes = new ButtonGroup();
		
		bSetDefault.setSelected(true);
		
		sizes.add(b800x800);
		sizes.add(b1000x1000);
		sizes.add(bSetDefault);
		
		bBack = new JButton(iBack);
		bQuit = new JButton(iQuitButton);
		
		bBack.setOpaque(false);
		bBack.setContentAreaFilled(false);
		bBack.setBorderPainted(false);
		
		bBack.setBounds(500,400,100,40);
		bSetDefault.setBounds(500,350,200,40);
		b1000x1000.setBounds(500,300,200,40);
		b800x800.setBounds(500,250,200,40);
		
		b800x800.setVisible(false);
		b1000x1000.setVisible(false);
		bSetDefault.setVisible(false);
		bBack.setVisible(false);
		
		bStart.setBounds(500,250,200,40);
		bQuit.setBounds(500,300,200,40);
		bQuit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
			
		});
		bStart.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				start = true;
				dispose();
				
			}
		});
		
		bOptions.setBounds(500,300,200,40);
		bQuit.setBounds(500,350,200,40);
		
		bOptions.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
								
				bStart.setVisible(false);
				bOptions.setVisible(false);
				bQuit.setVisible(false);
				
				b800x800.setVisible(true);
				b1000x1000.setVisible(true);
				bSetDefault.setVisible(true);
				bBack.setVisible(true);
				
				b800x800.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
						dimension = new Dimension(800,800);
						
					}
				});
				b1000x1000.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						dimension = new Dimension(1000,1000);
						
					}
				});
				bSetDefault.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						dimension = new Dimension(600,600);
						
					}
				});
				
				bBack.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						bStart.setVisible(true);
						bOptions.setVisible(true);
						bBack.setVisible(false);
						bQuit.setVisible(true);
						
						b800x800.setVisible(false);
						b1000x1000.setVisible(false);
						bSetDefault.setVisible(false);
						
					}
				});
				
				
			}
			
		});
		add(bQuit);
		add(bSetDefault);
		add(bBack);
		add(b800x800);
		add(b1000x1000);
		add(bOptions);
		add(bStart);
		setVisible(true);
	}
		
}
