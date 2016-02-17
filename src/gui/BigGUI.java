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
import java.util.EmptyStackException;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import exception.IllegalExpression;
import fraction.Fraction;
import poland.Poland;

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
import java.awt.Dimension;
import javax.swing.JSeparator;

public class BigGUI extends GUI {

	private JFrame frmFractionCalculator;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	
	String str;
	Fraction result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BigGUI window = new BigGUI();
					window.frmFractionCalculator.setVisible(true);
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
		frmFractionCalculator = new JFrame();
		frmFractionCalculator.setTitle("Fraction Calculator");
		frmFractionCalculator.setBounds(100, 100, 450, 300);
		frmFractionCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.BOLD, 30));
		frmFractionCalculator.getContentPane().add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		frmFractionCalculator.getContentPane().add(panel, BorderLayout.CENTER);
		//panel.setLayout(new GridLayout(5, 4));
		
		GridLayout buttonLayout = new GridLayout(5, 4);
		
		panel.setLayout(buttonLayout);

		
		panel.add(new JButton("Undo"));
		panel.add(new JButton("Redo"));
		JButton button_1 = new JButton("C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		panel.add(button_1);
		JButton button_2 = new JButton("/");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(button_2);
		JButton button_3 = new JButton("7");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(button_3);
		JButton button_4 = new JButton("8");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(button_4);
		JButton button_5 = new JButton("9");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(button_5);
		JButton button_6 = new JButton("*");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(button_6);
		JButton button_7 = new JButton("4");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(button_7);
		JButton button_8 = new JButton("5");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(button_8);
		JButton button_9 = new JButton("6");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(button_9);
		JButton button_10 = new JButton("-");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(button_10);
		JButton button_11 = new JButton("1");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(button_11);
		JButton button_12 = new JButton("2");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(button_12);
		JButton button_13 = new JButton("3");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(button_13);
		JButton button_14 = new JButton("+");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(button_14);
		JButton button_15 = new JButton("0");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(button_15);
		JButton button_16 = new JButton("history");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(button_16);
		JButton button = new JButton("=");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str = textField.getText();
				try {
					result = Poland.calculate(str);
					textField.setText(result.getString());
				} catch (ArithmeticException q) {
					textField.setText("Error! Do not divide by zero next time!");
				} catch (IllegalExpression a) {
					textField.setText("Wrong format!");
				} catch (EmptyStackException g) {
					textField.setText("Error in brackets!");
				} catch (Exception s) {
					textField.setText("Error!");
				}
			}
		});
		
		JSeparator separator = new JSeparator();
		panel.add(separator);
		panel.add(button);
		
		
		
	}
}
