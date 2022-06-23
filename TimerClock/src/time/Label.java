package time;

import java.awt.Color; 
import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Label extends JLabel{
	
	public Label(String text, int fontSize) {
		
		this.setForeground(Color.white);
		this.setFont(new Font("Serif", Font.PLAIN, fontSize));
		this.setText(text);
	}
}