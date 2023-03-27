
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.*; 




public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private int key; 
	private ImageIcon background;
	private ArrayList<Invaders> aliens;
	private ArrayList <PlayerProj> playerMiss = new ArrayList();
	private ArrayList<InvaderProj> alienMiss = new ArrayList();
	private PlayerShip player; 
	private int s; 
	private Player p;
	private long currentTime;
	private long startTime;
	private boolean collision, finalTime;
	private int deadAlien;

	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		currentTime = System.currentTimeMillis();
		startTime= System.currentTimeMillis();
		background = new ImageIcon("space.jpg");
		aliens = setAliens();
		p=new Player();
		//add in x & y
		player = new PlayerShip(100,850);
		s = 1;

	}

	
	
	private ArrayList<Invaders> setAliens() {
		// TODO Auto-generated method stub
		ArrayList<Invaders> temp = new ArrayList();
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				temp.add(new Invaders(i*150, j*50));
				
			}
		}
		return temp;
	}



	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	

	
	
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		
		if(!aliens.isEmpty()) {
		
			if((System.currentTimeMillis()-currentTime)%100 == 0) {
				alienMiss.add(new InvaderProj(aliens.get((int)(Math.random()*aliens.size()-1)).getX(),aliens.get(aliens.size()-1).getY()));
				p.playmusic("lazer2.wav");
				currentTime = System.currentTimeMillis();
			}
		}
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
		
		g2d.setFont( new Font("Broadway", Font.BOLD, 50));
		
		collision();
		
		g2d.drawImage(background.getImage(), 0,0, getWidth(), getHeight(), this);
		
		g2d.setColor(Color.white);
		
		g2d.drawImage(player.getShipImg().getImage(), player.getX(), player.getY(), 100, 100, this);
		g2d.drawString("Time: " + (((currentTime-startTime)/1000)%60), 50, 100);
		if(!aliens.isEmpty()) {
			drawAliens(g2d);	
			moveAliens();
			
			if(!playerMiss.isEmpty()){
				drawPlayerMiss(g2d);
			}
			if(!alienMiss.isEmpty()) {
				drawalienMiss(g2d);
			}
			}
		if(aliens.isEmpty()) {
			g2d.drawString("YOU WIN!", 500, 500);
			player.setY(1000);
		}
		
		twoDgraph.drawImage(back, null, 0, 0);
}

	



	private void drawPlayerMiss(Graphics g2d) {
		// TODO Auto-generated method stub
		for(PlayerProj pm: playerMiss) {
			g2d.drawImage(pm.getShipImg().getImage(),pm.getX(),pm.getY(),pm.getW(),pm.getH(),this);
			pm.move();
		}
		
	}
	private void drawalienMiss(Graphics g2d) {
		// TODO Auto-generated method stub
		for(InvaderProj am: alienMiss) {
			g2d.drawImage(am.getShipImg().getImage(),am.getX(),am.getY(),am.getW(),am.getH(),this);
			am.move();
		}
		
	}
	private boolean checkWall() {
		for(Invaders inv : aliens) {
			if(inv.getX()<0 || inv.getX()+inv.getW()>=1800) {
				return true;
		}
			
		}
		return false;
		
	}
	private void moveAliens() {
		if(checkWall() == true) {
			for(Invaders inv : aliens) {
			
				inv.reverseHorz();
				inv.setY(inv.getY()+10);
				
			}
			
		}
		
		
		for(Invaders inv : aliens) {
			
			inv.Hmove();
		}
	}

	private boolean collision() {
		
		for(int a=0;a<aliens.size();a++) {
	for(int pm=0;pm<playerMiss.size();pm++) {
	if	( ( ( aliens.get(a).getY() <= playerMiss.get(pm).getY() + playerMiss.get(pm).getH() && playerMiss.get(pm).getY() <= aliens.get(a).getY()+aliens.get(a).getH()) && (aliens.get(a).getX() <= playerMiss.get(pm).getX() + playerMiss.get(pm).getW() && playerMiss.get(pm).getX() <= aliens.get(a).getX() + aliens.get(a).getW()) ) && playerMiss.get(pm).getDy() <0)
	{
			deadAlien = deadAlien+1;
			aliens.remove(a);
			finalTime = true;
			p.playmusic("x.wav");
			return true;
		
			
	}
	}
}
return false;
}

	
	 



	private void drawAliens(Graphics g2d) {
		// TODO Auto-generated method stub
		for(Invaders inv : aliens) {
			g2d.drawImage(inv.getShipImg().getImage(), inv.getX(), inv.getY(), inv.getW(), inv.getH(), this);
		}
	} 



	//DO NOT DELETE
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




//DO NOT DELETE
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key= e.getKeyCode();
		System.out.println(key);
		if(e.getKeyCode() ==32) {
			playerMiss.add(new PlayerProj(player.getX()+20+player.getW()/2,player.getY()));
			p.playmusic("lazerSound.wav");
		}
		
		
	}


	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		key=e.getKeyCode();
		System.out.println(key);
		if(e.getKeyCode()==40) {
			aliens.clear();
		}
		if(e.getKeyCode()==18) {
			background= new ImageIcon("background2.jpg");
			
		
		}
		
	
		
	
	key=e.getKeyCode();
	System.out.println(key);
	if(e.getKeyCode()==40) {
		aliens.clear();
	}
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		player.setX(arg0.getX());
	}



	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		playerMiss.add(new PlayerProj(player.getX()+20+player.getW()/2,player.getY()));
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
}
