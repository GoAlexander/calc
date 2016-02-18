package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class History extends JFrame {
	
	public String selected_exp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					History frame = new History();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public History() {
		setTitle("History");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		
		
		//for test
		 String[] test = { "Chrome", "Firefox", "Internet Explorer", "Safari",
                 "Opera", "Morrowind", "Oblivion", "NFS", "Half Life 2",
                 "Hitman", "Morrowind", "Oblivion", "NFS", "Half Life 2",
                 "Hitman", "Morrowind", "Oblivion", "NFS", "Half Life 2",
                 "Hitman", "Morrowind", "Oblivion", "NFS", "Half Life 2",
                 "Hitman", "Morrowind", "Oblivion", "NFS", "Half Life 2",
                 "Hitman", "IL-2", "CMR", "NFS Undercover",
                 "Star Wars", "Call of Duty", "IL-2", "CMR",
                 "NFS Undercover", "Star Wars", "Call of Duty",
                 "IL-2", "CMR", "NFS Undercover", "Star Wars",
                 "Call of Duty", "IL-2", "CMR", "NFS Undercover",
                 "Star Wars", "Call of Duty", "IL-2", "CMR",
                 "NFS Undercover", "Star Wars", "Call of Duty",
                 "IL-2", "CMR", "NFS Undercover", "Star Wars",
                 "Call of Duty", "Arena", "Dagerfall", "MS Office",
                 "Open Office", "Windows", "Arena", "Dagerfall",
                 "MS Office", "Open Office", "Windows", "Arena",
                 "Dagerfall", "MS Office", "Open Office", "Windows",
                 "Arena", "Dagerfall", "MS Office", "Open Office",
                 "Windows", "Mac OS", "Ubuntu"
		 };
		JList list = new JList(test);
		getContentPane().add(list, BorderLayout.CENTER);
		list.setLayoutOrientation(JList.VERTICAL);
		
		JScrollPane scrollPane = new JScrollPane(list);

	    Container contentPane = this.getContentPane();
	    contentPane.add(scrollPane, BorderLayout.CENTER);
	    
	    
	    JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected_exp = list.getSelectedValue().toString(); //not so good idea (redo?)
				dispose(); //setVisibility(false)
			}
		});
		getContentPane().add(btnNewButton, BorderLayout.SOUTH);

	}
}
