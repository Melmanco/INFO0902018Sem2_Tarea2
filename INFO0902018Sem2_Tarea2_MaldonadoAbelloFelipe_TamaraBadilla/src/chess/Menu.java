package chess;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JFrame{
	
	JButton bStart = null;
	JButton bOptions = null;
	JButton b500x300 = null;
	JButton b800x600 = null;
	JButton bFullscreen = null;
	JButton bBack = null;
	
	private int tamX;
	private int tamY;
	boolean start = false;
	
	public Menu(int tamX,int tamY) throws IOException {

		super("Menu");

		this.tamX =tamX;
		this.tamY =tamY;
		
		//setUndecorated(true);
		setContentPane(new JLabel(new ImageIcon("./data/menuPics/chess.jpg")));
		
		ImageIcon image = new ImageIcon("./data/menuPics/startGame.jpg");
	    bStart = new JButton(image);
		bOptions = new JButton("Opciones");
		
		setSize(tamX,tamY);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		b500x300 = new JButton("500x300");
		b800x600 = new JButton("800x600");
		bFullscreen = new JButton("Fullsc reen");
		bBack = new JButton("Back");
		
		bBack.setBounds(500,400,100,40);
		bFullscreen.setBounds(500,350,200,40);
		b800x600.setBounds(500,300,200,40);
		b500x300.setBounds(500,250,200,40);
		
		b500x300.setVisible(false);
		b800x600.setVisible(false);
		bFullscreen.setVisible(false);
		bBack.setVisible(false);
		
		bStart.setBounds(500,250,200,40);
		bStart.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				start = true;
				dispose();
				
			}
		});
		
		bOptions.setBounds(500,300,200,40);
		bOptions.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				bStart.setVisible(false);
				bOptions.setVisible(false);
				
				b500x300.setVisible(true);
				b800x600.setVisible(true);
				bFullscreen.setVisible(true);
				bBack.setVisible(true);
				
				b500x300.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){

						
					}
				});
				
				b800x600.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){

						
					}
				});
				bFullscreen.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){

						
					}
				});
				
				bBack.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						bStart.setVisible(true);
						bOptions.setVisible(true);
						bBack.setVisible(false);
						
						b500x300.setVisible(false);
						b800x600.setVisible(false);
						bFullscreen.setVisible(false);
						
					}
				});
				
				
			}
			
		});
		add(bBack);
		add(b500x300);
		add(b800x600);
		add(bFullscreen);
		add(bOptions);
		add(bStart);
		setVisible(true);
	}
		

}
