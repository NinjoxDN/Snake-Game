import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class App {

	
	 public static void main(String[] args) { 
		 //création du corps
		 Corps c1 = new Corps(0,0);
		 Corps c2 = new Corps(1,0);
		 Corps c3 = new Corps(2,0);
		 List body = new ArrayList<Corps> ();
		 body.add(c3);
		 body.add(c2);
		 body.add(c1);
		 //création de la tete
		 Tete t = new Tete(3, 0, body);
		 
		 //création des différents obstacles en les ajoutant dans la liste d'obstacle
		 Obstacle obj = new Obstacle(1, 1, 1);
		 Obstacle obj1 = new Obstacle(5, 5, 2);
		 Obstacle obj2 = new Obstacle(6, 5, 3);
		 Obstacle obj3 = new Obstacle(4, 3, 4);
		 Obstacle obj4 = new Obstacle(2, 7, 1);
		 Obstacle obj5 = new Obstacle(3, 3, 2);
		 Obstacle obj6 = new Obstacle(6, 0, 3);
		 Obstacle obj7 = new Obstacle(2, 3, 4);
		 Obstacle obj8 = new Obstacle(5, 6, 1);
		 Obstacle obj9 = new Obstacle(4, 5, 2);
		 Obstacle obj10 = new Obstacle(5, 1, 3);
		 Obstacle obj11 = new Obstacle(5, 2, 4);
		 
		
		 List ob = new ArrayList<Obstacle> ();
		 ob.add(obj);
		 ob.add(obj1);
		 ob.add(obj2);
		 ob.add(obj3);
		 ob.add(obj4);
		 ob.add(obj5);
		 ob.add(obj6);
		 ob.add(obj7);
		 ob.add(obj8);
		 ob.add(obj9);
		 ob.add(obj10);
		 ob.add(obj11);
		 
		 //obsatcle aleatoire
		 /*for(int i = 0; i< 20;i++ ) {
			 Obstacle obj = new Obstacle(new Random().nextInt(8), new Random().nextInt(8), new Random().nextInt(4));
			 ob.add(obj);
		 }
*/
		 Canon canon = new Canon(4,8,5);
		 List<Projectile> projectile = new ArrayList<Projectile>(); 
		 
		 SerpentView sv = new SerpentView(t,ob, canon,projectile );
		 
		 JFrame fenetre = new JFrame("Falling Snake ");
		 MyListener clavier = new MyListener(canon, projectile);
		 fenetre.addKeyListener(clavier);
		 fenetre.setBackground(Color.WHITE);

		 fenetre.add(sv);
		 
		 fenetre.setSize(500, 500); 
		 //fenetre.setResizable(false);
	     //fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 //fenetre.setLocationRelativeTo(null);
		  
		 fenetre.setVisible(true);
		
	 }



}

