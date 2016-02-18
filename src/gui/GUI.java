package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import emulator.Emulator;
import exception.*;
import fraction.Fraction;
import poland.Poland;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class GUI {

	private JFrame frmFractionCalculator;

	Emulator myEmulator = new Emulator();
	String str;
	Fraction result;
	private JTextField textField;
	private History history = new History();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFractionCalculator = new JFrame();
		frmFractionCalculator.setTitle("Fraction Calculator");
		frmFractionCalculator.setResizable(false);
		frmFractionCalculator.setBounds(100, 100, 440, 142);
		frmFractionCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFractionCalculator.getContentPane().setLayout(new BorderLayout(0, 0));

		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.BOLD, 30));
		frmFractionCalculator.getContentPane().add(textField, BorderLayout.NORTH);
		textField.setColumns(10);

		JPanel panel = new JPanel();
		frmFractionCalculator.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2));

		JButton btnNewButton_3 = new JButton("Undo");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textField.setText(myEmulator.back().toString());
				} catch (EmptyStackException a) {
				}
			}
		});
		panel.add(btnNewButton_3);

		JButton btnNewButton = new JButton("Redo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textField.setText(myEmulator.forward().toString());
				} catch (EmptyStackException a) {
				}
			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("History");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				history.setVisible(true);
				// wait???
				// textField.setText(history.selected_exp);

			}
		});
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("=");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str = textField.getText();
				try {
					if (!str.equals("")) {
						result = Poland.calculate(str);
						textField.setText(result.getString());
						myEmulator.newnumber(str);
					}
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
		panel.add(btnNewButton_2);
	}
}