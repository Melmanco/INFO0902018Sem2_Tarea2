package chess;

import java.awt.Color;

public class Pawn extends Piece{

	private int initialIndex;
	
	public Pawn(String imageLocation, Color color, int initialIndex) {
		super(imageLocation, color);
		this.initialIndex = initialIndex;
	}

	public void checkMoves() {
		
		squareList = ((Board)(getParent().getParent())).getSquareList();
		
		int pieceIndex = squareList.indexOf(this.getParent());
		int pieceJ = pieceIndex % 8;
		int pieceI = (pieceIndex - pieceJ) / 8;
			
		try {
			if (initialIndex == pieceIndex) {
				if (getColor() == Color.black) {
					if(paintPanel(8 * (pieceI - 1) + pieceJ, false))
						paintPanel(8 * (pieceI - 2) + pieceJ, false);
				}else {	
					if(paintPanel(8 * (pieceI + 1) + pieceJ, false))
						paintPanel(8 * (pieceI + 2) + pieceJ, false);
				}
			}else {
				if (getColor() == Color.black) paintPanel(8 * (pieceI - 1) + pieceJ, false);
				else paintPanel(8 * (pieceI + 1) + pieceJ, false);
			}
			
			if (getColor() == Color.black) {
				if (pieceJ - 1 >= 0) paintPanel(8 * (pieceI - 1) + pieceJ - 1, true);
				if (pieceJ + 1 < 8) paintPanel(8 * (pieceI - 1) + pieceJ + 1, true);
			}else {
				if (pieceJ - 1 >= 0) paintPanel(8 * (pieceI + 1) + pieceJ - 1, true);
				if (pieceJ + 1 < 8) paintPanel(8 * (pieceI + 1) + pieceJ + 1, true);
			}
		}
		catch (IndexOutOfBoundsException e) {;}
		
	}

	public boolean paintPanel(int currentPanel, boolean attack) {
		
		try { 
			if (((Piece)squareList.get(currentPanel).getComponent(0)).getColor() != this.getColor()) {
				if (attack) squareList.get(currentPanel).setBackground(Color.red);	
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			if (!attack) squareList.get(currentPanel).setBackground(Color.blue);
			return true;
		}
		catch (NullPointerException e) {;}
		
		return false;
		
	}
	
}
