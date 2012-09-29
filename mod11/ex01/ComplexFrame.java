package mod11.ex01;

import java.awt.*;

public class ComplexFrame extends Frame {

	public ComplexFrame() {
		super("Complex Frame");
		// north
		Panel north = new Panel(new FlowLayout(FlowLayout.LEFT));
		north.add(new Label("Enter message: "));
		north.add(new TextField(30));
		add(north, BorderLayout.NORTH);

		// center
		add(new TextArea(), BorderLayout.CENTER);

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
		south.add(new Button("Send"));
		south.add(new Button("Quit"));
		add(south, BorderLayout.SOUTH);

		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new ComplexFrame();
	}
}
