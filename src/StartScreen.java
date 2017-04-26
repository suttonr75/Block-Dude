
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class StartScreen implements ActionListener  {
	private JFrame frame;
	private JPanel panel;

	StartScreen(){
		frame = new JFrame("Block Dude");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,300);
		frame.setVisible(true);
		panel = new JPanel();
		frame.add(panel);
		panel.setLayout(new BorderLayout());
		JPanel inner = new JPanel();
		inner.setLayout(new GridLayout(1,3));
		panel.add(inner, BorderLayout.PAGE_END);
		JButton play = new JButton("play");
		play.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				
			} 
		} );
		JTextField password = new JTextField();

		JLabel enter = new JLabel("ENTER LEVEL PASSWORD");
		BufferedImage img = new BufferedImage(50,50,BufferedImage.TYPE_3BYTE_BGR);
		File a;
		try{
			a = new File("blockdude.jpeg");
		    img = ImageIO.read(a);
		}catch(Exception e){
			
		}

		ImageIcon bDude = new ImageIcon(img);

		inner.add(enter);
		inner.add(password);
		inner.add(play);
		JLabel pic = new JLabel();
		pic.setIcon(bDude);
		frame.pack();
		

	}
	public static void main(String[] args){
		StartScreen start = new StartScreen();
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}