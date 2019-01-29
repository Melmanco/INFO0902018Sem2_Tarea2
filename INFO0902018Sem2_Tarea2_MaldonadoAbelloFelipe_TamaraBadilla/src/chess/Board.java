package chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * 
 * Esta clase es el tablero y se encarga de la organización de los paneles y las piezas dentro del tablero.
 * 
 * @author Felipe Maldonado Abello
 *
 */

public class Board extends JPanel{

	private JPanel panel = null;
	private JPanel square = null;
	private Piece piece = null;
	private ArrayList<JPanel> squareList = new ArrayList<JPanel>();
	
	/**
	 * 
	 * El constructor configura el layout, las dimensiones del tablero,
	 * contiene todos los cuadrados y los pinta,
	 * y agrega las piezas a su correspondiente cuadrado inicial.
	 * 
	 * @param size tamaño del tablero que viene desde la configuración del menú.
	 */
	
	public Board(Dimension size) {
		
		setLayout(new GridLayout(8,8));
		setPreferredSize(size);
		setBounds(0, 0, size.width, size.height);
		
		for (int i = 0; i < 64; i++) {
		
			square = new JPanel(new BorderLayout());
			squareList.add(square);
			add(square);
			
		}
		
		setBoardColor();
		addPieces();

	}

	/**
	 * 
	 * Añade todas las piezas a su cuadrado correspondiente.
	 * 
	 */
	
	public void addPieces() {
		
		piece = new Rook("./data/piezas/piezas blancas/torre.png",Color.white);
		panel = (JPanel)this.getComponent(0);
		piece.setOpaque(false);
		panel.add(piece);
		piece = new Knight("./data/piezas/piezas blancas/caballo.png",Color.white);
		panel = (JPanel)this.getComponent(1);
		piece.setOpaque(false);
		panel.add(piece);
		piece = new Bishop("./data/piezas/piezas blancas/alfil.png",Color.white);
		panel = (JPanel)this.getComponent(2);
		piece.setOpaque(false);
		panel.add(piece);
		piece = new King("./data/piezas/piezas blancas/rey.png",Color.white);
		panel = (JPanel)this.getComponent(3);
		piece.setOpaque(false);
		panel.add(piece);
		piece = new Queen("./data/piezas/piezas blancas/reina.png",Color.white);
		panel = (JPanel)this.getComponent(4);
		piece.setOpaque(false);
		panel.add(piece);
		piece = new Bishop("./data/piezas/piezas blancas/alfil.png",Color.white);
		panel = (JPanel)this.getComponent(5);
		piece.setOpaque(false);
		panel.add(piece);
		piece = new Knight("./data/piezas/piezas blancas/caballo.png",Color.white);
		panel = (JPanel)this.getComponent(6);
		piece.setOpaque(false);
		panel.add(piece);
		piece = new Rook("./data/piezas/piezas blancas/torre.png",Color.white);
		panel = (JPanel)this.getComponent(7);
		piece.setOpaque(false);
		panel.add(piece);
		
		for (int i = 8; i < 16; i++) {
			
			piece = new Pawn("./data/piezas/piezas blancas/peon.png",Color.white,i);
			panel = (JPanel)this.getComponent(i);
			piece.setOpaque(false);
			panel.add(piece);
			
		}
		
		piece = new Rook("./data/piezas/piezas negras/torre.png",Color.black);
		panel = (JPanel)this.getComponent(56);
		piece.setOpaque(false);
		panel.add(piece);
		piece = new Knight("./data/piezas/piezas negras/caballo.png",Color.black);
		panel = (JPanel)this.getComponent(57);
		piece.setOpaque(false);
		panel.add(piece);
		piece = new Bishop("./data/piezas/piezas negras/alfil.png",Color.black);
		panel = (JPanel)this.getComponent(58);
		piece.setOpaque(false);
		panel.add(piece);
		piece = new King("./data/piezas/piezas negras/rey.png",Color.black);
		panel = (JPanel)this.getComponent(59);
		piece.setOpaque(false);
		panel.add(piece);
		piece = new Queen("./data/piezas/piezas negras/reina.png",Color.black);
		panel = (JPanel)this.getComponent(60);
		piece.setOpaque(false);
		panel.add(piece);
		piece = new Bishop("./data/piezas/piezas negras/alfil.png",Color.black);
		panel = (JPanel)this.getComponent(61);
		piece.setOpaque(false);
		panel.add(piece);
		piece = new Knight("./data/piezas/piezas negras/caballo.png",Color.black);
		panel = (JPanel)this.getComponent(62);
		piece.setOpaque(false);
		panel.add(piece);
		piece = new Rook("./data/piezas/piezas negras/torre.png",Color.black);
		panel = (JPanel)this.getComponent(63);
		piece.setOpaque(false);
		panel.add(piece);
		
		for (int i = 48; i < 56; i++) {
			
			piece = new Pawn("./data/piezas/piezas negras/peon.png",Color.black,i);
			panel = (JPanel)this.getComponent(i);
			piece.setOpaque(false);
			panel.add(piece);
			
		}
		
	}
	
	/**
	 * 
	 * Pinta los cuadrados del tablero en su color original.
	 * 
	 */

	public void setBoardColor() {
		
		for (int i = 0; i < 8; i++) {
			
			for (int j = 0; j < 8; j++) {
				int currentIndex = 8 * i + j;
				
				if (i % 2 == 0) squareList.get(currentIndex).setBackground(j % 2 == 0 ? Color.white : Color.black);
				else squareList.get(currentIndex).setBackground(j % 2 == 0 ? Color.black : Color.white);
				
			}
			
		}
		
	}
	
	public ArrayList<JPanel> getSquareList() {
		return squareList;
	}

}