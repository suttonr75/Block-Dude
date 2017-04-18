import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUI extends JPanel implements KeyListener{
	private Level level;
	private JFrame frame;
	private boolean move =false;
	GUI(Level l){
		level = l;
		frame = new JFrame("Block Dude");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);

		frame.add(this);
		frame.setVisible(true);
		frame.addKeyListener(this);

	}
	public void paintComponent(Graphics g){
	super.paintComponent(g);
	if(move){
		
		g.fillRect(level.getDudeX()*20,level.getDudeY()*20, 20, 20);
		
	}
	for(int i = 0;i<level.width;i++){
		for(int j = 0;j<level.height;j++){
			if(level.getBlock(i, j).getFixed()){
				g.setColor(Color.gray);
				g.fillRect(i*20, j*20, 20, 20);
			}
			if(level.getBlock(i, j).getMovable()){
				g.setColor(Color.BLUE);
				g.fillRect(i*20, j*20, 20, 20);
			}
		}
	}

	}
	public void keyPressed(KeyEvent arg0) {
		move = true;

		if(arg0.getKeyCode()==arg0.VK_DOWN){		
			level.moveDude(0, 1);
			repaint();
		}
		if(arg0.getKeyCode()==arg0.VK_UP){
			level.moveDude(0, -1);
			repaint();
		}
		if(arg0.getKeyCode()==arg0.VK_RIGHT){
			level.moveDude(1, 0);
			repaint();
		}
		if(arg0.getKeyCode()==arg0.VK_LEFT){
			level.moveDude(-1, 0);
			repaint();
		}

	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}

