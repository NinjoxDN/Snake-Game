import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;


public class MyListener implements KeyListener,MouseListener {
	
	private Canon c;
	private List<Projectile> p;
	
	public MyListener(Canon c,List<Projectile> p) {
		this.c = c;
		this.p = p;
		
		
	}
	
	
	//Partie Canon
	public void right() {
	
		if(c.getX() < 8) {
		c.setX(c.getX()+1);
		
		}
	}
	
	public void left() {
		
		if(c.getX() > 0) {
		c.setX(c.getX()-1);
		
		
		}
	}
	public void tir() {
		p.add(new Projectile(c.getX(), c.getY()));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		switch(e.getKeyChar()) {
			case 'q' : left();
				break;
			case 'd' : right();
				break;
			
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case 32 : 
				tir();
				break;
			}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		 System.out.println("Key code  "  + e.getKeyCode());
		 System.out.println("Touche du clavier : "  + e.getKeyChar());
		 System.out.println(c.getX() +" ; "+c.getY() );
		 
		
	}
	
	


	
	
	//Partie Projectile
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
