import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GUI extends JPanel implements KeyListener{
	private Level level;
	private JFrame frame;
	private boolean move =false;
	private boolean first = true;
	private boolean endGame = false;
	public final int blockWidth;
	Timer close = new Timer(2000, new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});



	GUI(Level l){
		level = l;
		frame = new JFrame("Block Dude");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(820, 840);
		blockWidth = 800/l.width;
		frame.add(this);
		frame.setVisible(true);
		frame.addKeyListener(this);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(first){
			first = false;
			g.fillRect(level.getDudeX()*blockWidth,level.getDudeY()*blockWidth, blockWidth, blockWidth);
		}
		if(move){
			if(level.getLeft()){
				g.setColor(Color.CYAN);
			}
			else{
				g.setColor(Color.MAGENTA);
			}
			g.fillRect(level.getDudeX()*blockWidth,level.getDudeY()*blockWidth, blockWidth, blockWidth);

		}
		for(int i = 0;i<level.width;i++){
			for(int j = 0;j<level.height;j++){
				if(level.getBlock(i, j).getMovable()){
					java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
					g2.setStroke(new java.awt.BasicStroke(4)); // thickness of 3.0f
					g2.setColor(Color.BLACK);
					g2.drawRect(i*blockWidth+2, j*blockWidth+2, blockWidth-4, blockWidth-4);
				}
				if(level.getBlock(i, j).getFixed()){
					g.setColor(Color.BLACK);
					g.fillRect(i*blockWidth, j*blockWidth, (int) (blockWidth*.625), (int) (blockWidth*.25));
					g.fillRect(i*blockWidth, (int) (j*blockWidth + blockWidth *.75), (int) (blockWidth*.625), (int) (blockWidth*.25));
					g.fillRect(i*blockWidth, (int) (j*blockWidth + blockWidth *.375), (int) (blockWidth*.875), (int) (blockWidth*.25));
					g.fillRect((int) (i*blockWidth + blockWidth * .75), (j*blockWidth), (int) (blockWidth*.25), (int) (blockWidth*.25));
					g.fillRect((int) (i*blockWidth + blockWidth * .75), (int) (j*blockWidth + blockWidth * .75), (int) (blockWidth*.25), (int) (blockWidth*.25));
				}

				if(level.getBlock(i, j).getEnd()){
					g.drawRect(i*blockWidth, j*blockWidth, blockWidth/2 - 1, blockWidth);
					g.drawRect(i*blockWidth + blockWidth/2, j*blockWidth, blockWidth/2, blockWidth);
					g.fillOval((int) (i*blockWidth + blockWidth*.285),(int) (j*blockWidth + blockWidth*.428),(int) (blockWidth*.142) ,(int) (blockWidth*.142) );
					g.fillOval((int) (i*blockWidth + blockWidth*.571),(int) (j*blockWidth + blockWidth*.428),(int) (blockWidth*.142) ,(int) (blockWidth*.142) );
				}
			}
		}
		endGame = level.getEnd();
		if(endGame){
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 820,840);
			Font gameover = new Font ("TimesRoman", Font.BOLD, 40);
			g.setFont(gameover);
			g.setColor(Color.white);
			g.drawString("You Beat The Level", 230, 410);
			close.start();
		}
	}

	public void keyPressed(KeyEvent arg0) {
		move = true;
		if(arg0.getKeyCode()==arg0.VK_DOWN){
			if(level.getBlockHeld()){
				if(level.getLeft()){
					if(level.getBlock(level.getDudeX()-1, level.getDudeY()-1).getEmpty()){
						int x = -1;
						int y = 0;
						while(level.getBlock(level.getDudeX()-1, level.getDudeY()+y).getEmpty()){
							y++;
						}
						//System.out.println("x " + x + " y " + y);
						level.moveBlock(x, y, false);
					}
				}
				else{
					if(level.getBlock(level.getDudeX()+1, level.getDudeY()-1).getEmpty()){
						int x = 1;
						int y = 0;
						while(level.getBlock(level.getDudeX()+1, level.getDudeY()+y).getEmpty()){
							y++;
						}
						//System.out.println("x " + x + " y " + y);
						level.moveBlock(x, y, false);
					}
				}
			}
			else{
				if(level.getLeft()){
					if(level.getBlock(level.getDudeX()-1, level.getDudeY()).getMovable() && level.getBlock(level.getDudeX()-1, level.getDudeY()-1).getEmpty()){
						level.moveBlock(1, -1, true);
					}
				}
				else{
					if(level.getBlock(level.getDudeX()+1, level.getDudeY()).getMovable() && level.getBlock(level.getDudeX()+1, level.getDudeY()-1).getEmpty()){
						level.moveBlock(-1, -1, true);
					}
				}
			}

			repaint();
		}
		if(arg0.getKeyCode()==arg0.VK_UP){
			if(level.getLeft()){
				if(!level.getBlock(level.getDudeX()-1, level.getDudeY()).getEmpty()){
					if(level.getBlockHeld()){
						if(level.getBlock(level.getDudeX(), level.getDudeY()-2).getEmpty()){
							level.moveDude(-1, -1);
						}
					}else{
						level.moveDude(-1, -1);
					}

				}
			}
			else{
				if(!level.getBlock(level.getDudeX()+1, level.getDudeY()).getEmpty()){
					if(level.getBlockHeld()){
						if(level.getBlock(level.getDudeX(), level.getDudeY()-2).getEmpty()){
							level.moveDude(+1, -1);
						}
					}else{
						level.moveDude(+1, -1);
					}

				}
			}

			repaint();
		}
		if(arg0.getKeyCode()==arg0.VK_RIGHT){
			level.setLeft(false);
			level.moveDude(1, 0);
			while(level.getBlock(level.getDudeX(), level.getDudeY()+1).getEmpty()){
				level.moveDude(0, 1);
			}
			repaint();
		}
		if(arg0.getKeyCode()==arg0.VK_LEFT){
			level.setLeft(true);
			level.moveDude(-1, 0);
			while(level.getBlock(level.getDudeX(), level.getDudeY()+1).getEmpty()){
				level.moveDude(0, 1);
			}
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

