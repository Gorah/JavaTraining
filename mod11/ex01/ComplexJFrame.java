package mod11.ex01;

import java.awt.*;
import javax.swing.*;

public class ComplexJFrame extends JFrame {

	public ComplexJFrame() {
		super("Complex Frame");
		// north
		JPanel north = new JPanel(new FlowLayout(FlowLayout.LEFT));
		north.add(new JLabel("Enter message: "));
		north.add(new JTextField(30));
		getContentPane().add(north, BorderLayout.NORTH);

		// center
		getContentPane().add(new JScrollPane(new JTextArea()),
				BorderLayout.CENTER);

		// east
		JPanel east = new JPanel(new GridLayout(3, 1));
		east.add(new JLabel("Your nick"));
		JComboBox combo = new JComboBox();
		combo.addItem("Jan");
		combo.addItem("Jerzy");
		combo.addItem("Tadeusz");
		east.add(combo);
		east.add(new JCheckBox("Active"));
		getContentPane().add(east, BorderLayout.EAST);

		// south
		JPanel south = new JPanel();
		south.add(new JButton("Send"));
		south.add(new JButton("Quit"));
		getContentPane().add(south, BorderLayout.SOUTH);

		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new ComplexJFrame();
	}
}
