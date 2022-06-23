package time;

import java.awt.Color;   
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Button extends JButton implements ActionListener{
	
	private TextInput textBox;
	private Long time;
	private boolean stop;
	@SuppressWarnings("unused")
	private MusicPlayer music;
	
	public Button(String text, TextInput inputField) {
		
		this.textBox = inputField;
		this.time = (long) 0;
		this.stop = false;
		
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.TOP);
		this.addActionListener(this);

		this.setFont(new Font("Verdana", Font.PLAIN, 15));
		this.setForeground(Color.DARK_GRAY);
		this.setFocusable(false);
		this.setBackground(new Color(0,225,255));
		this.setText(text);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this && this.getText().equals("Start")) {			
			if(!textBox.getText().equals("")) {
				this.time = System.currentTimeMillis() - (Long.valueOf(textBox.getText()) * -1000);
			}			
			textBox.setText("");
		}
				
		if(e.getSource() == this && this.getText().equals("Resume")) {
			this.stop = false;
			this.setText("Stop");
		} else if(e.getSource() == this && this.getText().equals("Stop")) {
			this.setTime(getTime());
			if(getTime() == 0) {
				this.stop = true;
				this.setText("Resume");
			}
		}	

		//???
///////////////////////////////////////////////////////////////////////////777
		if(e.getSource() == this && this.getText().equals("???")) {
			this.music = new MusicPlayer("nggup.wav");
			this.setText("");
			this.setBackground(new Color(255,182,193));
			this.setIcon(new ImageIcon(getClass().getResource("/icons/nggup.png")));
		}
	}
///////////////////////////////////////////////////////////////////////////777

	
	public Long getTime() {
		return this.time;
	}
	
	public void setTime(Long t) {
		this.time = t;
	}
	
	public boolean isStoped() {
		return this.stop;
	}
	
	public void setStoped(boolean stop) {
		this.stop = stop;
	}
}