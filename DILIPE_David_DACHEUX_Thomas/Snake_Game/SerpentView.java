import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SerpentView extends JPanel { 
	
	
	Tete tete;	
	
	private List<Obstacle> ob;
	
	Canon c;
	private List<Projectile> p;
	
	private int color = 1;//color = 1 -> vert sinon color = magenta(invinsible)
	private int invincible = 0; 
	
	private int chrono = 0;//chrono
	private int timer = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SerpentView(Tete tete, List<Obstacle> ob, Canon c, List<Projectile> p) {
		this.tete = tete;
		this.ob = ob;
		this.c = c;
		this.p = p;
		
		setOpaque(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);
		drawObstacle(g);
		drawSnake(g, color);
		drawCanon(g);
		drawProjectile(g);
		move(g);
		
	}
	
	
	
public void drawObstacle(Graphics g) {
	
for(int i = 0 ; i< ob.size() ; i++) {
		if(ob.get(i).getType() == 1) {//type 1 -> marron
		g.setColor(new Color(153,102,0));//marron
		g.fillRect(ob.get(i).getX()*50 , ob.get(i).getY()*50  , 50,  50);
		}
		if(ob.get(i).getType() == 2) {//type 2 -> fraise
			g.setColor(Color.RED);//fraise
			g.fillRect(ob.get(i).getX() * 50,ob.get(i).getY() *50 , 50,  50);
			
		} if(ob.get(i).getType() == 3) {//type 3 -> myrtille
			g.setColor(Color.BLUE);//myrtille
			g.fillRect(ob.get(i).getX() * 50, ob.get(i).getY() *50 , 50,  50);
			
		} if(ob.get(i).getType() == 4) {//type 4 -> gold
			g.setColor(Color.YELLOW);//gold
			g.fillRect(ob.get(i).getX() * 50, ob.get(i).getY() *50 , 50,  50);
}
	
	
}
	

}
	
	public void drawSnake(Graphics g, int color) {
		
		g.setColor(Color.CYAN);
		g.fillRect(tete.getX() * 50, tete.getY() *50 , 50,  50);
		for(int i = 0 ; i< tete.getSnake().size() ; i++) {
			if(color == 1) {
				g.setColor(Color.GREEN);
				g.fillRect(tete.getSnake().get(i).getX() * 50, tete.getSnake().get(i).getY() *50 , 50,  50);
			}
			if(color == 0) {
				g.setColor(Color.MAGENTA);
				g.fillRect(tete.getSnake().get(i).getX() * 50, tete.getSnake().get(i).getY() *50 , 50,  50);
			}
			
			
		}
		
		
	}
	
	public void removeSnake(Graphics g) {
		
		for(int i = 0 ; i< tete.getSnake().size() ; i++) {
				g.setColor(Color.WHITE);
				g.fillRect(tete.getSnake().get(i).getX() * 50, tete.getSnake().get(i).getY() *50 , 50,  50);
			
		}

		
	}
	
		//dans la boucle for on prend le corps du serpent commencant par la queue et on le fait avancer , cas a part pour la tete 
		public void move(Graphics g) {
			
		if(tete.getSnake().size() == 0) {
			win();
		}
		removeSnake(g);
		removeCanon(g);
		removeProjecile(g);
		
		
		
		Corps temp ;
		if(tete.getSnake().size() > 0) {
			//partie Corps
			temp = new Corps(tete.getSnake().get(tete.getSnake().size() -1).getX(), tete.getSnake().get(tete.getSnake().size() -1).getY());//position -1 du corps du serpent
			for(int i = tete.getSnake().size() - 1 ; i >  0; i--) {
				tete.getSnake().get(i).setX(tete.getSnake().get(i-1).getX());
				tete.getSnake().get(i).setY(tete.getSnake().get(i-1).getY());
				
			}
			tete.getSnake().get(0).setX(tete.getX());
			tete.getSnake().get(0).setY(tete.getY());
			
		}
		else {
			temp = new Corps(tete.getX(), tete.getY());
		
		}
			//partie Tete
			if(tete.getX() + tete.getJ() > 7) {
				tete.setI(1); //vecteur d'avancement vers le bas
				tete.setJ(- tete.getJ());//décalage vers la gauche
			}if(tete.getX() + tete.getJ() < 0) {
				tete.setI(1); //vecteur d'avancement vers le bas
				tete.setJ( - tete.getJ());//décalage vers la droite(negatif - negatif)
			}//partie pour le bois
			
			for(int i = 0 ; i< ob.size() ; i++){
                if(ob.get(i).getType() == 1) {//type 1 -> marron
                    if(tete.getX() + tete.getJ() == ob.get(i).getX() && tete.getY() == ob.get(i).getY()){
                        tete.setI(1); //vecteur d'avancement vers le bas
                        tete.setJ(- tete.getJ());//décalage vers la gauche
                    }
                } if(ob.get(i).getType() == 2) {//type 2 -> fraise
                	if(tete.getX() + tete.getJ() == ob.get(i).getX() && tete.getY() == ob.get(i).getY()){
                	tete.getSnake().add(temp);
                		       		
                }
           }
                if(ob.get(i).getType() == 3) {//type 3 -> myrtille
                	if(tete.getX() + tete.getJ() == ob.get(i).getX() && tete.getY() == ob.get(i).getY()){
                		chrono = timer + 2000; //reste 2 secondes en magenta
                		
                }
            }
               
                if(ob.get(i).getType() == 4) {//type 4 -> gold
                    if(tete.getX() + tete.getJ() == ob.get(i).getX() && tete.getY() == ob.get(i).getY()){
                    for(int j = 0 ; j< ob.size() ; j++) {
                    	int type = ob.get(j).getType();
                    	type = new Random().nextInt(4)+1;
                    	ob.get(j).setType(type);
                    }
             }
           }
		} 
		
			
			
			tete.setX(tete.getX() + tete.getJ());
			//modifie la position suivante de la tete suivant le vecteur direction vers le bas si 0 decends pas si 1 descend
			tete.setY(tete.getY() + tete.getI());
			//modifie la position suivante de la tete suivant le vecteur direction vers la gauche si negatif droite si 1 positif
			
			
			
			if(tete.getI() == 1) {
				tete.setI(0) ;//pour pas que le serpent continue a desendre une fois qu'il l'a deja fait
				tete.setX(tete.getX() - tete.getJ());
			}
			
			if(tete.getY() == c.getY()) {
				gameOver();
			}
			
			timer += 300;//on augemente le timer de 300
			System.out.println(timer);
			this.repaint();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i = 0 ; i< p.size(); i++) {
				p.get(i).setY(p.get(i).getY()-1);
			}
			
			
			if(chrono > timer)
			{
				color = 0;
				invincible = 1;
			
			}else { // des que timer > chrono on remet la couleur de base du serpent(verte) et on enleve l'invincibilité
				color = 1;
				invincible = 0;
			}
			
			drawSnake(g, color);
			
			for(int l = 0 ; l< p.size(); l++) {
				for(int m = 0; m < ob.size(); m++) {
					if(p.get(l).getX() == ob.get(m).getX() && p.get(l).getY() == ob.get(m).getY() ) {
						ob.remove(m);
					}
				}
				if(p.get(l).getX() == tete.getX() && p.get(l).getY() == tete.getY()) {
					if(tete.getSnake().size() > 0 && invincible == 0 ) {
					tete.getSnake().remove(tete.getSnake().size()-1);
					}if(tete.getSnake().size() <= 0)  {
						tete = new Tete(-2,-2,tete.getSnake());//mettre ce qu'il reste en dehors de la fenetre
						
					}
				}
				for(int j =  0 ; j <  tete.getSnake().size(); j++) {
					
					if(p.get(l).getX() == tete.getSnake().get(j).getX() && p.get(l).getY() == tete.getSnake().get(j).getY()) {
						if(tete.getSnake().size() > 0 && invincible == 0) {
							tete.getSnake().remove(tete.getSnake().size()-1);;
							}if(tete.getSnake().size() <= 0)  {
								tete = new Tete(-2,-2,tete.getSnake());//mettre ce qu'il reste en dehors de la fenetre
								
							}
					}
				}	
			}
			
			drawCanon(g);
			drawProjectile(g);
			
			
		}
		
		
		public void drawCanon(Graphics g) {
		
			if(c.getX()>=0 && c.getX() <=8 && c.getY() == 8 && c.getType() == 5) {
		
			g.setColor(Color.BLACK);//canon
			g.fillRect(c.getX() * 50, c.getY() *50 , 50,  50);
			
			}
			
		}
		
		
		
		public void removeCanon(Graphics g) {
			
				g.setColor(Color.WHITE);
				g.fillRect(c.getX() * 50, c.getY() *50 , 50,  50);
						
			
		}
		
		public void drawProjectile(Graphics g) {
			for(int i = 0; i<p.size();i++) {
			g.setColor(Color.BLACK);
			g.fillRect(p.get(i).getX() * 50, p.get(i).getY() *50 , 50,  50);
			}
		}
		
		public void removeProjecile(Graphics g) {
			for(int i = 0; i<p.size();i++) {
			g.setColor(Color.WHITE);
			g.fillRect(p.get(i).getX() * 50, p.get(i).getY() *50 , 50,  50);
			}
		}
			
		
		
		
		public void gameOver() {
			
				JFrame jFrame = new JFrame();
		        JOptionPane.showMessageDialog(jFrame, "GAME OVER");
			
		}
		public void win() {
			
			JFrame jFrame = new JFrame();
	        JOptionPane.showMessageDialog(jFrame, "WIN");
		
	}
		

		
}
