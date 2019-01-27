package chess;

import java.awt.Color;

public class Knight extends Piece{

	public Knight(String imageLocation, Color color) {
		super(imageLocation, color);
	}

	public void checkMoves() {
		
		squareList = ((Board)(getParent().getParent())).getSquareList();
		
		int pieceIndex = squareList.indexOf(this.getParent());
		int pieceJ = pieceIndex % 8;
		int pieceI = (pieceIndex - pieceJ) / 8;
		
		if (pieceI - 1 >= 0 && pieceJ - 2 >= 0) paintPanel(8 * (pieceI - 1) + pieceJ - 2);
		if (pieceI - 2 >= 0 && pieceJ - 1 >= 0) paintPanel(8 * (pieceI - 2) + pieceJ - 1);
		if (pieceI - 2 >= 0 && pieceJ + 1 < 8) paintPanel(8 * (pieceI - 2) + pieceJ + 1);
		if (pieceI - 1 >= 0 && pieceJ + 2 < 8) paintPanel(8 * (pieceI - 1) + pieceJ + 2);
		if (pieceI + 1 < 8 && pieceJ - 2 >= 0) paintPanel(8 * (pieceI + 1) + pieceJ - 2);
		if (pieceI + 2 < 8 && pieceJ - 1 >= 0) paintPanel(8 * (pieceI + 2) + pieceJ - 1);
		if (pieceI + 2 < 8 && pieceJ + 1 < 8) paintPanel(8 * (pieceI + 2) + pieceJ + 1);
		if (pieceI + 1 < 8&& pieceJ + 2 < 8) paintPanel(8 * (pieceI + 1) + pieceJ + 2);
		
	}
	
}
