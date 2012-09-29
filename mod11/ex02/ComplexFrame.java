package mod11.ex02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ComplexFrame extends Frame implements ActionListener{
	private Button quit = new Button("Quit");
	private Button send = new Button("Send");
	private TextField tf = new TextField(30);
	private TextArea ta = new TextArea();
	
	public ComplexFrame() {
		super("Complex Frame");
		// north
		Panel north = new Panel(new FlowLayout(FlowLayout.LEFT));
		north.add(new Label("Enter message: "));
		north.add(tf);
		tf.addActionListener(this);
		add(north, BorderLayout.NORTH);

		// center
		add(ta, BorderLayout.CENTER);

		// east
		Panel east = new Panel(new GridLayout(3, 1));
		east.add(new Label("Your nick"));
		Choice choice = new Choice();
		choice.add("Jan");
		choice.add("Jerzy");
		choice.add("Tadeusz");
		east.add(choice);
		east.add(new Checkbox("Active"));
		add(east, BorderLayout.EAST);

		// south
		Panel south = new Panel();
		south.add(send);
		send.addActionListener(this);
		south.add(quit);
		quit.addActionListener(this);
		add(south, BorderLayout.SOUTH);
		
		addWindowListener(new MyHandler2());
		pack();
		setVisible(true);
	}
	
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == quit){
			System.exit(0);
			} else {
				if(e.getSource() == send || e.getSource() == tf){
					String text = tf.getText();
					tf.setText("");
					ta.append(text+"\n");
				}
			}
		}
		
	class MyHandler2 extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new ComplexFrame();
	}
}
