import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ViewTs extends JFrame implements Observer {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton up = new JButton(" up ");
	JButton down = new JButton("down");
	JTextField textfield = new JTextField("set temperature here", 14);
	JLabel label = new JLabel("Temperature set appears here");
	
	ModelTs m;
	ControllerTs c;
	
	public ViewTs(ModelTs m, ControllerTs c) {
		
		this.m = m;
		this.c = c;

		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setLayout(new FlowLayout());
		panel.add(up);
		panel.add(down);
		panel.add(textfield);
		panel.add(label);
		
		m.registerObserver(this);
		
		registerListener();
				
		this.setContentPane(panel);
		this.setVisible(true);
		
		
	}

	private void registerListener() {
		textfield.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				c.setValue();
			}});
		up.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				c.upValue();
			}});
		down.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				c.downValue();
			}});
	}

	@Override
	public void update() {
		label.setText(String.valueOf(m.getTemperature()));
	}

	public String getEntry() {
		return textfield.getText();
	}

	public void displayError(String errorMessage) {
		textfield.setText(errorMessage);
	}
}
