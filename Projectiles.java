import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Projectiles {
	private int x, y, w, h, dx, dy;
	//private ImageIcon ShipImg;
	
	//public boolean collision(SpaceShip s) {
		//Rectangle ship = new Rectangle(s.getX(), s.getY(), s.getW(),s.getH());
		//Rectangle missile = new Rectangle(getX(), getY(), getW(), getH());
		
		//if(ship.intersects(missile)) {
			//return true; 
		//}
		
		//return false;
	//}
	public Projectiles() {
		x= 1;
		y = 1;
		w = 1;
		h = 1;
		//ShipImg = new ImageIcon("");
		dx = 0;
		dy = 0;
	}
	public Projectiles(int xV, int yV, int width, int height, ImageIcon i) {
		x = xV;
		y= yV;
		w = width;
		h = height;
		//ShipImg = i;
		dx = 1;
		dy = 4;
	}
	public Projectiles(int xV, int yV, ImageIcon i) {
		x = xV;
		y= yV;
		w = 10;
		h = 20;
		//ShipImg = i;
		dx = 0;
		dy = -10;
	}

	public int getX() {
	
		return x;
	}
	public int getY() {
		
		return y;
	}
	public int getW() {
		
		return w;
	}
	public int getH() {
	
		return h;
	}
	//public ImageIcon getShipImg() {
		//return ShipImg;
	//}
	
	public int getDx() {
		return dx;
	}
	public void setDx(int dx) {
		this.dx = dx;
	}
	public int getDy() {
		return dy;
	}
	public void setDy(int dy) {
		this.dy = dy;
	}
	public void setX(int xV) {
		x=xV;
	}
	public void setY(int yV) {
		y=yV;
	}
	public void setW(int width) {
		w+=width;
	}
	public void setH(int height) {
		h+=height;
	}
	public void move() {
		y+=dy;
	}
}


