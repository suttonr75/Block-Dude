import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;


public class CreateLevel extends JPanel implements MouseListener, ActionListener{
	
	JFrame frame = new JFrame();
	JButton fixed = new JButton();
	JButton movable = new JButton();
	JButton dude = new JButton();
	JButton end = new JButton();
	JButton done = new JButton();
	JPanel pan = new JPanel();
	JPanel pan2 = new JPanel();
	private boolean fixedClick = false;
	private boolean moveClick = false;
	private boolean dudeClick = false;
	private boolean endClick = false;
	Level lev;
	private final int w;
	private final int h;
	
	public static void main(String[] args){
		CreateLevel a = new CreateLevel(10,10);
	}

	public CreateLevel(int width, int height) {
		w = width;
		h = height;
		lev = new Level(width,height);
		frame = new JFrame();
		frame.setSize(width * 30 + 30, height * 30);
		pan.setSize(width * 30, height * 30);
		pan2.setSize(30, height*30);
		frame.setLayout(new GridLayout(1,2));
		frame.setVisible(true);
		frame.add(pan);
		frame.add(pan2);
		pan.setLayout(new GridLayout(width,height));
		pan2.setLayout(new GridLayout(5,1));
		dude = new JButton("Dude Click");
		dude.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dudeClick = !dudeClick;
				endClick = false;
				moveClick = false;
				fixedClick = false;
			}
		});
		end = new JButton("End Click");
		end.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				endClick = !endClick;
				dudeClick = false;
				moveClick = false;
				fixedClick = false;
			}
		});
		fixed = new JButton("Fixed Click");
		fixed.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fixedClick = !fixedClick;
				endClick = false;
				moveClick = false;
				dudeClick = false;
			}
		});
		movable = new JButton("Moveable Click");
		movable.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				moveClick = !moveClick;
				endClick = false;
				dudeClick = false;
				fixedClick = false;
			}
		});
		done = new JButton("Done");
		done.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Block[][] board = new Block[w][h];
				for(int i = 0; i < w; i++){
					for(int j = 0; j < h; j++){
						board[i][j] = new Block();
						JButton but = (JButton)pan.getComponent(j*h + i);
						if(but.getBackground().equals(Color.BLACK)){
							board[i][j].setFixed(true);
						}
						if(but.getBackground().equals(Color.RED)){
							board[i][j].setDude(true);
						}
						if(but.getBackground().equals(Color.YELLOW)){
							board[i][j].setEnd(true);
						}
						if(but.getBackground().equals(Color.WHITE)){
							board[i][j].setEmpty(true);
						}
						if(but.getBackground().equals(Color.GRAY)){
							board[i][j].setMovable(true);
						}
					}
				}
				lev.importCreatedLevel(board);
				
			}
		});
		pan2.add(dude);
		pan2.add(fixed);
		pan2.add(movable);
		pan2.add(end);
		pan2.add(done);
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				JButton button = new JButton();
				button.setBackground(Color.WHITE);
				button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if(fixedClick){
							JButton button = (JButton)e.getSource();
							button.setBackground(Color.BLACK);
						}
						if(moveClick){
							JButton button = (JButton)e.getSource();
							button.setBackground(Color.GRAY);
						}
						if(endClick){
							JButton button = (JButton)e.getSource();
							button.setBackground(Color.YELLOW);
							button.setText("END");
						}
						if(dudeClick){
							JButton button = (JButton)e.getSource();
							button.setBackground(Color.RED);
							button.setText("DUDE");
						}
					}
				});
				pan.add(button);
			}
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addMouseListener(this);
	}
	public void mouseClicked(MouseEvent a) {
		

	}


	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}






	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}






	public void mousePressed(MouseEvent a) {


	}






	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

































}
