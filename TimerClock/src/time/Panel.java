package time;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel extends JPanel{
	
	public Panel(int height, int tint) {
		
		this.setBackground(new Color(0, tint, 255));
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(400, height));
	}
}