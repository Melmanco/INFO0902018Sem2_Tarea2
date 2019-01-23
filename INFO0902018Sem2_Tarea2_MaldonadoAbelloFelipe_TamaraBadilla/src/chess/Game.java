package chess;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

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
	
	public static void main(String[] args) throws IOException {

		Menu menusito = new Menu(300,50,800,600);
		menusito.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
		        if (menusito.start) {
					JFrame game = new Game();
		        }
			}
		});
	
		
	}
		
}
