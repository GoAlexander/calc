package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import exception.ErrorInBrackets;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JPanel;
//import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.EmptyStackException;
import java.awt.event.ActionEvent;

import exprhistory.ExprHistory;
import fraction.Fraction;
import poland.Poland;
import java.awt.GridBagLayout;

public class BigGUI extends GUI {

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
		frmFractionCalculator.setBounds(100, 100, 450, 350);
		frmFractionCalculator.setResizable(false);
		frmFractionCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTextField textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.BOLD, 30));
		frmFractionCalculator.getContentPane().add(textField, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		frmFractionCalculator.getContentPane().add(panel, BorderLayout.CENTER);
		JButton button;
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		GridBagLayout gridbag = new GridBagLayout();
		panel.setLayout(gridbag);

		// natural height, maximum width
		c.fill = GridBagConstraints.HORIZONTAL;

		button = new JButton("Undo");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textField.setText(MyExprHistory.back().toString());
				} catch (EmptyStackException a) {
				}
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		gridbag.setConstraints(button, c);
		panel.add(button);

		button = new JButton("Redo");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textField.setText(MyExprHistory.forward().toString());
				} catch (EmptyStackException a) {
				}
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 0;
		gridbag.setConstraints(button, c);
		panel.add(button);

		button = new JButton("C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 2;
		c.gridy = 0;
		gridbag.setConstraints(button, c);
		panel.add(button);

		button = new JButton("/");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "/");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 3;
		c.gridy = 0;
		gridbag.setConstraints(button, c);
		panel.add(button);

		button = new JButton("7");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "7");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 1;
		gridbag.setConstraints(button, c);
		panel.add(button);

		button = new JButton("8");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "8");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 1;
		gridbag.setConstraints(button, c);
		panel.add(button);

		button = new JButton("9");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "9");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 2;
		c.gridy = 1;
		gridbag.setConstraints(button, c);
		panel.add(button);

		button = new JButton("*");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "*");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 3;
		c.gridy = 1;
		gridbag.setConstraints(button, c);
		panel.add(button);

		button = new JButton("4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "4");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 2;
		gridbag.setConstraints(button, c);
		panel.add(button);

		button = new JButton("5");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "5");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 2;
		gridbag.setConstraints(button, c);
		panel.add(button);

		button = new JButton("6");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "6");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 2;
		c.gridy = 2;
		gridbag.setConstraints(button, c);
		panel.add(button);

		button = new JButton("-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "-");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 3;
		c.gridy = 2;
		gridbag.setConstraints(button, c);
		panel.add(button);

		button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "1");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 3;
		gridbag.setConstraints(button, c);
		panel.add(button);

		button = new JButton("2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "2");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 3;
		gridbag.setConstraints(button, c);
		panel.add(button);

		button = new JButton("3");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "3");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 2;
		c.gridy = 3;
		gridbag.setConstraints(button, c);
		panel.add(button);

		button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "+");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 3;
		c.gridy = 3;
		gridbag.setConstraints(button, c);
		panel.add(button);

		button = new JButton("0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "0");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 4;
		gridbag.setConstraints(button, c);
		panel.add(button);

		button = new JButton("(");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "(");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 4;
		gridbag.setConstraints(button, c);
		panel.add(button);

		button = new JButton(")");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + ")");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 2;
		c.gridy = 4;
		gridbag.setConstraints(button, c);
		panel.add(button);

		button = new JButton("History");
		button.addActionListener(new ActionListener() {
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
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 3;
		c.gridy = 4;
		gridbag.setConstraints(button, c);
		panel.add(button);

		button = new JButton("=");
		button.addActionListener(new ActionListener() {
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
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridwidth = 4;
		c.gridy = 5;
		gridbag.setConstraints(button, c);
		panel.add(button);
	}
}
