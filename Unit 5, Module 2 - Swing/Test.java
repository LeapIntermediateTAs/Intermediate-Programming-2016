import static java.lang.System.out;

import java.util.Random;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.SwingUtilities;

public class Test { 
	public static JFrame createWindow(String title, int width, int height) {
		JFrame window = new JFrame();
		window.setTitle(title);
		window.setSize(width*2, height*2);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel panel = new Panel();
		window.add(panel);
		
		return window;
	}
	
	public static void main(String args[]) {
		createWindow("Swing Example", 1000, 750).setVisible(true);
	}
}

@SuppressWarnings("serial")
class Panel extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {	
	int x = 120;
	int y = 120;
	int a = 0;
	int c = 200;
	int d = 500;
	int f = 500;
	int r = 10;
	int green = 10;
	int b = 255;
	int n;
	Random randomizer = new Random();
	
	public Panel() {
		this.setFocusable(true);
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		requestFocus();
		
		JButton moveHello = new JButton("Move Hello");
		moveHello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				x = x + 10;
				y = y + 10;
				repaint();
			}
		});
		this.add(moveHello);
		
		JButton goCrazy = new JButton("Win $1M");
		final Timer timer = new Timer(1, this);
		goCrazy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				n = randomizer.nextInt(1000000 + 1);
				timer.start();
			}
		});
		this.add(goCrazy);
	}
	
	public void actionPerformed(ActionEvent event) {
		out.println("Going crazy.");
		
		r = randomizer.nextInt(255);
		green = randomizer.nextInt(255);
		b = randomizer.nextInt(255);
		repaint();
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			y-=20;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			y+=20;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			x-=20;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			x+=20;
		}
		repaint();
	}
	
	public void keyReleased(KeyEvent e) {	
		
	}
	
	public void keyTyped(KeyEvent e) {	
		
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void mouseMoved(MouseEvent e) {
		a = e.getX();
		c = e.getY();
		repaint();
	}
	
	public void mouseDragged(MouseEvent e) {
		d = e.getX();
		f = e.getY();
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(new Color(r, green, b));
		g.fillRect(0, 0, 20, 40);
		g.fillOval(60, 60, 800, 600);
		Font font = new Font("Roboto", Font.PLAIN, 14*2);
		g.setFont(font);
		g.drawString("Hello!", x, y);
		g.fillRoundRect(a, c, 200, 200, 10, 10);
		g.draw3DRect(d, f, 100, 100, true);
	}
}
