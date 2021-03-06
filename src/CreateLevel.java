import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class CreateLevel extends JPanel implements MouseListener, ActionListener{
	JFrame frame = new JFrame();
	JFrame frame2;
	JButton fixed = new JButton();
	JButton movable = new JButton();
	JButton dude = new JButton();
	JButton end = new JButton();
	JButton done = new JButton();
	JButton erase = new JButton();
	JPanel pan = new JPanel();
	JPanel pan2 = new JPanel();
	private boolean fixedClick = false;
	private boolean moveClick = false;
	private boolean dudeClick = false;
	private boolean endClick = false;
	private boolean eraseClick = false;
	Level lev;
	private final int w;
	private final int h;
	
	public static void main(String[] args){
		CreateLevel a = new CreateLevel(25,25);
	}

	public CreateLevel(int width, int height) {
		w = width;
		h = height;
		lev = new Level(width,height);
		frame = new JFrame();
		frame2 = new JFrame();
		frame2.setLocation(width * 30 + 70, 0);
		frame2.setSize(140, height*30);
		frame.setSize(width * 30 + 30, height * 30);
		pan.setSize(width * 30, height * 30);
		pan2.setSize(140, height*30);
		frame.setVisible(true);
		frame.add(pan);
		frame2.setVisible(true);
		frame2.add(pan2);
		pan.setLayout(new GridLayout(width,height));
		pan2.setLayout(new GridLayout(6,1));
		dude = new JButton("Dude Click");
		dude.setPreferredSize(new Dimension(140,height*30/6));
		dude.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dudeClick = !dudeClick;
				endClick = false;
				moveClick = false;
				fixedClick = false;
				eraseClick = false;
			}
		});
		end = new JButton("End Click");
		end.setPreferredSize(new Dimension(140,height*30/6));
		end.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				endClick = !endClick;
				dudeClick = false;
				moveClick = false;
				fixedClick = false;
				eraseClick = false;
			}
		});
		fixed = new JButton("Fixed Click");
		fixed.setPreferredSize(new Dimension(140,height*30/6));
		fixed.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fixedClick = !fixedClick;
				endClick = false;
				moveClick = false;
				dudeClick = false;
				eraseClick = false;
			}
		});
		movable = new JButton("Moveable Click");
		movable.setPreferredSize(new Dimension(140,height*30/6));
		movable.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				moveClick = !moveClick;
				endClick = false;
				dudeClick = false;
				fixedClick = false;
				eraseClick = false;
			}
		});
		erase = new JButton("Erase Click");
		erase.setPreferredSize(new Dimension(140,height*30/6));
		erase.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				eraseClick = !eraseClick;
				endClick = false;
				dudeClick = false;
				fixedClick = false;
				moveClick = false;
			}
		});
		done = new JButton("Done");
		done.setPreferredSize(new Dimension(140,height*30/6));
		done.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Block[][] board = new Block[w][h];
				for(int i = 0; i < w; i++){
					for(int j = 0; j < h; j++){
						board[i][j] = new Block();
						JButton but = (JButton)pan.getComponent(j*h + i);
						if(but.getBackground().equals(Color.BLACK)){
							board[i][j].setFixed(true);
							System.out.println("board["+i+"]["+j+"].setFixed(true);");
						}
						if(but.getBackground().equals(Color.RED)){
							board[i][j].setDude(true);
							System.out.println("board["+i+"]["+j+"].setDude(true);");
						}
						if(but.getBackground().equals(Color.YELLOW)){
							board[i][j].setEnd(true);
							System.out.println("board["+i+"]["+j+"].setEnd(true);");
						}
						if(but.getBackground().equals(Color.WHITE)){
							board[i][j].setEmpty(true);
							System.out.println("board["+i+"]["+j+"].setEmpty(true);");
						}
						if(but.getBackground().equals(Color.GRAY)){
							board[i][j].setMovable(true);
							System.out.println("board["+i+"]["+j+"].setMovable(true);");
						}
					}
				}
				lev.importCreatedLevel(board);
				frame.dispose();
				frame2.dispose();
				
			}
		});
		pan2.add(dude);
		pan2.add(fixed);
		pan2.add(movable);
		pan2.add(end);
		pan2.add(erase);
		pan2.add(done);
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				JButton button = new JButton();
				button.setPreferredSize(new Dimension(30,30));
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
							button.setMargin(new Insets(5, 5, 5, 5) );
							button.setText("E");
						}
						if(eraseClick){
							JButton button = (JButton)e.getSource();
							button.setBackground(Color.WHITE);
							button.setText("");
						}
						if(dudeClick){
							JButton button = (JButton)e.getSource();
							button.setBackground(Color.RED);
							button.setMargin(new Insets(5, 5, 5, 5) );
							button.setText("D");
						}
					}
				});
				pan.add(button);
			}
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addMouseListener(this);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame2.pack();
	}
	public void mouseClicked(MouseEvent a) {
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent a) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	public void actionPerformed(ActionEvent arg0) {	
	}

































}
