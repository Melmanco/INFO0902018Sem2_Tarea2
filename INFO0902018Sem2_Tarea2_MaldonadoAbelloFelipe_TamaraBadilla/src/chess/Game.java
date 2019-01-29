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

/**
 *
 * Esta clase se encarga del funcionamiento del flujo del juego en sí,
 * como los turnos, el mouse o si un movimiento es válido.
 * 
 * @author Felipe Maldonado Abello
 *
 */

public class Game extends JFrame implements MouseListener, MouseMotionListener{

	private JLayeredPane layeredPane = null;
	private Board board = null;
	private Piece piece = null;
	private JPanel initialSquare = null;
	private int xAdjustment;
	private int yAdjustment;
	private Color turnColor;
	
	/**
	 * 
	 * Construye Game, configurando cosas como el tablero, los layers y la ventana.
	 * 
	 * @param dimension es la dimensión de la ventana que se configura desde 
	 * la configuración del menú inicial;
	 */
	
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

	/**
	 * 
	 * Verifica si un movimiento es válido, usando los colores
	 * de los paneles que están pintados mientras una pieza esté levantada.
	 * 
	 * @param square es el panel en el cual se verifica si se puede mover.
	 * @return retorna true si el movimiento es válido, false si no lo es.
	 */
	
	public boolean isValidMove(JPanel square) {

		if (square.getBackground() != Color.white && square.getBackground() != Color.black) return true;
		return false;
		
	}
	
	/**
	 * 
	 * Cambia el turno actual por el contrario.
	 * 
	 */
	
	public void changeTurn() {
		
		turnColor = turnColor == Color.white ? Color.black : Color.white;
		
	}
	
	/**
	 * 
	 * Mueve la pieza seleccionada junto al mouse.
	 * 
	 */
	
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

	/**
	 * 
	 * Cuando se presiona en el tablero,
	 * si el componente clickeado no es un JPanel, es decir, si es una pieza,
	 * guarda initialSquare, que sirve para volver la pieza a su posición inicial
	 * si el movimiento no es válido,
	 * guarda la posición al panel desde el mouse,
	 * valida si el turno actual corresponde al color de la pieza presionada
	 * para pintar los paneles de los movimientos posibles,
	 * y se añade la pieza al layeredPane para que pueda moverse
	 * a través del tablero junto al mouse.
	 * 
	 */
	
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

	/**
	 * 
	 * Cuando se suelta el click, si hay una pieza seleccionada,
	 * primero verifica si el lugar donde se soltó tiene una pieza o no,
	 * si el movimiento es válido, pone la pieza en el panel y cambia el turno,
	 * si no, vuelve la pieza a su posición inicial.
	 * 
	 * Al final vuelve todos los paneles del tablero a su color original.
	 * 
	 */
	
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
