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
	
	JButton button = null;
	
	private int posX;
	private int posY;
	private int tamX;
	private int tamY;
	boolean start = false;
	
	public Menu(int posX,int posY,int tamX,int tamY) throws IOException {

		super("Menu");
		
		this.posX =posX;
		this.posY =posY;
		this.tamX =tamX;
		this.tamY =tamY;
		
		//setUndecorated(true);
		setContentPane(new JLabel(new ImageIcon("./data/menuPics/chess.jpg")));
		
		ImageIcon image = new ImageIcon("./data/menuPics/startGame.jpg");
	    button = new JButton(image);
		
		//setBounds(posX,posY,tamX,tamY);
		setSize(tamX,tamY);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.setBounds(500,250,200,40);
		button.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				start = true;
				dispose();
				
			}
		});
		
		add(button);
		setVisible(true);
	}
		

}
