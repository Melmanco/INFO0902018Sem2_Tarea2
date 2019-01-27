package chess;

import java.awt.Color;
import java.util.ArrayList;
import java.util.function.Predicate;

import javax.swing.JPanel;

public class Rook extends Piece{
	
	public Rook(String imageLocation, Color color) {
		super(imageLocation, color);
	}

	
	public void checkMoves() {

		squareList = ((Board)(getParent().getParent())).getSquareList();
		
		int pieceIndex = squareList.indexOf(this.getParent());
		int pieceJ = pieceIndex % 8;
		int pieceI = (pieceIndex - pieceJ) / 8;
		
		boolean up = true;
		boolean down = true;
		boolean left = true;
		boolean right = true;
		
		for (int x = 1; x < 8; x++) {

			if (up && pieceI - x >= 0) up = paintPanel(8 * (pieceI - x) + pieceJ);
			if (down && pieceI + x < 8) down = paintPanel(8 * (pieceI + x) + pieceJ);
			if (left && pieceJ - x >= 0) left = paintPanel(8 * (pieceI) + pieceJ - x);
			if (right && pieceJ + x < 8 ) right = paintPanel(8 * (pieceI) + pieceJ + x);

		}
				
	}
		
}
