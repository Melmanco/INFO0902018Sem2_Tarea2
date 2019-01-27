package chess;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Piece extends JLabel{
	
	private Color color;
	public ArrayList<JPanel> squareList = null;
	
	public Piece(String imageLocation, Color color) {
		
		super(new ImageIcon(imageLocation));
		setColor(color);
		
	}
	
	public abstract void checkMoves();

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
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
