package time;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frame extends JFrame{
	
	private ImageIcon icon;
	
	public Frame(int width, int height) {
		
		this.icon = new ImageIcon(getClass().getResource("/icons/clock.png"));
		
		this.setTitle("Timer");
		this.setSize(width, height);
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		this.setResizable(false);
		this.setIconImage(this.icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}