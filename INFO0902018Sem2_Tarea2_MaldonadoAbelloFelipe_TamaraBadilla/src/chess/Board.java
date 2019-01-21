package chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Board extends JPanel implements MouseListener, MouseMotionListener{

	JPanel square = null;
	JLabel piece = null;
	JPanel panel = null;
	int xAdjustment;
	int yAdjustment;
	JLayeredPane layeredPane = null;
	
	public Board(Dimension size, JLayeredPane layeredPane) {
		super();
		
		this.layeredPane = layeredPane;
		this.setLayout(new GridLayout(8,8));
		this.setPreferredSize(size);
		this.setBounds(0,0,size.width,size.height);
		
		for (int i=0; i < 8; i++) {
			
			for (int j=0; j < 8; j++) {
				
				square = new JPanel(new BorderLayout());
				this.add(square);
				
				if (i % 2 == 0) square.setBackground(j % 2 == 0 ? Color.white : Color.black);
				else square.setBackground(j % 2 == 0 ? Color.black : Color.white);
				
			}
			
		}

		addPieces();
		
	}
	
	public void addPieces() {
		
			piece = null;
			piece = new JLabel(new ImageIcon("./data/piezas/piezas blancas/torre.png"));
			panel = (JPanel)this.getComponent(0);
			piece.setOpaque(false);
			panel.add(piece);
			piece = new JLabel(new ImageIcon("./data/piezas/piezas blancas/caballo.png"));
			panel = (JPanel)this.getComponent(1);
			piece.setOpaque(false);
			panel.add(piece);
			piece = new JLabel(new ImageIcon("./data/piezas/piezas blancas/alfil.png"));
			panel = (JPanel)this.getComponent(2);
			piece.setOpaque(false);
			panel.add(piece);
			piece = new JLabel(new ImageIcon("./data/piezas/piezas blancas/rey.png"));
			panel = (JPanel)this.getComponent(3);
			piece.setOpaque(false);
			panel.add(piece);
			piece = new JLabel(new ImageIcon("./data/piezas/piezas blancas/reina.png"));
			panel = (JPanel)this.getComponent(4);
			piece.setOpaque(false);
			panel.add(piece);
			piece = new JLabel(new ImageIcon("./data/piezas/piezas blancas/alfil.png"));
			panel = (JPanel)this.getComponent(5);
			piece.setOpaque(false);
			panel.add(piece);
			piece = new JLabel(new ImageIcon("./data/piezas/piezas blancas/caballo.png"));
			panel = (JPanel)this.getComponent(6);
			piece.setOpaque(false);
			panel.add(piece);
			piece = new JLabel(new ImageIcon("./data/piezas/piezas blancas/torre.png"));
			panel = (JPanel)this.getComponent(7);
			piece.setOpaque(false);
			panel.add(piece);
			
			for (int i = 8; i < 16; i++) {
				
				piece = new JLabel(new ImageIcon("./data/piezas/piezas blancas/peon.png"));
				panel = (JPanel)this.getComponent(i);
				piece.setOpaque(false);
				panel.add(piece);
				
			}
			
			piece = new JLabel(new ImageIcon("./data/piezas/piezas negras/torre.png"));
			panel = (JPanel)this.getComponent(56);
			piece.setOpaque(false);
			panel.add(piece);
			piece = new JLabel(new ImageIcon("./data/piezas/piezas negras/caballo.png"));
			panel = (JPanel)this.getComponent(57);
			piece.setOpaque(false);
			panel.add(piece);
			piece = new JLabel(new ImageIcon("./data/piezas/piezas negras/alfil.png"));
			panel = (JPanel)this.getComponent(58);
			piece.setOpaque(false);
			panel.add(piece);
			piece = new JLabel(new ImageIcon("./data/piezas/piezas negras/rey.png"));
			panel = (JPanel)this.getComponent(59);
			piece.setOpaque(false);
			panel.add(piece);
			piece = new JLabel(new ImageIcon("./data/piezas/piezas negras/reina.png"));
			panel = (JPanel)this.getComponent(60);
			piece.setOpaque(false);
			panel.add(piece);
			piece = new JLabel(new ImageIcon("./data/piezas/piezas negras/alfil.png"));
			panel = (JPanel)this.getComponent(61);
			piece.setOpaque(false);
			panel.add(piece);
			piece = new JLabel(new ImageIcon("./data/piezas/piezas negras/caballo.png"));
			panel = (JPanel)this.getComponent(62);
			piece.setOpaque(false);
			panel.add(piece);
			piece = new JLabel(new ImageIcon("./data/piezas/piezas negras/torre.png"));
			panel = (JPanel)this.getComponent(63);
			piece.setOpaque(false);
			panel.add(piece);
			
			for (int i = 48; i < 55; i++) {
				
				piece = new JLabel(new ImageIcon("./data/piezas/piezas negras/peon.png"));
				panel = (JPanel)this.getComponent(i);
				piece.setOpaque(false);
				panel.add(piece);
				
			}
			
		}
	
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

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		piece = null;
		Component c = findComponentAt(e.getX(),e.getY());
		
		if (c instanceof JPanel) return;
		System.out.println("clickpieza");
		Point parentLocation = c.getParent().getLocation();
		xAdjustment = parentLocation.x - e.getX();
		xAdjustment = parentLocation.y - e.getY();
		piece = (Piece)c;
		piece.setLocation(parentLocation.x, parentLocation.y);
		piece.setSize(piece.getWidth(),piece.getHeight());
		layeredPane.add(piece, JLayeredPane.DRAG_LAYER);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (piece == null) return;
		
		piece.setVisible(false);
		Component c = findComponentAt(e.getX(), e.getY());
		
		if (c instanceof JLabel) {
			
			Container parent = c.getParent();
			parent.remove(0);
			parent.add(piece);
			
		}
		else {
			
			Container parent = (Container)c;
			parent.add(piece);
			
		}
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
				
}
