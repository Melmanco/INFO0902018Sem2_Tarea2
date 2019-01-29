package chess;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Game extends JFrame implements MouseListener, MouseMotionListener{

	private JLayeredPane layeredPane = null;
	private Board board = null;
	private Piece piece = null;
	private JPanel initialSquare = null;
	private int xAdjustment;
	private int yAdjustment;
	private Color turnColor;
	
	public Game(Dimension dimension) {
		
		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane);
		layeredPane.setPreferredSize(dimension);
		layeredPane.addMouseListener(this);
		layeredPane.addMouseMotionListener(this);
		
		board = new Board(dimension);
		layeredPane.add(board, JLayeredPane.DEFAULT_LAYER);
		
		turnColor = Color.white;
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
				
	}

	public boolean isValidMove(JPanel square) {

		if (square.getBackground() != Color.white && square.getBackground() != Color.black) return true;
		return false;
		
	}
	
	public void changeTurn() {
		
		turnColor = turnColor == Color.white ? Color.black : Color.white;
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (piece == null) return;
		
		piece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		piece = null;
		Component c = board.findComponentAt(e.getX(),e.getY());
		
		if (c instanceof JPanel) return;
		
		Point parentLocation = c.getParent().getLocation();
		initialSquare = (JPanel)c.getParent();
		
		xAdjustment = parentLocation.x - e.getX();
		yAdjustment = parentLocation.y - e.getY();
		
		piece = (Piece)c;
		if (piece.getColor() == turnColor) piece.checkMoves();
		piece.setLocation(parentLocation.x,parentLocation.y);
		piece.setSize(piece.getWidth(),piece.getHeight());
		
		layeredPane.add(piece, JLayeredPane.DRAG_LAYER);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (piece == null) return;
		
		piece.setVisible(false);
		
		Component c = board.findComponentAt(e.getX(),e.getY());
		
		Container parent = null;
		
		if (c instanceof JLabel) parent = c.getParent();
		else parent = (Container)c;

		if	(isValidMove((JPanel) parent)) {
			
			if (c instanceof JLabel) parent.remove(0);
			parent.add(piece);
			changeTurn();
			
		}else initialSquare.add(piece);
			
		board.setBoardColor();
		piece.setVisible(true);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) throws IOException {

		Menu menu = new Menu();
	
	}

}
