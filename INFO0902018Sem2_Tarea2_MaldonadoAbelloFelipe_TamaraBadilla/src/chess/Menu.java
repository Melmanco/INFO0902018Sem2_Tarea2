package chess;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JFrame{
	
	private JButton boton = null;
	
	private int posX;
	private int posY;
	private int tamX;
	private int tamY;
	
	public Menu(int posX,int posY,int tamX,int tamY) {
		super("Menu");
		setBounds(posX,posY,tamX,tamY);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setVisible(true);
	}
		

}
