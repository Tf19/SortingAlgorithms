

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainWindow extends JFrame {
	
	private JPanel mainPanel = new JPanel(new FlowLayout());
	private JPanel sortButtonPanel = new JPanel(new FlowLayout());
	private JPanel numberPanel = new JPanel(new FlowLayout());
	
	private JLabel numberLabel = new JLabel("zu sortierende Zahlen:");
	private JTextField numberField = new JTextField("Zahlen mit Minus getrennt, z.B. 1-5-9-8-7", 30);
	private JCheckBox randomNumbers = new JCheckBox("stattdessen groﬂe Menge Zufallszahlen: ");
	private JTextField countField = new JTextField("8000", 5);
	
	private JButton minsortButton = new JButton("Minsort");
	private JButton bubblesortButton = new JButton("Bubblesort");
	private JButton quicksortButton = new JButton("Quicksort");
	
	
	public MainWindow() {
		super("Sortieralgorithmen (c) 2019 by Paul Boswank");
		setVisible(true);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		mainPanel.setPreferredSize(new Dimension(600, 400));
		//_____________________________________________
		
		numberPanel.setPreferredSize(new Dimension(500, 70));
		numberPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		mainPanel.add(numberPanel);
		
		sortButtonPanel.setPreferredSize(new Dimension(300, 50));
		sortButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		mainPanel.add(sortButtonPanel);
		
		numberPanel.add(numberLabel);
		numberPanel.add(numberField);
		numberPanel.add(randomNumbers);		
		numberPanel.add(countField);
		countField.setEditable(false);
		randomNumbers.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				e.getSource().
			}
		});
		
		
		sortButtonPanel.add(minsortButton);
		sortButtonPanel.add(bubblesortButton);
		sortButtonPanel.add(quicksortButton);
		
		add(mainPanel);
		pack();
	
	}

	private static void setRandomNumberField(boolean state) {
		
	}
}