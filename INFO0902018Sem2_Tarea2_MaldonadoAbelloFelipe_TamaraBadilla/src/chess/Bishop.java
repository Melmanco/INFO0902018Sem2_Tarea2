package chess;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Bishop extends Piece{

	public Bishop(String imageLocation, Color color) {
		super(imageLocation, color);
	}

	public void checkMoves() {
		
		squareList = ((Board)getParent().getParent()).getSquareList();
		
		int pieceIndex = squareList.indexOf(this.getParent());
		int pieceJ = pieceIndex % 8;
		int pieceI = (pieceIndex - pieceJ) / 8;
		
		boolean upLeft = true;
		boolean upRight = true;
		boolean downLeft = true;
		boolean downRight = true;
		
		for (int x = 1; x < 8; x++) {
			
			if (upLeft && pieceI - x >= 0 && pieceJ - x >= 0) upLeft = paintPanel(8 * (pieceI - x) + pieceJ - x);
			if (upRight && pieceI - x >= 0 && pieceJ + x < 8) upRight = paintPanel(8 * (pieceI - x) + pieceJ + x);
			if (downLeft && pieceI + x < 8 && pieceJ - x >= 0) downLeft = paintPanel(8 * (pieceI + x) + pieceJ - x);
			if (downRight && pieceI + x < 8 && pieceJ + x < 8) downRight = paintPanel(8 * (pieceI + x) + pieceJ + x);
			
		}
		
	}
	
}
