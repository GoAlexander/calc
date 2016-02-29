package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
//import javax.swing.JTextField;

import exception.ErrorInBrackets;
import exprhistory.ExprHistory;
import fraction.Fraction;
import poland.Poland;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.EmptyStackException;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.GridLayout;

public class GUI {

	private JFrame frmFractionCalculator;

	private ExprHistory MyExprHistory = new ExprHistory();
	String str;
	Fraction result;

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
		frmFractionCalculator.setBounds(100, 100, 440, 140);
		frmFractionCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFractionCalculator.getContentPane().setLayout(new BorderLayout(0, 0));

		JTextField textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.BOLD, 30));
		frmFractionCalculator.getContentPane().add(textField, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		frmFractionCalculator.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2));

		JButton btnNewButton_3 = new JButton("Undo");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textField.setText(MyExprHistory.back().toString());
				} catch (EmptyStackException a) {
				}
			}
		});
		panel.add(btnNewButton_3);

		JButton btnNewButton = new JButton("Redo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textField.setText(MyExprHistory.forward().toString());
				} catch (EmptyStackException a) {
				}
			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("History");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				History MyHistory = new History();
				MyHistory.setVisible(true);

				// wait to cancel the window
				MyHistory.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						if (MyHistory.getSelectedExp() != null)
							textField.setText(MyHistory.getSelectedExp());
					}
				});
			}
		});
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("=");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str = textField.getText();
				MyExprHistory.newnumber(str);
				try {
					if (!str.equals("")) {
						result = Poland.calculate(str);
						textField.setText(result.getString());
					}
				} catch (ArithmeticException q) {
					JOptionPane.showMessageDialog(null, "Do not divide by zero!");
				} catch (ErrorInBrackets g) {
					JOptionPane.showMessageDialog(null, "Error in brackets!");
				} catch (EmptyStackException g) {
					JOptionPane.showMessageDialog(null, "Wrong format!");
				} catch (Exception s) {
					JOptionPane.showMessageDialog(null, "Error!");
				}
			}
		});
		panel.add(btnNewButton_2);
	}
}