package time;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TextInput extends JTextField{
	
	public TextInput() {
		
		TextPrompt t = new TextPrompt("Insert seconds", this);
		t.changeAlpha(120);
		t.setHorizontalAlignment((int) CENTER_ALIGNMENT);
	}
}
