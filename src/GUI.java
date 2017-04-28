import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GUI extends JPanel implements KeyListener{
	private boolean[][] dudeDraw = new boolean[8][8];
	private Level level;
	private JFrame frame;
	private boolean move =false;
	private boolean first = true;
	private boolean endGame = false;
	public final int blockWidth;
	private ArrayList<Level> levels = new ArrayList<Level>();
	Timer close = new Timer(3000, new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
	Timer nextLev = new Timer(3000, new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			nextLev.stop();
			frame.dispose();
			GUI a = new GUI(levels, level.getLevelNum() + 1);
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
		setDudeRight();
	}
	
	GUI(ArrayList<Level> levs, int index){
		levels = levs;
		level = levels.get(index);
		frame = new JFrame("Block Dude");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(820, 840);
		blockWidth = 800/levels.get(index).width;
		frame.add(this);
		frame.setVisible(true);
		frame.addKeyListener(this);
		setDudeRight();
	}

	private void setDudeRight() {
		for(int i = 0; i < dudeDraw.length; i ++){
			for(int j = 0; j < dudeDraw[0].length; j++){
				dudeDraw[i][j] = false;
			}
		}
		dudeDraw[2][0]=true;
		dudeDraw[3][0]=true;
		dudeDraw[4][0]=true;
		
		dudeDraw[1][1]=true;
		dudeDraw[2][1]=true;
		dudeDraw[3][1]=true;
		dudeDraw[4][1]=true;
		dudeDraw[5][1]=true;
		dudeDraw[6][1]=true;
		
		dudeDraw[1][2]=true;
		dudeDraw[4][2]=true;
		
		dudeDraw[1][3]=true;
		dudeDraw[5][3]=true;
		
		dudeDraw[2][4]=true;
		dudeDraw[4][4]=true;
		
		dudeDraw[1][5]=true;
		dudeDraw[3][5]=true;
		dudeDraw[5][5]=true;
		
		dudeDraw[3][6]=true;
		
		dudeDraw[1][7]=true;
		dudeDraw[2][7]=true;
		dudeDraw[4][7]=true;
		dudeDraw[5][7]=true;
		
	}
	
	private void setDudeLeft() {
		for(int i = 0; i < dudeDraw.length; i ++){
			for(int j = 0; j < dudeDraw[0].length; j++){
				dudeDraw[i][j] = false;
			}
		}
		dudeDraw[3][0]=true;
		dudeDraw[4][0]=true;
		dudeDraw[5][0]=true;
		
		dudeDraw[1][1]=true;
		dudeDraw[2][1]=true;
		dudeDraw[3][1]=true;
		dudeDraw[4][1]=true;
		dudeDraw[5][1]=true;
		dudeDraw[6][1]=true;
		
		dudeDraw[3][2]=true;
		dudeDraw[6][2]=true;
		
		dudeDraw[2][3]=true;
		dudeDraw[6][3]=true;
		
		dudeDraw[3][4]=true;
		dudeDraw[5][4]=true;
		
		dudeDraw[2][5]=true;
		dudeDraw[4][5]=true;
		dudeDraw[6][5]=true;
		
		dudeDraw[4][6]=true;
		
		dudeDraw[2][7]=true;
		dudeDraw[3][7]=true;
		dudeDraw[5][7]=true;
		dudeDraw[6][7]=true;
		
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black);
		if(level.getLeft()){
			setDudeLeft();
		}else{
			setDudeRight();
		}
		if(first){
			first = false;
			for(int x = 0;x<dudeDraw.length;x++){
				for(int y = 0;y<dudeDraw[0].length;y++){
					if(dudeDraw[x][y]){
						g.fillRect((int) (level.getDudeX()*blockWidth+ blockWidth*x*.125), (int) (level.getDudeY()*blockWidth+ blockWidth*y*.125), (int) (blockWidth*.125), (int) (blockWidth*(.125)));
					}
				}
			}
		}
		if(move){

			for(int x = 0;x<dudeDraw.length;x++){
				for(int y = 0;y<dudeDraw[0].length;y++){
					System.out.println(dudeDraw[x][y]);
					if(dudeDraw[x][y]){
						//System.out.println(level.getDudeX()+"  "+level.getDudeY());
						g.fillRect((int) (level.getDudeX()*blockWidth+ blockWidth*x*.125), (int) (level.getDudeY()*blockWidth+ blockWidth*y*.125), (int) (blockWidth*.125), (int) (blockWidth*(.125)));
					}
				}
			}
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
			if(level.getLevelNum() == 8){
				g.drawString("You Beat The Game", 230, 310);
			}else{
				g.drawString("You Beat The Level", 230, 310);
			}
			g.setColor(Color.white);
			g.drawString("Password: " + level.getPassword(), 230, 510);
			if(level.getLevelNum() == levels.size()-1){
				close.start();
			}else{
				nextLev.start();
			}

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

