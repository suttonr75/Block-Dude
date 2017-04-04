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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	Level lev;

	public CreateLevel(int width, int height) {
		lev = new Level(width,height);
		frame.add(this);
		frame.setSize(900,840);
		frame.setVisible(true);

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
