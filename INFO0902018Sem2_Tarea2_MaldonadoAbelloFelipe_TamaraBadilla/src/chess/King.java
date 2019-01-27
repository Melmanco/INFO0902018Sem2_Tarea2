package chess;

import java.awt.Color;

public class King extends Piece{

	public King(String imageLocation, Color color) {
		super(imageLocation, color);
	}

	public void checkMoves() {
		
		squareList = ((Board)(getParent().getParent())).getSquareList();
		
		int pieceIndex = squareList.indexOf(this.getParent());
		int pieceJ = pieceIndex % 8;
		int pieceI = (pieceIndex - pieceJ) / 8;
		
		
		for (int i = pieceI - 1; i < pieceI + 2; i++) {
			
			for (int j = pieceJ - 1; j < pieceJ + 2; j++) {
				int currentPanel = 8 * i + j;

				if (i >= 0 && j >= 0 && i < 8 && j < 8) paintPanel(currentPanel);
				
			}
			
		}
		
	}
	
}
