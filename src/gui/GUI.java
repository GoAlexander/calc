package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
//import java.awt.BorderLayout;
import javax.swing.JTextField;

import fraction.Fraction;
import poland.Poland;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import javax.swing.SwingConstants;

public class GUI {

	private JFrame frmFractionCalculator;
	private JTextField textField;
	
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
		frmFractionCalculator.setBounds(100, 100, 440, 142);
		frmFractionCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFractionCalculator.getContentPane().setLayout(null);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				str = textField.getText();
				result = Poland.calculate(str);
				textField.setText(result.getString());
				
			}
		});
		btnCalculate.setBounds(0, 61, 440, 53);
		frmFractionCalculator.getContentPane().add(btnCalculate);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		textField.setFont(new Font("Dialog", Font.BOLD, 20));
		textField.setBounds(0, 0, 450, 65);
		frmFractionCalculator.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
