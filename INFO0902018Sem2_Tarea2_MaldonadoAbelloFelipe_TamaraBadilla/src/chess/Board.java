package chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends JPanel{

	Dimension defaultSize = new Dimension(600,600);
	JPanel square = null;
	
	public Board() {
		super();
		
		this.setLayout(new GridLayout(8,8));
		this.setPreferredSize(defaultSize);
		this.setBounds(0,0,defaultSize.width,defaultSize.height);
		
		for (int i=0; i < 8; i++) {
			
			for (int j=0; j < 8; j++) {
				
				square = new JPanel(new BorderLayout());
				this.add(square);
				
				if (j % 2 == 0) square.setBackground(Color.white);
				
				else square.setBackground(Color.black);
				
			}
			
		}
		
	}
	
	/* agregarPiezas(){
	 * 	agregar imagenes:
	 * 	JLabel piece = null;
	 * 	piece = new JLabel( new ImageIcon("./data/piece.png") );
	 * 	JPanel panel = (JPanel)this.getComponent(0);
	 * 	piece.setOpaque(false);
	 * 	por cada pieza, donde en getComponent(n),
	 * 	n es el lugar de la pieza.
	 * }
	 */
	
}
