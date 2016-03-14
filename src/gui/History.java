package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

import exprhistory.ExprHistory;

import javax.swing.JScrollPane;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
class History extends JDialog {

	private String selected_exp;
	//private ExprHistory MyExprHistory = new ExprHistory();

	/**
	 * Create the frame.
	 * @param myExprHistory2 
	 */
	public History(ExprHistory MyExprHistory) {
		setTitle("History");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JList<String> list = new JList<String>(MyExprHistory.getHistory());
		getContentPane().add(list, BorderLayout.CENTER);
		list.setLayoutOrientation(JList.VERTICAL);

		JScrollPane scrollPane = new JScrollPane(list);

		Container contentPane = this.getContentPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected_exp = list.getSelectedValue().toString();

				dispose(); // cancel the window
			}
		});
		getContentPane().add(btnNewButton, BorderLayout.SOUTH);

	}

	public String getSelectedExp() {
		return selected_exp;
	}
}
