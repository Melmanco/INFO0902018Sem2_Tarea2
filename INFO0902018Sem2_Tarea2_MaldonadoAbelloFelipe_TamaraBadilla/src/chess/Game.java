package chess;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Game extends JFrame {

	Dimension DEFAULT_SIZE = new Dimension(600,600);
	JLayeredPane layeredPane = null;
	Board board  = null;
	Piece piece = null;
	
	public Game() {
		super();
		
		layeredPane = new JLayeredPane();
		this.getContentPane().add(layeredPane);
		layeredPane.setPreferredSize(DEFAULT_SIZE);

		Board board = new Board(DEFAULT_SIZE, layeredPane);
		layeredPane.add(board, JLayeredPane.DEFAULT_LAYER);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		Menu menusito = new Menu(10,10,500,500);
		JFrame game = new Game();
		
	}
		
}
