package com.rmit;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Button;

@SuppressWarnings({ "unused", "serial" })
public class Authentication extends JFrame 
{

	private JPanel contentPane;
	private static JTextField inpUserName;
	private static JTextField inpPassword;
	private static Authentication authenticationObj = new Authentication();

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
					authenticationObj.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}

			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Authentication() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 304, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("User Name :");
		lblUsername.setBounds(10, 66, 76, 14);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel_1 = new JLabel("Password   : ");
		lblNewLabel_1.setBounds(10, 107, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblHeading = new JLabel("<html><B><I>UVote System</I></B></html>");
		lblHeading.setBounds(107, 11, 96, 20);
		contentPane.add(lblHeading);
		
		inpUserName = new JTextField();
		inpUserName.setToolTipText("Enter User Name");
		Util.setPlaceHolder(inpUserName, "Enter Username");
		inpUserName.setBounds(96, 63, 169, 20);
		inpUserName.setColumns(10);
		inpUserName.setActionCommand("AuthenticationLogin");
		Util.invokeEnterEvent(null, inpUserName, "AuthenticationLogin");
		contentPane.add(inpUserName);

		inpPassword = new JTextField();
		inpPassword.setToolTipText("Enter Password");
		Util.setPlaceHolder(inpPassword, "Enter Password");
		inpPassword.setColumns(10);
		inpPassword.setBounds(96, 104, 169, 20);
		contentPane.add(inpPassword);
		
		Button loginBut = new Button("Login");
		loginBut.setBounds(195, 209, 70, 22);
		contentPane.add(loginBut);
		loginBut.setActionCommand("AuthenticationLogin");
		Util.invokeEnterEvent(loginBut, null, "AuthenticationLogin");
		Button clearBut = new Button("Clear");
		clearBut.setBounds(98, 209, 70, 22);
		contentPane.add(clearBut);
		Util.formatTextBox(null, clearBut, "Authentication");
	}
	
	public static void clearAllInput(String UIName)
	{
		if(UIName.equals("Authentication"))
		{
			inpUserName.setText("");
			inpPassword.setText("");
		}
	}
	
	public static void onLogin()
	{
		try 
		{
			if(Users.validateUser(inpUserName.getText().trim(), inpPassword.getText().trim()))
			{
				authenticationObj.setVisible(false);
				UVoteUI window = new UVoteUI();
				window.frame.setVisible(true);
			}
			else
			{
				System.out.println("User Not Found in DB");
			}
		} 
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}
	}
	
}
