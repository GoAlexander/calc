package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import javax.swing.JLayeredPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class BigGUI extends GUI {

	private JFrame frame;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BigGUI window = new BigGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BigGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.BOLD, 27));
		frame.getContentPane().add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		//panel.setLayout(new GridLayout(5, 4));
		
		GridLayout buttonLayout = new GridLayout(5, 4);
		
		panel.setLayout(buttonLayout);

		
		panel.add(new JButton("Undo"));
		panel.add(new JButton("Redo"));
		panel.add(new JButton("C"));
		panel.add(new JButton("%"));
		panel.add(new JButton("7"));
		panel.add(new JButton("8"));
		panel.add(new JButton("9"));
		panel.add(new JButton("*"));
		panel.add(new JButton("4"));
		panel.add(new JButton("5"));
		panel.add(new JButton("6"));
		panel.add(new JButton("-"));
		panel.add(new JButton("1"));
		panel.add(new JButton("2"));
		panel.add(new JButton("3"));
		panel.add(new JButton("+"));
		panel.add(new JButton("0"));
		panel.add(new JButton("/"));
		panel.add(new JButton("="));
		
		
		
	}
}
