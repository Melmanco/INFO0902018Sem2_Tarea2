package chess;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * Se encarga del funcionamiento de la pieza,
 * configurando su color, su imagen, verifica los actuales movimientos posibles y pinta sus paneles.
 * 
 * @author Felipe Maldonado Abello
 *
 */

public abstract class Piece extends JLabel{
	
	private Color color;
	public ArrayList<JPanel> squareList = null;
	
	public Piece(String imageLocation, Color color) {
		
		super(new ImageIcon(imageLocation));
		setColor(color);
		
	}
	
	/**
	 * 
	 * Pinta los movimientos posibles,
	 * es abstract porque cada pieza tiene un movimiento diferente.
	 * 
	 */
	
	public abstract void checkMoves();

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * 
	 * Pinta un panel, azul si se puede mover hacia él, rojo si se puede atacar a una pieza en él,
	 * o no lo pinta si el movimiento no es posible.
	 * 
	 * @param currentPanel panel a pintar.
	 * @return retorna true si pinta azul, es decir, si no hay ninguna pieza
	 * y puede seguir pintando en el camino correspondiente a la pieza,
	 * retorna false si pinta rojo o no pinta, es decir, si encuentra alguna pieza
	 * y no puede seguir pintando en el camino correspondiente a la pieza.
	 */
	
	public boolean paintPanel(int currentPanel) {
		
		try { 
			if (((Piece)squareList.get(currentPanel).getComponent(0)).getColor() != this.getColor()) {
				squareList.get(currentPanel).setBackground(Color.red);
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			squareList.get(currentPanel).setBackground(Color.blue);
			return true;
		}
		catch (NullPointerException e) {;}
		
		return false;
		
	}
	
}
