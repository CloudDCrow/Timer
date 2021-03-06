package time;
 
import java.awt.Color;
import java.awt.GridLayout;   
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class TimerClock{
	
	private final static int SCREEN_WIDTH = 400;
	private final static int SCREEN_HEIGHT = 300;

	public static void main(String[] args) {
		
		LocalTime currentTime = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);

		Long count = (long) 0;
		
		//Frame
////////////////////////////////////////////////////////////////////
		Frame frame = new Frame(SCREEN_WIDTH, SCREEN_HEIGHT);
		
		//Panels
////////////////////////////////////////////////////////////////////
		//Panel for the Clock
		Panel topPanel = new Panel(50, 135);
		//Center Panel
		Panel countdownPanel = new Panel(150, 165);
		//Bottom three Panels
		Panel inputPanel1 = new Panel(30, 195);
		Panel inputPanel2 = new Panel(30, 195);
		Panel inputPanel3 = new Panel(30, 195);
		//Panels for the two buttons
		Panel buttonsPanel = new Panel(70, 225);
		
		inputPanel1.setLayout(new GridLayout());
		buttonsPanel.setLayout(new GridLayout());
		
		//Labels
////////////////////////////////////////////////////////////////////
		Label clock = new Label(currentTime.toString(), 20);			
		Label countdown = new Label("0", 50);
		
		countdown.setHorizontalAlignment(JLabel.CENTER);
		
		//TextBoxes
////////////////////////////////////////////////////////////////////
		TextInput text = new TextInput();
		
		text.setHorizontalAlignment(JTextField.CENTER);
		
		//Buttons
////////////////////////////////////////////////////////////////////
		Button startButton = new Button("Start", text);
		Button stopButton = new Button("Stop", text);
		Button nggupButton = new Button("???", text);
		
		nggupButton.setBackground(Color.DARK_GRAY);
		nggupButton.setForeground(Color.WHITE);
		
		//Adding components
////////////////////////////////////////////////////////////////////
		frame.add(topPanel);
		frame.add(countdownPanel);
		frame.add(inputPanel1);
		frame.add(buttonsPanel);

		topPanel.add(clock);
		countdownPanel.add(countdown);
		inputPanel1.add(inputPanel2);
		inputPanel1.add(text);
		inputPanel1.add(inputPanel3);
		inputPanel2.add(nggupButton);

		buttonsPanel.add(startButton);
		buttonsPanel.add(stopButton);
		
		frame.setVisible(true);
		frame.pack();

		//Logic
////////////////////////////////////////////////////////////////////
		while(true) {
			updateTime(currentTime, clock);
			if(startButton.getTime() != 0) {
				if(!stopButton.isStoped()) {
					count = (startButton.getTime() - System.currentTimeMillis());
				}
				
				if(stopButton.isStoped()) {
					startButton.setTime(count + System.currentTimeMillis());
				}
				
				if(count > 0) {
					countdown.setText(converter(count));
				}
				
				//Once the count reaches 0, this breaks it out of the if statement
				if(count <= 0) {
					countdown.setText("0");
					count = (long) 0;
					@SuppressWarnings("unused")
					MusicPlayer music =	new MusicPlayer("hey.wav");	
					startButton.setTime((long) 0);
				}				
			}
			
			//If you don't click the start button, the stop button is always "Stop"
			if(count <= 0) {
				stopButton.setText("Stop");
				stopButton.setStoped(false);
			}
		}
	}
////////////////////////////////////////////////////////////////////

	//Updates the Clock on the screen
	public static void updateTime(LocalTime time, Label label) {
		 time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
		 label.setText(time.toString());
	}
	
	public static String converter(Long number) {
		number = (number / 1000) + 1;
		return number + "";
	}
}
