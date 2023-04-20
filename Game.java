import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Game extends JPanel implements Runnable{
	
	
	private BufferedImage back;
	private ImageIcon background;
	
	public Game() {
		background = new ImageIcon("bg.png");
		
	}{
	
	//public void run() {
		try {
			while(true) {
				Thread.currentThread().sleep(5);
				repaint();
			}
		}
		catch(Exception e) {}
	}

	public void paint (Graphics g)
	{
		Graphics2D twoDgraph = (Graphics2D)g;
	//take a snap shop of the current screen and same it as an image
	//that is the exact same width and height as the current screen
		if (back==null) {
			back =(BufferedImage) (createImage(getWidth(), getHeight()));
				}

	//create a graphics reference to the back ground image
	//we will draw all changes on the background image
		Graphics g2d = back.createGraphics();
		
		//this clears the old image, like an EtchASketch. If you see the old image when we learn motion, you deleted this line.
		g2d.clearRect(0, 0, getSize().width, getSize().height); 
		
		
		//START CODING GRAPHICS HERE
		
		
		//creates a new color
		Color mynewcolor = new Color(139,53,153);
		//sets the new color. Think of the computer picking up a pen
		g2d.setColor(mynewcolor);
		
		//sets a new font
		g2d.setFont(new Font ("Times New Roman", Font.PLAIN, 36));
		
		//draws a String starting at x coordinate 20 and y coordinate 30
		g2d.drawString("Hi Class!",  20, 30);
		
		g2d.setColor(Color.CYAN);
		g2d.setFont(new Font ("BROADWAY", Font.BOLD, 36));
		g2d.drawString("It is raining outisde",  200, 300);
		
		
		//This line tells the program to draw everything above. If you delete this, nothing will show up.
		twoDgraph.drawImage(back, 0, 0, null);
	}}
	


