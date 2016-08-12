package com.rmit;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.Box;
import java.awt.Cursor;
import javax.swing.SwingConstants;

@SuppressWarnings("unused")
public class UVoteUI {

	public JFrame frame;
	private final JLabel logoImg =  new JLabel("");
	private static JTextField inpVoter1;
	private static JTextField inpVoter2;
	private static JTextField inpVoter3;
	private static JTextField inpVoter4;
	private static JTextField inpVoter5;
	private static JTextField inpVoter6;
	private static JTextField inpVoter7;
	private static JTextField inpVoter8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					UVoteUI window = new UVoteUI();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public UVoteUI() throws IOException 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 299, 615);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		logoImg.setBounds(0, 0, 512, 79);
		frame.getContentPane().add(logoImg);
		logoImg.setIcon(new ImageIcon(ImageIO.read(UVoteUI.class.getResource("/images/logoIMG.jpg"))));
		
		Label lblVoterName1 = new Label("Pawar, Neha");
		lblVoterName1.setBounds(89, 177, 190, 22);
		frame.getContentPane().add(lblVoterName1);
		
		Label lblVoterName2 = new Label("Jayakumar, Chris Theodore");
		lblVoterName2.setBounds(89, 220, 190, 22);
		frame.getContentPane().add(lblVoterName2);
		
		Label lblVoterName3 = new Label("Gaikwad, Purwa Kishor");
		lblVoterName3.setBounds(89, 260, 190, 22);
		frame.getContentPane().add(lblVoterName3);
		
		Label lblVoterName4 = new Label("Tilve, Eashan");
		lblVoterName4.setBounds(89, 303, 190, 22);
		frame.getContentPane().add(lblVoterName4);
		
		Label lblVoterName5 = new Label("Saldanha, Carol Benita");
		lblVoterName5.setBounds(89, 345, 190, 22);
		frame.getContentPane().add(lblVoterName5);
		
		Label lblVoterName6 = new Label("Doe, John");
		lblVoterName6.setBounds(89, 384, 190, 22);
		frame.getContentPane().add(lblVoterName6);
		
		Label lblVoterName7 = new Label("Woodruff, Granger");
		lblVoterName7.setBounds(89, 427, 190, 22);
		frame.getContentPane().add(lblVoterName7);
		
		Label lblVoterName8 = new Label("Wang, Ruishen");
		lblVoterName8.setBounds(89, 473, 190, 22);
		frame.getContentPane().add(lblVoterName8);
		
		JLabel lblTitle = new JLabel("<html>State<br /><b>Electoral Division of Division Name</b></html>");
		lblTitle.setBounds(10, 83, 258, 28);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblConstraint = new JLabel("<html><b>Number the boxes from 1 to 8 in</b>"
											+ "<br /><b>the order of your choice</b></html>");
		lblConstraint.setBounds(10, 122, 273, 35);
		frame.getContentPane().add(lblConstraint);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 547, 263, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(10, 122, 258, 2);
		frame.getContentPane().add(separator_1);
		
		inpVoter1 = new JTextField();
		inpVoter1.setBounds(50, 177, 24, 22);
		frame.getContentPane().add(inpVoter1);
		inpVoter1.setColumns(10);
		Util.formatTextBox(inpVoter1, null, null);
		
		inpVoter2 = new JTextField();
		inpVoter2.setColumns(10);
		inpVoter2.setBounds(50, 220, 24, 22);
		frame.getContentPane().add(inpVoter2);
		Util.formatTextBox(inpVoter2, null, null);
		
		inpVoter3 = new JTextField();
		inpVoter3.setColumns(10);
		inpVoter3.setBounds(50, 260, 24, 22);
		frame.getContentPane().add(inpVoter3);
		Util.formatTextBox(inpVoter3, null, null);
		
		inpVoter4 = new JTextField();
		inpVoter4.setColumns(10);
		inpVoter4.setBounds(50, 303, 24, 22);
		frame.getContentPane().add(inpVoter4);
		Util.formatTextBox(inpVoter4, null, null);
		
		inpVoter5 = new JTextField();
		inpVoter5.setColumns(10);
		inpVoter5.setBounds(50, 345, 24, 22);
		frame.getContentPane().add(inpVoter5);
		Util.formatTextBox(inpVoter5, null, null);
		
		inpVoter6 = new JTextField();
		inpVoter6.setColumns(10);
		inpVoter6.setBounds(50, 384, 24, 22);
		frame.getContentPane().add(inpVoter6);
		Util.formatTextBox(inpVoter6, null, null);
		
		inpVoter7 = new JTextField();
		inpVoter7.setColumns(10);
		inpVoter7.setBounds(50, 427, 24, 22);
		frame.getContentPane().add(inpVoter7);
		Util.formatTextBox(inpVoter7, null, null);
		
		inpVoter8 = new JTextField();
		inpVoter8.setColumns(10);
		inpVoter8.setBounds(50, 473, 24, 22);
		frame.getContentPane().add(inpVoter8);
		Util.formatTextBox(inpVoter8, null, null);

		
		Button submitButton = new Button("Submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		submitButton.setBounds(198, 519, 70, 22);
		frame.getContentPane().add(submitButton);
		Util.formatTextBox(null, submitButton, null);
		
		Button clearButton = new Button("Clear");
		clearButton.setBounds(122, 519, 70, 22);
		frame.getContentPane().add(clearButton);
		Util.formatTextBox(null, clearButton, "UVoting");
		
		Label lblFooter = new Label("Remember...number every box to cast your vote");
		lblFooter.setBounds(10, 550, 267, 16);
		frame.getContentPane().add(lblFooter);
		
	}
	

	
	public static void clearAllInput(String UIName)
	{
			inpVoter1.setText("");
			inpVoter2.setText("");
			inpVoter3.setText("");
			inpVoter4.setText("");
			inpVoter5.setText("");
			inpVoter6.setText("");
			inpVoter7.setText("");
			inpVoter8.setText("");
	}
}
