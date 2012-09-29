package UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MsgBoxDemo extends JFrame {

	public MsgBoxDemo(){
		super("Complex Frame");
		Container main = getContentPane();
		JPanel top = new JPanel();
		top.add(new JLabel("Enter message: "));
		top.add(new JTextField(30));
		
		JPanel mid1 = new JPanel();
		mid1.add(new JScrollPane(new JTextArea(10, 50)));
		
		JPanel mid2 = new JPanel();
		mid2.setLayout(new GridLayout(3,1));
		mid2.add(new JLabel("Your nick"));
		JComboBox choice = new JComboBox();
		choice.addItem("Jan");
		choice.addItem("Franio");
		choice.addItem("Józio");
		mid2.add(choice);
		mid2.add(new JCheckBox("Active"));
		
		JPanel bot = new JPanel();
		bot.add(new JButton("Send"));
		bot.add(new JButton("Quit"));
		
		main.add(top, BorderLayout.NORTH);
		main.add(mid1, BorderLayout.CENTER);
		main.add(mid2, BorderLayout.EAST);
		main.add(bot, BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}
	
	public static void main (String[] args){
		MsgBoxDemo form = new MsgBoxDemo(); 
	}

}
