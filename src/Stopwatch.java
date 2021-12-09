import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Stopwatch {
		
	JFrame frame = new JFrame();
	JLabel timeLabel = new JLabel();
	JLabel unitsLabel = new JLabel();
	JButton startButton = new JButton("START");
	JButton resetButton = new JButton("RESET");
	int elapsedTime = 0;
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	boolean started = false;
	String secondsString = String.format("%02d", seconds);
	String minutesString = String.format("%02d", minutes);
	String hoursString = String.format("%02d", hours);
		
	Timer timer = new Timer(1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			elapsedTime += 1000;
			hours = (elapsedTime/3600000);
			minutes = (elapsedTime/60000) % 60;
			seconds = (elapsedTime/1000) % 60;				
			secondsString = String.format("%02d", seconds);
			minutesString = String.format("%02d", minutes);
			hoursString = String.format("%02d", hours);
			timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
			
		}
			
	});
	
	Stopwatch() {
		
		unitsLabel.setText("   HOURS   MINUTES  SECONDS ");
		unitsLabel.setBounds(50,50,300,25);
		unitsLabel.setFont(new Font("Verdana", Font.BOLD, 17));
		unitsLabel.setBackground(Color.gray);
		unitsLabel.setForeground(Color.white);
		unitsLabel.setOpaque(true);
		unitsLabel.setHorizontalAlignment(JTextField.CENTER);
		
		timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
		timeLabel.setBounds(50,75,300,100);
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 60));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setBackground(Color.lightGray);
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		startButton.setBounds(50, 175, 150, 60);
		startButton.setFont(new Font("Verdana", Font.BOLD + Font.ITALIC, 30));
		startButton.setFocusable(false);
		startButton.setBackground(Color.darkGray);
		startButton.setForeground(Color.green);
		startButton.addActionListener(e -> {
			started = !started;
			if(started) {
				start();
				startButton.setText("STOP");
				startButton.setForeground(Color.red);
			}
			else {
				stop();
				startButton.setText("START");
				startButton.setForeground(Color.green);
			}
			
		});
		
		resetButton.setBounds(200, 175, 150, 60);
		resetButton.setFont(new Font("Verdana", Font.BOLD + Font.ITALIC, 30));
		resetButton.setFocusable(false);
		resetButton.setBackground(Color.darkGray);
		resetButton.setForeground(Color.white);
		resetButton.addActionListener(e -> {
			stop();
			reset();
			
			if(started) {
				start();
			}
		});

		frame.add(unitsLabel);
		frame.add(timeLabel);
		frame.add(startButton);
		frame.add(resetButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,350);
		frame.getContentPane().setBackground(Color.gray);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
		
	
	void start() {
		timer.start();
	}

	void stop() {
		timer.stop();
	}
	
	void reset() {
		elapsedTime = 0;
		seconds = 0;
		minutes = 0;
		hours = 0;
		secondsString = String.format("%02d", seconds);
		minutesString = String.format("%02d", minutes);
		hoursString = String.format("%02d", hours);
		timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
	}
	
	
}
